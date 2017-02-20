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
	private String condition;// ������ѯ������
	private String value;// ������ѯ��ֵ
	private String username;// �������ֻ��Զ�Ӧ�û���Ϣ
	private String idCode;// ��֤��
	


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

	// ��ѯ�����û�
	public String list() {
		List<Users> list = userService.findAllUsers();
		request.setAttribute("userList", list);
		return "list";
	}

	// ��ѯ�û���Ϣ����֤�û���¼
	public String login() throws UnsupportedEncodingException {
		//���ס�ҵĹ���
		StringUtils.addCookies(request, response, users);
		
		// ȡ��Session�е���֤��
		String sCode = (String) request.getSession().getAttribute("icode");
		request.getSession().removeAttribute("icode");
	
		// ��֤����ȣ��ͽ����û���Ϣ��֤
		if (sCode!=null&&sCode.equals(idCode)) {
			Users users2 = userService.allowLogin(users);
			List<Products> list = productsService.showAllProducts();
			request.setAttribute("user", users2);
			// ��¼������ҳ�棬չʾ���в�Ʒ
			request.setAttribute("allProducts", list);
			if (users2 != null) {
				return "loginSuccess";
			} else {
				addFieldError("loginError", "��������˻���Ϣ����");
				return "loginError";
			}
		} else {
			addFieldError("loginError", "���������֤������");
			return "loginError";
		}

	}

	// ��ת��������������
	public String search() {
		return "search";
	}

	// ��������(�û�������ַ)���в�ѯ
	public String searchUserByCondition() {
		List<Users> list = userService.searchUserByCondition(condition, value);
		request.setAttribute("userList", list);
		return "condition";
	}

	// ��ת���޸��û���Ϣҳ��
	public String updateUsers() {

		Users users2 = userService.findUserByName(username);
		// �R��ֵջ�����ڱ�����
		ActionContext.getContext().getValueStack().push(users2);
		return "updateUsers";
	}

	// �����û���Ϣ
	public String update() {
		userService.updateUsers(users);
		return "deleteUser";
	}

	// ɾ��ָ�����û�
	public String deleteUser() {
		Users users2 = userService.findUserByName(username);
		userService.deleteUser(users2);
		return "deleteUser";
	}

	// ����µ��û�
	public String saveUser() {
		userService.saveUser(users);
		return null;
	}
	
	//�����û�
	public String updateUser() {
		
		userService.updateUsers(users);
		return null;
	}

	// �û�ע��
	public String register() {

		
		userService.saveUser(users);
		return "register";
	}

	//����Excel���
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
