package orm.hibernate.one2many.example1.gen;
// Generated May 12, 2015 7:14:22 PM by Hibernate Tools 3.2.4.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class StudentLoc.
 * @see orm.hibernate.one2many.example1.gen.StudentLoc
 * @author Hibernate Tools
 */
public class StudentLocHome {

    private static final Log log = LogFactory.getLog(StudentLocHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(StudentLoc transientInstance) {
        log.debug("persisting StudentLoc instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(StudentLoc instance) {
        log.debug("attaching dirty StudentLoc instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(StudentLoc instance) {
        log.debug("attaching clean StudentLoc instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(StudentLoc persistentInstance) {
        log.debug("deleting StudentLoc instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public StudentLoc merge(StudentLoc detachedInstance) {
        log.debug("merging StudentLoc instance");
        try {
            StudentLoc result = (StudentLoc) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public StudentLoc findById( orm.hibernate.one2many.example1.gen.StudentLocId id) {
        log.debug("getting StudentLoc instance with id: " + id);
        try {
            StudentLoc instance = (StudentLoc) sessionFactory.getCurrentSession()
                    .get("orm.hibernate.one2many.example1.gen.StudentLoc", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List findByExample(StudentLoc instance) {
        log.debug("finding StudentLoc instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("orm.hibernate.one2many.example1.gen.StudentLoc")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}

