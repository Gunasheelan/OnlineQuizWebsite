package com.login.model;

public class Student {
        private String userName;
	private int rollNo;
	private String passWord;
        
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Student [userName=" + userName + ", rollNo=" + rollNo + ", passWord=" + passWord + "]";
	}

}
