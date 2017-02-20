package com.holly.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.holly.domain.Products;
import com.holly.domain.Users;
import com.holly.service.IProductsService;
import com.holly.service.IUserService;
import com.holly.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

public class UserAction extends BaseAction implements ModelDriven<Users> {
	private static final long serialVersionUID = 1L;

	private Users users;
	private IUserService userService;
	private IProductsService productsService;
	private String condition;// 条件查询的条件
	private String value;// 条件查询的值
	private String username;// 根据名字回显对应用户信息
	private String idCode;// 验证码
	


	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getValue() {
		try {
			value = new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setProductsService(IProductsService productsService) {
		this.productsService = productsService;
	}

	// 查询所有用户
	public String list() {
		List<Users> list = userService.findAllUsers();
		request.setAttribute("userList", list);
		return "list";
	}

	// 查询用户信息，验证用户登录
	public String login() throws UnsupportedEncodingException {
		//添记住我的功能
		StringUtils.addCookies(request, response, users);
		
		// 取得Session中的验证码
		String sCode = (String) request.getSession().getAttribute("icode");
		request.getSession().removeAttribute("icode");
	
		// 验证码相等，就进行用户信息验证
		if (sCode!=null&&sCode.equals(idCode)) {
			Users users2 = userService.allowLogin(users);
			List<Products> list = productsService.showAllProducts();
			request.setAttribute("user", users2);
			// 登录进入主页面，展示所有产品
			request.setAttribute("allProducts", list);
			if (users2 != null) {
				return "loginSuccess";
			} else {
				addFieldError("loginError", "您输入的账户信息有误！");
				return "loginError";
			}
		} else {
			addFieldError("loginError", "您输入的验证码有误！");
			return "loginError";
		}

	}

	// 跳转到条件搜索界面
	public String search() {
		return "search";
	}

	// 根据条件(用户名、地址)进行查询
	public String searchUserByCondition() {
		List<Users> list = userService.searchUserByCondition(condition, value);
		request.setAttribute("userList", list);
		return "condition";
	}

	// 跳转到修改用户信息页面
	public String updateUsers() {

		Users users2 = userService.findUserByName(username);
		// 圧入值栈，用于表单回显
		ActionContext.getContext().getValueStack().push(users2);
		return "updateUsers";
	}

	// 更新用户信息
	public String update() {
		userService.updateUsers(users);
		return "deleteUser";
	}

	// 删除指定的用户
	public String deleteUser() {
		Users users2 = userService.findUserByName(username);
		userService.deleteUser(users2);
		return "deleteUser";
	}

	// 添加新的用户
	public String saveUser() {
		userService.saveUser(users);
		return null;
	}
	
	//更新用户
	public String updateUser() {
		
		userService.updateUsers(users);
		return null;
	}

	// 用户注册
	public String register() {

		
		userService.saveUser(users);
		return "register";
	}

	//导出Excel表格
	public String  export() throws Exception {
		userService.export();
		return null;
	}
	
	@Override
	public Users getModel() {
		if (users == null) {
			users = new Users();
		}
		return users;
	}

}
