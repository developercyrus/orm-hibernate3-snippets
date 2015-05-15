package orm.hibernate.one2many.example1.jndi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class MysqlJndiServer {
    public static void main(String[] args) {		
        try {
            Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            properties.put(Context.PROVIDER_URL, "rmi://localhost:1099");
            InitialContext context = new InitialContext(properties);
            
            MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("");
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("orm_hibernate_one2many_example1");
            
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry Stared.");
            
            context.rebind("jdbc/mysql", dataSource);     
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }  				
    }	
}
