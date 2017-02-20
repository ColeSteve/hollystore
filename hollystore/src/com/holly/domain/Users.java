package com.holly.domain;
/**
 * 
 * @author keer
 * @time   下午3:07:06
 * 创建持久化类，保存用户的基本信息
 *
 */

import java.util.Set;

public class Users {
	// a.姓名、年龄、地址、单位、邮箱、登录帐号、登录密码
	private Integer id;// 主键id
	private String name;// 用户名
	private int age;// 用户年龄
	private String address;// 地址
	private String company;// 所属单位
	private String email;// 邮箱
	private String account;// 账号
	private String password;// 密码
	private String buyCar;// 购物车
	private int prodCount;// 购买产品数量

	private int isAdmin = 0;// 是否是管理员

	private String rememberMe;// 添加记住我的功能

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	private Set<Products> products;
	// Getter,Setter

	public Integer getId() {
		return id;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	public String getBuyCar() {
		return buyCar;
	}

	public void setBuyCar(String buyCar) {
		this.buyCar = buyCar;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", company=" + company
				+ ", email=" + email + ", account=" + account + ", password=" + password + "]";
	}

}
