package tg.member.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MemberListServlet extends GenericServlet {

   @Override
   public void service(ServletRequest req, ServletResponse res) 
		   throws ServletException, IOException {
      // TODO Auto-generated method stub
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "jsp";
      String password = "jsp";

      String sql = "";
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
         stmt = conn.createStatement();
         
         
         sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE";
         sql += " FROM MEMBERS";
         sql += " ORDER BY MNO ASC"; 
         
         
         
         
         rs = stmt.executeQuery(sql);  // select문을 수행하는 것
         
         res.setContentType("text/html");
         res.setCharacterEncoding("UTF-8");
         
         PrintWriter out = res.getWriter();
         
         out.println("<html><head><title>회원목록</title></head>");
         out.println("<body><h1>회원목록</h1>");
         
         String htmlStr = "";
         
         htmlStr += "<div>";
         htmlStr += "<a href='./add?testName=newName&google=intel'>신규 회원</a>"; //하이퍼링크를 통해서도 다른페이지로 넘어갈수 있음
         htmlStr += "</div>";
         htmlStr += "<br/>";
         
         out.println(htmlStr);
         
         while(rs.next()) {
            out.println(
               rs.getInt("mno") + "," + 
               rs.getString("mname") + "," +
               rs.getString("email") + "," +
               rs.getDate("cre_date") + "<br/>"
            );
         }//while end
         
         out.println("</body></html>");
      } catch (ClassNotFoundException e) {
         // TODO: handle exception
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO: handle exception
         e.printStackTrace();
      }finally {
         if(rs != null) {
            try {
               rs.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }//if(rs != null) end
         
         if(stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         
         if(conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }//finally end

      
      
   }

}