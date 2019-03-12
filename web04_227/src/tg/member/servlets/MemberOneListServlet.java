package tg.member.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/member/one")

public class MemberOneListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, res); // 지워야 405 오류 해결
		System.out.println("MemberAddServlet의 doGet을 한다");
		
		  Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String email = req.getParameter("email");
	      String name = req.getParameter("name");
	      String pwd = req.getParameter("pwd");
	      
	      System.out.println(email);
	      System.out.println(name);
	      System.out.println(pwd);

	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "jsp";
	      String password = "jsp";

	      String sql = "";
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection(url, user, password);
	         	         
	         // 그림을 보고 데이터베이스에 출력한 순서를 구성한다
	         sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE";
	         sql += " FROM MEMBERS";
	         sql += " WHERE EMAil = ?";  // ? 로 바꿔준다 이미 인풋타입의 벨류가 정해져있으므로 
	         sql += " AND PWD = ?";  // ? 로 바꿔준다 이미 인풋타입의 벨류가 정해져있으므로 
	         							// ? 로 바뀌었으므로, 실글따옴포가 없다 - '' 있으면 공격 받을 가능성이 있다
	          
//  	     pstmt = (PreparedStatement) conn.createStatement(); // 자식의 것을 쓰고 싶을땐 형변환
	         pstmt = conn.prepareStatement(sql); // 형변환 안해도됨
	         
	         pstmt.setString(1,  email); // 첫번째 물음표이므로(1,  )  콤마뒤 는 실제 어떤값을 가져올래?
//	         pstmt.setString(2,  name); 
	         pstmt.setString(2,  pwd); 
	         
	         
	         rs = pstmt.executeQuery();  // 위에서 매개변수가 무엇인지 설정이미함  , 그래서 비워둬도 됨
	         							//select문을 수행하는 것(결과문에 대한 객체를 들고옴)-> rs에 저장	됨
	         
	         res.setContentType("text/html");
	         res.setCharacterEncoding("UTF-8");
	         
	         PrintWriter out = res.getWriter();
	         
	         out.println("<html><head><title>회원 한명 목록</title></head>");
	         out.println("<body><h1>회원 한명 목록</h1>");
	         
	         // 새로 추가
	         String htmlStr = "";
	         
	         htmlStr += "<div>";
//	         htmlStr += "<a href='./add?testName=newName&google=intel'>신규 회원</a>"; //하이퍼링크를 통해서도 다른페이지로 넘어갈수 있음
	         htmlStr += "<a href='./add'>신규 회원</a>"; //하이퍼링크를 통해서도 다른페이지로 넘어갈수 있음
	         htmlStr += "</div>";
	         htmlStr += "<br/>";
	         
	         out.println(htmlStr);
	         
//	         htmlStr = String.valueOf(rs.getInt("mno"))  // 이 방법보다 아래 concatenation 을 사용하는게 더 낫다
//	         htmlStr = rs.getInt("mno") + "," //concatenation 이용하여 String으로 변환
	        
	         
	         // set 은 인덱스로 찾아낼수 없다
	         //iterator 은 한번쓰면 다시 쓸수 없음을 명심해라- 그러므로 테스트했으면 그 테스트한 사항을 지울것 
	         while(rs.next()) { // next로 꺼낸것
	            out.println(
	               "<a href='./update?mNo=" + rs.getInt("mno") + "'>" +
	               rs.getInt("mno") + "," + 
	               rs.getString("mname") + "," +
	               rs.getString("email") + "," +
	               rs.getDate("cre_date") + "</a><br/>"
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
	         
	         if(pstmt != null) {
	            try {
	               pstmt.close();
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
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp); // 지워야 405 오류 해결
		System.out.println("MemberAddServlet의 doPost를 한다");
	}
	
	       

	         
	       

}
	