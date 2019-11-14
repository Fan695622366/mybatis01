package a.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import a.dao.UserDao;
import util.MybatisUtil;

public class testUserDao {

	@Test
	public void test1() {

//		SqlSession session = MybatisUtil.getSqlSession();
//		System.out.println(session);

		UserDao dao = new UserDao();
		dao.addUser1();
	}

}
