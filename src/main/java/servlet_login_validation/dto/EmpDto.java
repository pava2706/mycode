package servlet_login_validation.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpDto {
	@Id
	private String email;
	private String name;
	private String pwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
