package b_dynamic_crud.test;

import java.util.List;

import org.junit.Test;

import b_dynamic_crud.dao.UserDao;
import b_dynamic_crud.entity.User;

public class TestUserDao {

	UserDao dao = new UserDao();
	
	@Test
	public void test1() {
		
		List<User> list = dao.findUserByCondition(null,null,null,null);
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void test2() {
		
		List<User> list = dao.findUserByCondition(1,null,null,null);
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void test3() {
		
		dao.updateUser(1, null, null, 77.77);

	}
}
