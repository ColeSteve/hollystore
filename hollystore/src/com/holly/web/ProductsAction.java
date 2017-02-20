package com.holly.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.authenticator.SavedRequest;

import com.google.gson.Gson;
import com.holly.domain.Products;
import com.holly.domain.UserProd;
import com.holly.domain.Users;
import com.holly.service.IProductsService;
import com.mchange.v2.async.StrandedTaskReporting;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;

import oracle.net.aso.l;

public class ProductsAction extends BaseAction implements ModelDriven<Products> {

	private static final long serialVersionUID = 1L;

	private IProductsService productsService;
	private Products products;
	private String pid;
	private File myFile;
	private String myFileFileName;// ���ƹ̶���ʽ��ǰ����һ�����ļ���

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setProductsService(IProductsService productsService) {
		this.productsService = productsService;
	}

	// ��ʾ����ͨѶ���Ʒ
	public String connection() {
		List<Products> list = productsService.showProductsWithConn();
		request.setAttribute("prodList", list);
		return "showProducts";
	}

	// ��ʾ����������Ʒ
	public String software() {
		List<Products> list = productsService.showProductsWithSoft();
		request.setAttribute("prodList", list);
		return "showProducts";
	}

	// ��ʾ�����������Ʒ
	public String life() {
		List<Products> list = productsService.showProductsWithLife();
		request.setAttribute("prodList", list);
		return "showProducts";
	}

	// ��ʾ��Ʒ������Ϣ
	public String info() {
		Products products2 = productsService.getProdInfo(Integer.parseInt(pid));
		request.setAttribute("products", products2);
		return "info";
	}

	// �����Ʒ
	public String buyProduct() {
		// ��session���л�ȡ��ǰ�û���Ϣ
		HttpSession session = request.getSession();
		Users users2 = (Users) session.getAttribute("currentUser");
		productsService.updateProduct(pid, users2);
		   try {
				PrintWriter out=response.getWriter();
				out.write("��ã�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "buyProduct";
	}

	// ��ʾ���ﳵ��Ϣ
	public String myBuyCar() {
		HttpSession session = request.getSession();
		Users users2 = (Users) session.getAttribute("currentUser");
		List<UserProd> list = productsService.getBuyCarInfo(users2.getName());
		request.setAttribute("buyCar", list);
		return "myBuyCar";
	}

	// ��ת����Ӳ�Ʒ�Ľ���
	public String addProducts() {

		return "addProducts";
	}

	// �����Ʒ��Ϣ
	public String saveProdInfo() {
		products.setProdImg(myFileFileName);
		productsService.saveProdInfo(products);
		return "saveProdInfo";
	}

	// չʾ������Ʒ
	public String showAllProducts() {

		List<Products> list = productsService.showAllProducts();
		request.setAttribute("allProducts", list);
		return "showAllProducts";
	}

	// �鿴���
	public String checkProdStore() {
		List<Products> list = productsService.showAllProducts();
		request.setAttribute("allProducts", list);
		return "checkProdStore";
	}
	
	//��Ʒ�¼�
	public String deleProduct() {
		
		productsService.deleteProduct(pid);
		return "deleProduct";
	}
	

	@Override
	public Products getModel() {
		if (products == null) {
			products = new Products();
		}
		return products;
	}

}
