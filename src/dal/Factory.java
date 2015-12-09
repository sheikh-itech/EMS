package dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {

static Session session = null;
	
	static {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	public static Session getSession(){
		return session;
	}
}
