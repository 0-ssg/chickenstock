package ssg.com.a.dto;

import java.io.Serializable;
							// 직렬화   obj1, obj2
public class UserDto implements Serializable{

	private String user_id;
	private String user_name;
	private String password;
	private String birthday;
	private String sex;
	private int phone_number;
	private String address;
	private String nick_name;
	private int auth;		// 사용자:3 관리자:1
	private String email;
	
	public UserDto() {
	}

	public UserDto(String user_id, String user_name, String password, String birthday, String sex, int phone_number,
			String address, String nick_name, int auth, String email) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.phone_number = phone_number;
		this.address = address;
		this.nick_name = nick_name;
		this.auth = auth;
		this.email = email;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", birthday="
				+ birthday + ", sex=" + sex + ", phone_number=" + phone_number + ", address=" + address + ", nick_name="
				+ nick_name + ", auth=" + auth + ", email=" + email + "]";
	}

	
		
}
