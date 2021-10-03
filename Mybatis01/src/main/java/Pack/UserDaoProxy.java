package Pack;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

class DAO{
	SqlSessionFactory ssf;
	SqlSession session;
	int result;
	// DB 연결 생성자
	DAO(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	void SQL(DAO t) {
		try {
			if(t.result > 0) t.session.commit();
			System.out.println("쿼리 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
	}
}


interface Dele{
	void dele(DAO dao);
}

class Pro{
	void command(Dele d) {
		DAO t = new DAO(); //DB 연결
		d.dele(t);
		
	}
}

public class UserDaoProxy {
	public static void main(String[] args) {
		
		Pro pro = new Pro();
//		pro.command(new Dele() {
//			public void dele(DAO t) {
//				t.session = t.ssf.openSession();
//				t.result = t.session.insert("test01", 99211);
//				t.SQL(t);
//			}
//		});
//		
//		pro.command(new Dele() {
//			public void dele(DAO t) {
//				t.session = t.ssf.openSession();
//				t.result = t.session.update("test02", 111);
//				t.SQL(t);
//			}
//		});
//		pro.command(new Dele() {
//			public void dele(DAO t) {
//				t.session = t.ssf.openSession();
//				t.result = t.session.delete("test03", 99911);
//				t.SQL(t);
//			}
//		});
		
		pro.command(new Dele() {
			public void dele(DAO t) {
				t.session = t.ssf.openSession();
				List<Integer> mm = t.session.selectList("test04");
				System.out.println("--------------------");
				System.out.println("DB 출력");
				for (Integer item : mm) {
					System.out.println(item + " ");
				}System.out.println();
				t.SQL(t);
			}
		});
	}
	
}
