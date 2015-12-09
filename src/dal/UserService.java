package dal;

import java.util.List;

import dto.Enquiry;
import dto.EnquiryDetail;
import dto.Users;

public interface UserService {

	public void saveUserDetails(Users users);
	public List<Users> getUserDetails();
	public String validateUser(String username, String password);
	public void saveEnquiry(Enquiry enquiry);
	public int getMaxId();
	public List<EnquiryDetail> getEnquiryList(String username);
	public void updateEnquiry(String desc, int id);
	public EnquiryDetail getEnquiryDetail(int id);
}
