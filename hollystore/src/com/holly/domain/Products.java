package com.holly.domain;
/**
 * 
 * @author keer
 * @time   ����4:02:54
 * �־û��࣬��Ӧ��Ʒ��Ϣ��
 *
 */
public class Products {
//a.��Ʒ���������Ʒ���ơ���Ʒ��桢��Ʒ��𡢲�Ʒ˵��
	
	private Integer id;//����ID
	private String  prodName;//��Ʒ����
	private int prodStore;//��Ʒ���
	private String prodType;//��Ʒ���
	private String prodDesc;//��Ʒ˵��
	private String prodImg;//��ƷͼƬ
	
	
	
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
