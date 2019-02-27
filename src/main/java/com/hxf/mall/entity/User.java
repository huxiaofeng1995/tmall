package com.hxf.mall.entity;

public class User {

	private int id;
	
	private String password;
	private String name;	
	private String salt;	

	private String anonymousName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalt() {
		return salt;
		
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	//获取匿名
	public String getAnonymousName(){
		if(null!=anonymousName)
			return anonymousName;
		if(null==name)
			anonymousName= null;
		else if(name.length()<=1)
			anonymousName = "*";
		else if(name.length()==2)
			anonymousName = name.substring(0,1) +"*";
		else {
			char[] cs =name.toCharArray();
			for (int i = 1; i < cs.length-1; i++) {
				cs[i]='*';
			}
			anonymousName = new String(cs);			
		}
		return anonymousName;
	}

	public void setAnonymousName(String anonymousName) {
		this.anonymousName = anonymousName;
	}
	
	
}
