package attsd.exam.spring.loginservice.project.model;

public class UserDTO {
	
	private String email;
	private String password;
	private String username;
	private String usernumber;
	
	public UserDTO(String email, String password, String username, String usernumber) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.usernumber= usernumber;	
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

}
