package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dto.Enquiry;
import dto.EnquiryDetail;
import dto.Users;

public class UserServiceImpl implements UserService {

	public void updateEnquiry(String desc, int id){
		try {
			Connection con = Utility.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate("update enquiry set DESCRIPTION ='"+desc+"' where id="+id);
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	@Override
	public EnquiryDetail getEnquiryDetail(int id) {
		// TODO Auto-generated method stub
		EnquiryDetail enquiryDetail = new EnquiryDetail();
		try {
			Connection con = Utility.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select description, id from  enquiry  where id="+id);

			while (rs.next()) {
				
				enquiryDetail.setDescription(rs.getString(1));
				enquiryDetail.setId(rs.getInt(2));
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return enquiryDetail;
	}
	@Override
	public List<EnquiryDetail> getEnquiryList(String username) {
		// TODO Auto-generated method stub
		List<EnquiryDetail> enquiryDetail = new ArrayList<>();
		try {
			Connection con = Utility.getConnection();
			PreparedStatement ps = con.prepareStatement("select e.id,u.name,u.contact, e.description from users u, enquiry e where e.username=? and u.username=?");
			ps.setString(1, username);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EnquiryDetail ed = new EnquiryDetail();
				ed.setId(rs.getInt(1));
				ed.setName(rs.getString(2));
				ed.setContact(rs.getLong(3));
				ed.setDescription(rs.getString(4));

				enquiryDetail.add(ed);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return enquiryDetail;
	}

	@Override
	public void saveEnquiry(Enquiry enquiry) {
		// TODO Auto-generated method stub
		Session session = Factory.getSession();

		session.beginTransaction();

		session.save(enquiry);

		session.getTransaction().commit();
		session.flush();
		session.clear();

	}

	public int getMaxId() {

		Session session = Factory.getSession();
		session.beginTransaction();
		Query query = session.createQuery("select max(id) from Enquiry");
		int maxId = -1;
		try{
			if(query == null) maxId = 1;
			else
			maxId = (int) query.uniqueResult();
		}catch(Exception e)
		{
			maxId = 1;
		}
		return maxId;
	}

	@Override
	public void saveUserDetails(Users users) {
		// TODO Auto-generated method stub

		Session session = Factory.getSession();

		session.beginTransaction();

		session.save(users);

		session.getTransaction().commit();

	}

	@Override
	public List<Users> getUserDetails() {
		// TODO Auto-generated method stub

		Session session = Factory.getSession();

		session.beginTransaction();

		Query query = session.createQuery("from Users");

		List<Users> users = query.list();

		return users;
	}

	public String validateUser(String username, String password) {

		Session session = Factory.getSession();
		session.beginTransaction();
		Query query = session.createQuery("select type from Users where username=:name and password=:pass");
		query.setString("name", username);
		query.setString("pass", password);

		String nametype = (String) query.uniqueResult();

		return nametype;
	}

	private UserServiceImpl() {

	}

	public static UserService getUserService() {

		return new UserServiceImpl();
	}
}
