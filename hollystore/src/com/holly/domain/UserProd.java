package com.holly.domain;

/**
 * 
 * @author keer
 * @time ����2:01:36 �û���Ʒ��Ϣ��
 *
 */
public class UserProd {
	private Integer id;
	private String name;// �û���
	private String prodName;//��Ʒ��
	private String prodDesc;// ��Ʒ����
	private int prodStore;// ������
	private String prodImg;//��ƷͼƬ��ַ

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public int getProdStore() {
		return prodStore;
	}

	public void setProdStore(int prodStore) {
		this.prodStore = prodStore;
	}

}
