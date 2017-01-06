package com.jay.entity;

import java.util.Date;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-29 时间：上午11:33:53
 *@version 1.0
 */
public class User {
	/**
	 * id
	 */
	private String userId;
	/**
	 * 真实姓名
	 */
	private String userRealName;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPassword;
	/**
	 * 盐
	 */
	private String userSalt;
	/**
	 * 电话
	 */
	private Long userTelphone;
	/**
	 * 性别:1为女,0为男 ,2为保密
	 */
	private char userSex;
	/**
	 * 邮件
	 */
	private String userEmali;
	/**
	 * 生日
	 */
	private Date userBirthday;
	/**
	 * 身份证
	 */
	private String userIdCard;
	/**
	 * 注册时间
	 */
	private Date userCreatTime;
	/**
	 * 	是否激活.0为未激活,1为激活
	 */
	private char userActivate;
	/**
	 * 用户头像
	 */
	private String usetIcon;
	/**
	 * 用户状态,0为冻结,1为正常
	 */
	private char userState;
	/**
	 * 用户最后登录时间 
	 */
	private Date userLastLoginDate;
	//----------------以上为属性-----------------
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String userRealName, String userName,
			String userPassword, String userSalt, Long userTelphone,
			char userSex, String userEmali, Date userBirthday,
			String userIdCard, Date userCreatTime, char userActivate,
			String usetIcon, char userState, Date userLastLoginDate) {
		super();
		this.userId = userId;
		this.userRealName = userRealName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSalt = userSalt;
		this.userTelphone = userTelphone;
		this.userSex = userSex;
		this.userEmali = userEmali;
		this.userBirthday = userBirthday;
		this.userIdCard = userIdCard;
		this.userCreatTime = userCreatTime;
		this.userActivate = userActivate;
		this.usetIcon = usetIcon;
		this.userState = userState;
		this.userLastLoginDate = userLastLoginDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRealName=" + userRealName
				+ ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userSalt=" + userSalt + ", userTelphone=" + userTelphone
				+ ", userSex=" + userSex + ", userEmali=" + userEmali
				+ ", userBirthday=" + userBirthday + ", userIdCard="
				+ userIdCard + ", userCreatTime=" + userCreatTime
				+ ", userActivate=" + userActivate + ", usetIcon=" + usetIcon
				+ ", userState=" + userState + ", userLastLoginDate="
				+ userLastLoginDate + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSalt() {
		return userSalt;
	}
	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}
	public Long getUserTelphone() {
		return userTelphone;
	}
	public void setUserTelphone(Long userTelphone) {
		this.userTelphone = userTelphone;
	}
	public char getUserSex() {
		return userSex;
	}
	public void setUserSex(char userSex) {
		this.userSex = userSex;
	}
	public String getUserEmali() {
		return userEmali;
	}
	public void setUserEmali(String userEmali) {
		this.userEmali = userEmali;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public Date getUserCreatTime() {
		return userCreatTime;
	}
	public void setUserCreatTime(Date userCreatTime) {
		this.userCreatTime = userCreatTime;
	}
	public char getUserActivate() {
		return userActivate;
	}
	public void setUserActivate(char userActivate) {
		this.userActivate = userActivate;
	}
	public String getUsetIcon() {
		return usetIcon;
	}
	public void setUsetIcon(String usetIcon) {
		this.usetIcon = usetIcon;
	}
	public char getUserState() {
		return userState;
	}
	public void setUserState(char userState) {
		this.userState = userState;
	}
	public Date getUserLastLoginDate() {
		return userLastLoginDate;
	}
	public void setUserLastLoginDate(Date userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}
	
	
}	
