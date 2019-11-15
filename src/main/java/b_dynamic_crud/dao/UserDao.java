package b_dynamic_crud.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import b_dynamic_crud.entity.User;
import util.MybatisUtil;

/**
 * 按顺序学习
 */
public class UserDao {

	/**
	 * 根据条件查找用户
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @param salary
	 * @return
	 */
	public List<User> findUserByCondition(Integer id, String username, String password, Double salary) {

		// 获取到SqlSession对象
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		try {

			// 创建链表形式的map,用户存储传入的参数,带给mapper.xml中
			// 这里的key表示的是数据库中字段[不严谨]
			// value表示的是传入的值
			Map<String, Object> map = new LinkedHashMap<>();

			// 将调用此方法的参数put到map中
			map.put("id", id);
			map.put("username", username);
			map.put("password", password);
			map.put("salary", salary);

			return sqlSession.selectList(User.class.getName() + ".findUserByCondition", map);

		} catch (Exception e) {
			// 将异常打印输出
			e.printStackTrace();
			// 遇到错误,回滚事务
			sqlSession.rollback();
		} finally {
			// 最后一定要关闭连接,释放资源
			MybatisUtil.closeSqlSession();
		}

		return null;

	}

	public void updateUser(Integer id, String username, String password, Double salary) {
		// 获取到sqlSession对象
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		try {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("username", username);
			map.put("password", password);
			map.put("salary", salary);

			int line = sqlSession.update(User.class.getName() + ".updateUser", map);
			System.out.println("影响了:" + line + "行");

			//记得一定要提交事务
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			// 如果报错,回滚事务
			sqlSession.rollback();
		} finally {
			// 最后一定要记得关闭连接,释放资源
			MybatisUtil.closeSqlSession();
		}

	}

}
