package com.holly.domain;
/**
 * 
 * @author keer
 * @time   下午4:02:54
 * 持久化类，对应产品信息表
 *
 */
public class Products {
//a.产品表包含：产品名称、产品库存、产品类别、产品说明
	
	private Integer id;//主键ID
	private String  prodName;//产品名称
	private int prodStore;//产品库存
	private String prodType;//产品类别
	private String prodDesc;//产品说明
	private String prodImg;//产品图片
	
	
	
//Setter,Getter
	
	public Integer getId() {
		return id;
	}
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdStore() {
		return prodStore;
	}
	public void setProdStore(int prodStore) {
		this.prodStore = prodStore;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", prodName=" + prodName + ", prodStore=" + prodStore + ", prodType=" + prodType
				+ ", prodDesc=" + prodDesc + ", prodImg=" + prodImg + "]";
	}
	
	
	
	
}
