package com.holly.domain;
/**
 * 
 * @author keer
 * @time   ����3:07:06
 * �����־û��࣬�����û��Ļ�����Ϣ
 *
 */

import java.util.Set;

public class Users {
	// a.���������䡢��ַ����λ�����䡢��¼�ʺš���¼����
	private Integer id;// ����id
	private String name;// �û���
	private int age;// �û�����
	private String address;// ��ַ
	private String company;// ������λ
	private String email;// ����
	private String account;// �˺�
	private String password;// ����
	private String buyCar;// ���ﳵ
	private int prodCount;// �����Ʒ����

	private int isAdmin = 0;// �Ƿ��ǹ���Ա

	private String rememberMe;// ��Ӽ�ס�ҵĹ���

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
