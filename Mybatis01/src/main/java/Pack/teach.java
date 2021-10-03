package Pack;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

interface Delegate1{
   int delegate(SqlSession session);
}

class Proxy1{
   static void command(UserDao1 dao, Delegate1 d) {
      SqlSession session = dao.ssf.openSession();
      try {
         if(d.delegate(session) > 0)
            session.commit();
      }catch (Exception e) {e.printStackTrace();
      }finally {session.close();}
   }
}

class UserDao1{
   SqlSessionFactory ssf;
   UserDao1(){
      try {
         InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
         ssf = new SqlSessionFactoryBuilder().build(is);
      } catch (Exception e) {e.printStackTrace();}      
   }
   
   void insert(final String s) {   
      Proxy1.command(this,  new Delegate1() {
         public int delegate(SqlSession session) {
            return session.insert("test02", s);            
         }
      });
   }

   void update(final String s) {   
      Proxy1.command(this,  new Delegate1() {
         public int delegate(SqlSession session) {
            return session.insert("test04", s);            
         }
      });
   }
   
}
public class teach{
   public static void main(String[] args) {
      UserDao1 dao = new UserDao1();
      dao.insert("1234");
      dao.update("1234");
      
   }
}
