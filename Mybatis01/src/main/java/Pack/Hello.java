package Pack;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Hello {

	public static void main(String[] args) {
		System.out.println(1);


		//System.out.println(1);

		SqlSessionFactory ssf = null;
		SqlSession session = null;

		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ssf = new SqlSessionFactoryBuilder().build(is);


		session = ssf.openSession();

		try {
			System.out.println("연결"); //result가 양수 값이면 정상적으로 실행됨
			

			Person p = new Person();
			p.setName("독수리");
			p.setAge(110);
			
			//if(session.insert("test05", p) > 0)	session.commit();
			//if(session.insert("test06", p) > 0)	session.commit();
			if(session.insert("test07", p) > 0)	session.commit();
			
			List<Person> mm = session.selectList("test08");
			for (Person pp : mm) {
				System.out.println(pp.getName() + " " + pp.getAge());
			}System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		System.out.println(3);


		/*
		//함수호출 예제 2 UserDao.java
		UserDao dao = new UserDao();
		//dao.insert(99999);
		//dao.delete(9999);
		//dao.update(99999);
		dao.showAge();
		 */

		/*
	    //db 연결 예제 1
		//System.out.println(1);

		SqlSessionFactory ssf = null;
		SqlSession session = null;

		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ssf = new SqlSessionFactoryBuilder().build(is);

		//System.out.println(2);

		//session 객체를 이용해서 sql 구사
		session = ssf.openSession();

//		void test01(int num) {
//			"insert into table02(FullName) values (#(FullName))";
//			쿼리 실행
//			return 10;
//		} 아래 result 코드와 같은 의미
//		
		try {
			//쿼리 실행
			//test01 이라는 함수를 찾아서 9999를 함수 인수로 던짐
			//System.out.println(result); //result가 양수 값이면 정상적으로 실행됨
			//int result = session.insert("test01", 111);
			//int result1 = session.delete("test02", 999);
			//int result2 = session.update("test03", 9999);

			// commit 해야 db에 적용됨
			//if(result > 0) 	session.commit();
			//if(result1 > 0) 	session.commit();
			//if(result2 > 0) 	session.commit();

//			List<Integer> mm = session.selectList("test04");
//			for (Integer item : mm) {
//				System.out.println(item + " ");
//			}System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		//System.out.println(3);

		 */
	}
}
