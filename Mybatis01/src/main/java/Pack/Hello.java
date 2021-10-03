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
			System.out.println("����"); //result�� ��� ���̸� ���������� �����
			

			Person p = new Person();
			p.setName("������");
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
		//�Լ�ȣ�� ���� 2 UserDao.java
		UserDao dao = new UserDao();
		//dao.insert(99999);
		//dao.delete(9999);
		//dao.update(99999);
		dao.showAge();
		 */

		/*
	    //db ���� ���� 1
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

		//session ��ü�� �̿��ؼ� sql ����
		session = ssf.openSession();

//		void test01(int num) {
//			"insert into table02(FullName) values (#(FullName))";
//			���� ����
//			return 10;
//		} �Ʒ� result �ڵ�� ���� �ǹ�
//		
		try {
			//���� ����
			//test01 �̶�� �Լ��� ã�Ƽ� 9999�� �Լ� �μ��� ����
			//System.out.println(result); //result�� ��� ���̸� ���������� �����
			//int result = session.insert("test01", 111);
			//int result1 = session.delete("test02", 999);
			//int result2 = session.update("test03", 9999);

			// commit �ؾ� db�� �����
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
