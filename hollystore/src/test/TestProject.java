package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.google.gson.Gson;
import com.holly.dao.HibernateSessionFactory;
import com.holly.domain.Users;

import net.sf.json.JSONObject;

public class TestProject {

	@Test
	public void test() {
		Session session = HibernateSessionFactory.getSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		Users user = new Users();
		user.setId(2);
		user.setAddress("青年路");
		user.setName("张三");
		user.setAccount("holly2");
		user.setPassword("1234");
		session.save(user);
		transaction.commit();
		session.close();

	}

	@Test
	public void test2() {
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		map.put("name", "Cole");
		String json = gson.toJson(map);
		System.out.println(json);
	}
	
	@Test
	public void test3() {
		JSONObject jobj = new JSONObject();// new一个JSON
		    List<Users> list=new ArrayList<>();
		    Users users=new Users();
		    users.setId(1);
		    users.setAccount("1234");
		    users.setName("cole");
		    users.setEmail("1212We");
		    users.setCompany("qwqw");
		    
		    Users users2=new Users();
		    users2.setId(1);
		    users2.setAccount("1234");
		    users2.setName("cole");
		    users2.setEmail("1212We");
		    users2.setCompany("qwqw");
		    
		    list.add(users);
		    list.add(users2);
		    
			jobj.accumulate("total", new Long(3));// total代表一共有多少数据
			jobj.accumulate("rows", list);
			System.out.println(list);
			System.out.println(jobj.toString());
	
	}
	
	@Test
	public void test4() throws IOException {
		 List<Users> list=new ArrayList<>();
		    Users users=new Users();
		    users.setId(1);
		    users.setAccount("1234");
		    users.setName("cole");
		    users.setEmail("1212We");
		    users.setCompany("qwqw");
		    
		    Users users2=new Users();
		    users2.setId(1);
		    users2.setAccount("1234");
		    users2.setName("cole");
		    users2.setEmail("1212We");
		    users2.setCompany("qwqw");
		    
		    list.add(users);
		    list.add(users2);
		    Long long1=new Long(3);
		toBeJson(list, long1);
		
	}
	
	public void toBeJson(List<Users> list, Long total) throws IOException {
		//HttpServletResponse response = ServletActionContext.getResponse();
		//HttpServletRequest request = ServletActionContext.getRequest();

		JSONObject jobj = new JSONObject();// new一个JSON

		jobj.accumulate("total", total);// total代表一共有多少数据
		System.out.println(jobj.toString());
		jobj.accumulate("rows", list);// row是代表显示的页的数据
        
		
		System.out.println(jobj.toString());
		//response.getWriter().write(jobj.toString());// 转化为JSOn格式

		
	}
}
