package orm.hibernate.one2many.example1.dao.client;

import org.junit.Test;

import orm.hibernate.one2many.example1.dao.client.StudentDaoClient;
import static org.junit.Assert.assertEquals;

public class StudentDaoClientIT {	
    @Test
    public void test1() throws Exception {
    	String actual = StudentDaoClient.getMaryTCFirstname();
        System.out.println(actual);
        
        assertEquals("瑪麗", actual);
    }   
    
    @Test
    public void test2() throws Exception {
    	StudentDaoClient.addJohn();
    	String actual = StudentDaoClient.getJohnSCFirstname();
    	StudentDaoClient.deleteJohn();
        System.out.println(actual);
        
        assertEquals("约翰", actual);
    }
}
