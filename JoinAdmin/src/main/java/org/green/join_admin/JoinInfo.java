package org.green.join_admin;

public class JoinInfo {
	private int id;
	private String name;
	private String password;
	private String nickName;
	private String tel;
	public JoinInfo(int id, String name, String password, String nickName, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.tel = tel;
	}
	public JoinInfo() {
		super();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getNickName() {
		return nickName;
	}
	public String getTel() {
		return tel;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "JoinInfo [id=" + id + ", name=" + name + ", password=" + password + ", nickName=" + nickName + ", tel="
				+ tel + "]";
	}
	
}
