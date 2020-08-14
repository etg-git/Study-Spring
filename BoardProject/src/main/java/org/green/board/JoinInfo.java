package org.green.board;

public class JoinInfo {
	
	private String id;
	private String name;
	private String password;
	private String nickName;
	
	public JoinInfo(String id, String name, String password, String nickName) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nickName = nickName;
	}
	public JoinInfo() {
		super();
	}
	public String getId() {
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
	public void setId(String id) {
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
	@Override
	public String toString() {
		return "JoinInfo [id=" + id + ", name=" + name + ", password=" + password + ", nickName=" + nickName + ", tel="
				 + "]";
	}
	
}
