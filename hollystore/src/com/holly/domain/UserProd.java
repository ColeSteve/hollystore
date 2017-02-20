package com.holly.domain;

/**
 * 
 * @author keer
 * @time 下午2:01:36 用户产品信息表
 *
 */
public class UserProd {
	private Integer id;
	private String name;// 用户名
	private String prodName;//产品名
	private String prodDesc;// 产品描述
	private int prodStore;// 购买量
	private String prodImg;//产品图片地址

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
