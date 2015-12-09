package dal;

import java.util.List;

import dto.EnquiryDetail;

public interface StaffService {
	public List<EnquiryDetail> getEnquiryList();
	public List<EnquiryDetail> getTodaysEnquiryList();
	public int handledEnquiries(String username);
	public void deleteEnquiry(int id);
	public void processEnquiry(int id);
	public void enquiryhandled(int enquiries, String username);
}
