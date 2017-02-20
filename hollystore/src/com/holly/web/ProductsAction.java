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
	private String myFileFileName;// 名称固定格式：前部分一定是文件名

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

	// 显示所有通讯类产品
	public String connection() {
		List<Products> list = productsService.showProductsWithConn();
		request.setAttribute("prodList", list);
		return "showProducts";
	}

	// 显示所有软件类产品
	public String software() {
		List<Products> list = productsService.showProductsWithSoft();
		request.setAttribute("prodList", list);
		return "showProducts";
	}

	// 显示所有生活类产品
	public String life() {
		List<Products> list = productsService.showProductsWithLife();
		request.setAttribute("prodList", list);
		return "showProducts";
	}

	// 显示产品具体信息
	public String info() {
		Products products2 = productsService.getProdInfo(Integer.parseInt(pid));
		request.setAttribute("products", products2);
		return "info";
	}

	// 购买产品
	public String buyProduct() {
		// 从session当中获取当前用户信息
		HttpSession session = request.getSession();
		Users users2 = (Users) session.getAttribute("currentUser");
		productsService.updateProduct(pid, users2);
		   try {
				PrintWriter out=response.getWriter();
				out.write("你好！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "buyProduct";
	}

	// 显示购物车信息
	public String myBuyCar() {
		HttpSession session = request.getSession();
		Users users2 = (Users) session.getAttribute("currentUser");
		List<UserProd> list = productsService.getBuyCarInfo(users2.getName());
		request.setAttribute("buyCar", list);
		return "myBuyCar";
	}

	// 跳转到添加产品的界面
	public String addProducts() {

		return "addProducts";
	}

	// 保存产品信息
	public String saveProdInfo() {
		products.setProdImg(myFileFileName);
		productsService.saveProdInfo(products);
		return "saveProdInfo";
	}

	// 展示所有商品
	public String showAllProducts() {

		List<Products> list = productsService.showAllProducts();
		request.setAttribute("allProducts", list);
		return "showAllProducts";
	}

	// 查看库存
	public String checkProdStore() {
		List<Products> list = productsService.showAllProducts();
		request.setAttribute("allProducts", list);
		return "checkProdStore";
	}
	
	//产品下架
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
