package dal;

import org.hibernate.Session;

import dto.Users;

public class HiberTest {

	public static void main(String [] args){
		Users r = new Users();
		r.setUsername("sheikh1");
		r.setName("sheikh");
		r.setContact(124785);
		r.setPassword("sheikh");
		r.setType("student");
		
		
		Session session = Factory.getSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	}
}
