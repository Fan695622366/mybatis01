package a.test;

import org.junit.Test;

import a.dao.UserDao;

public class testUserDao {

	@Test
	public void test1() {

//		SqlSession session = MybatisUtil.getSqlSession();
//		System.out.println(session);

		UserDao dao = new UserDao();
		dao.addUser1();
	}

}
