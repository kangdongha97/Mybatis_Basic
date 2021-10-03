package Pack;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDao {
	SqlSessionFactory ssf;

	UserDao(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void insert(int num) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.insert("test01", num);
			if(result > 0) 	session.commit();
			System.out.println("삽입 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
	}
	
	void delete(int num) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.update("test02", num);
			if(result > 0) 	session.commit();
			System.out.println("삭제 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		
	}
	
	
	void update(int num) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.update("test03", num);
			if(result > 0) 	session.commit();
			System.out.println("수정 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		
	}
	
	void showAge() {
		SqlSession session = ssf.openSession();
		List<Integer> mm = session.selectList("test04");
		System.out.println("--------------------");
		System.out.println("DB 출력");
		for (Integer item : mm) {
			System.out.println(item + " ");
		}System.out.println();
		session.close();
	}
}
