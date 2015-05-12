package orm.hibernate.one2many.example1.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import orm.hibernate.one2many.example1.gen.Student;

public class StudentDao {
	
    public List<Object[]> findStudentInfoById(int id) {
    	Configuration config = new Configuration().configure("/orm/hibernate/one2many/example1/hibernate.cfg.xml");          
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("select s.id, s.sex, sl.language, sl.firstname, s.createDate from Student as s inner join s.studentLocs as sl where s.id = :studentId");
        query.setParameter("studentId", id);   
        List<Object[]> list = query.list();  
        
        session.close();
        sessionFactory.close(); 
        
        return list;
    }
    
    public List<Object[]> findStudentInfoByIdByNative(int id) {
    	Configuration config = new Configuration().configure("/orm/hibernate/one2many/example1/hibernate.cfg.xml");          
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        SQLQuery query = session.createSQLQuery("select {s.*}, sl.language_id as language_id, sl.firstname as firstname from student as s inner join student_loc sl on s.id = sl.student_id where s.id = :studentId");
		query.addEntity("s", Student.class);
		query.addScalar("language_id", new IntegerType());
		query.addScalar("firstname", new StringType());
        query.setParameter("studentId", id);   
        List<Object[]> list = query.list();  
        
        session.close();
        sessionFactory.close(); 
        
        return list;
    }
    
    public List<Student> findStudentByName(String name) {
    	Configuration config = new Configuration().configure("/orm/hibernate/one2many/example1/hibernate.cfg.xml");          
        SessionFactory sessionFactory = config.buildSessionFactory();        
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("select s from Student as s inner join s.studentLocs as sl where sl.firstname like ? order by s.createDate desc");
        query.setString(0, "%"+name+"%");
        
        List<Student> students = query.list();  
       
        session.flush();
        session.close();
        sessionFactory.close(); 
        
        return students;
    }
    
    
    
    public void saveStudent(Student student) {
    	Configuration config = new Configuration().configure("/orm/hibernate/one2many/example1/hibernate.cfg.xml");          
        SessionFactory sessionFactory = config.buildSessionFactory();        
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(student);     
        tx.commit();
        
        session.flush();
        session.close();
        sessionFactory.close(); 
    }
    
    public void deleteStudent(Student student) {
    	Configuration config = new Configuration().configure("/orm/hibernate/one2many/example1/hibernate.cfg.xml");          
        SessionFactory sessionFactory = config.buildSessionFactory();        
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.delete(student);     
        tx.commit();
        
        session.flush();
        session.close();
        sessionFactory.close(); 
    }
    
}
