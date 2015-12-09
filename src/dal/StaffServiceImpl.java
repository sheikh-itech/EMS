package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EnquiryDetail;

public class StaffServiceImpl implements StaffService {

	private StaffServiceImpl() {

	}

	public static StaffService getService() {
		return new StaffServiceImpl();
	}

	@Override
	public List<EnquiryDetail> getEnquiryList() {
		// TODO Auto-generated method stub
		List<EnquiryDetail> enquiryDetail = new ArrayList<>();
		try {
			Connection con = Utility.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select e.id,u.name,u.contact, e.description,e.status from users u, enquiry e where e.username = u.username");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EnquiryDetail ed = new EnquiryDetail();
				ed.setId(rs.getInt(1));
				ed.setName(rs.getString(2));
				ed.setContact(rs.getLong(3));
				ed.setDescription(rs.getString(4));
				ed.setStatus(rs.getInt(5));

				enquiryDetail.add(ed);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return enquiryDetail;
	}

	@Override
	public int handledEnquiries(String username) {
		// TODO Auto-generated method stub

		Connection con = Utility.getConnection();
		PreparedStatement ps;
		int count = 0;
		try {
			ps = con.prepareStatement("select enquiry_handled from users where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public void deleteEnquiry(int id) {
		// TODO Auto-generated method stub
		try {
			Connection con = Utility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from enquiry where id = ?");
			ps.setInt(1, id);
			ps.execute();

		} catch (Exception e) {

		}
	}

	@Override
	public void processEnquiry(int id) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = Utility.getConnection();
			PreparedStatement ps = con.prepareStatement("update enquiry set status=1 where id=?");
			ps.setInt(1, id);
			ps.execute();

		} catch (Exception e) {

		}
		
	}

	@Override
	public void enquiryhandled(int enquiries, String username) {
		// TODO Auto-generated method stub
		try {
			Connection con = Utility.getConnection();
			PreparedStatement ps = con.prepareStatement("update users set enquiry_handled=? where username=? and type='Staff'");
			ps.setInt(1, enquiries);
			ps.setString(2, username);
			ps.execute();

		} catch (Exception e) {

		}
	}

	@Override
	public List<EnquiryDetail> getTodaysEnquiryList() {
		// TODO Auto-generated method stub
		List<EnquiryDetail> enquiryDetail = new ArrayList<>();
		try {
			Connection con = Utility.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select e.id,u.name,u.contact, e.description,e.status from users u, enquiry e where e.username = u.username and e.enquiry_date = to_char(sysdate, 'mm-dd-yyyy') and status = 0");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EnquiryDetail ed = new EnquiryDetail();
				ed.setId(rs.getInt(1));
				ed.setName(rs.getString(2));
				ed.setContact(rs.getLong(3));
				ed.setDescription(rs.getString(4));
				ed.setStatus(rs.getInt(5));

				enquiryDetail.add(ed);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return enquiryDetail;

	}
}
