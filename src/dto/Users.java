package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	private String username;
	private String name;
	private String password;
	private long contact;
	private String type;
	private int enquiry_handled;	
	
	public Users(){
		
	}
	
	public int getEnquiry_handaled() {
		return enquiry_handled;
	}

	public void setEnquiry_handaled(int enquiry_handaled) {
		this.enquiry_handled = enquiry_handaled;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
