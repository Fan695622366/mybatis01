package a.dao;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;

public class UserDao {

	public void addUser1() {
		// 声明一个SqlSessin对象
		SqlSession sqlSession = null;

		try {
			// 获取到SqlSession对象
			sqlSession = MybatisUtil.getSqlSession();

			int line = sqlSession.insert("com.zyz.a.entity.User.addUser1");
			System.out.println("影响了" + line + "行");

			/**
			 * 最后一定要提交事务
			 */
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();

			/**
			 * 如果遇到异常,则回滚
			 */
			sqlSession.rollback();
		} finally {
			/**
			 * 最后一定要记得关闭释放资源
			 */
			MybatisUtil.closeSqlSession();
		}
	}

}
