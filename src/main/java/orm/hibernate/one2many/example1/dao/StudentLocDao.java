package orm.hibernate.one2many.example1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import orm.hibernate.one2many.example1.gen.StudentLoc;

public class StudentLocDao {
	
    public void saveStudentLoc(StudentLoc studentLoc) {
    	Configuration config = new Configuration().configure("/orm/hibernate/one2many/example1/hibernate.cfg.xml");          
        SessionFactory sessionFactory = config.buildSessionFactory();        
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(studentLoc);     
        tx.commit();
        
        session.flush();
        session.close();
        sessionFactory.close(); 
    }
}
