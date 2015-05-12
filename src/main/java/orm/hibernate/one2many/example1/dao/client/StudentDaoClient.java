package orm.hibernate.one2many.example1.dao.client;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import orm.hibernate.one2many.example1.dao.StudentDao;
import orm.hibernate.one2many.example1.dao.StudentLocDao;
import orm.hibernate.one2many.example1.gen.Language;
import orm.hibernate.one2many.example1.gen.Student;
import orm.hibernate.one2many.example1.gen.StudentLoc;
import orm.hibernate.one2many.example1.gen.StudentLocId;

public class StudentDaoClient {
	
	public static void main(String[] args) {
		System.out.println(getMaryTCFirstname());
		addJohn();
		System.out.println(getJohnSCFirstname());
		deleteJohn();
	}
	
	public static String getMaryTCFirstname() {
		StudentDao dao = new StudentDao();
		List<Object[]> list = dao.findStudentInfoById(2);
		for(Object[] o : list){
            Language l = (Language)o[2];
            if (l.getSymbol().equals("TC")) {
            	return (String)o[3];
            }
        }
		return null;
	}	
	
	public static String getJohnSCFirstname() {
		StudentDao dao = new StudentDao();
		Student john = findLastJohn();
		System.out.println(john.getId() + " is newly added John");
		List<Object[]> list = dao.findStudentInfoById(john.getId());
		for(Object[] o : list){
            Language l = (Language)o[2];
            if (l.getSymbol().equals("SC")) {
            	return (String)o[3];
            }
        }
		return null;
	}
	
	public static void addJohn() {
		StudentDao studentDao = new StudentDao();
		StudentLocDao studentLocDao = new StudentLocDao();
		
		Student john = new Student("M", new Date());
		studentDao.saveStudent(john);
		
		Language len = new Language(1, "EN");
		Language ltc = new Language(2, "TC");
		Language lsc = new Language(3, "SC");
		
		StudentLocId slenId = new StudentLocId(john.getId(), len.getId());
		StudentLocId sltcId = new StudentLocId(john.getId(), ltc.getId());
		StudentLocId slscId = new StudentLocId(john.getId(), lsc.getId());
		
		StudentLoc slen = new StudentLoc(slenId, len, john, "John");
		StudentLoc sltc = new StudentLoc(sltcId, ltc, john, "約翰");
		StudentLoc slsc = new StudentLoc(slscId, lsc, john, "约翰");		
			
		studentLocDao.saveStudentLoc(slen);
		studentLocDao.saveStudentLoc(sltc);
		studentLocDao.saveStudentLoc(slsc);
	}
	
	public static Student findLastJohn() {
		StudentDao dao = new StudentDao();
		List<Student> students = dao.findStudentByName("John");
		return students.get(0);
	}
	
	//cascade delete
	public static void deleteJohn() {
		Student john = findLastJohn();
		StudentDao dao = new StudentDao();
		dao.deleteStudent(john);
	}
	
	
}
