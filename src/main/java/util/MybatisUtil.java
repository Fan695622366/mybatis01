package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具类
 */
public class MybatisUtil {

	// 在ThreadLocal中重点方法有三个:get(),set(),remove()
	// 创建局部线程对象,用于和SqlSession绑定
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

	// 声明sqlSessionFactory对象
	private static SqlSessionFactory sqlSessionFactory;

	// 既然是工具类,必须要私有化构造方法
	private MybatisUtil() {

	}

	/**
	 * 静态代码块,为了加载重量级对象<br>
	 * 就是为了获取到SqlSessionFactory对象<br>
	 */
	static {

		try {
			/**
			 * 通过mybatis中的Resource类,加载配置文件到输入流中
			 */
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			/**
			 * 获取到工厂建造者对象
			 */
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			/**
			 * 获取到工厂对象
			 */
			sqlSessionFactory = builder.build(in);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取到SqlSession对象
	 */
	public static SqlSession getSqlSession() {

		// 首先从局部[当前]线程中获取到sqlSession对象
		SqlSession sqlSession = threadLocal.get();

		// 如果在threadLocal中没有拿到对象
		if (sqlSession == null) {
			// 则从sqlSessionFactory工厂对象中拿
			sqlSession = sqlSessionFactory.openSession();
			// 把从sqlSessionFactory中获取到的对象,绑定到线程中
			threadLocal.set(sqlSession);
		}

		return sqlSession;

	}

	/**
	 * 关闭会话
	 */
	public static void closeSqlSession() {
		// 首先,先获取到当前线程中的sqlSession
		SqlSession sqlSession = threadLocal.get();

		// 如果这个对象不为null,则直接释放掉
		if (sqlSession != null) {
			// 关闭sqlSession
			sqlSession.close();
			// 并且把这个sqlSession对象从当前线程中移除
			threadLocal.remove();

		}

	}

}
