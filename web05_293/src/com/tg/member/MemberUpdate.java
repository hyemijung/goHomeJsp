package com.tg.member;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/member/update")

public class MemberUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub


		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		int mNo = Integer.parseInt(req.getParameter("no"));
		
		String sql = "";
		
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");
			
			conn = DriverManager.getConnection(url, user, password);
			
			
			
			sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE, PWD";
			sql += " FROM MEMBERS";
			sql += " WHERE MNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);
			
			rs = pstmt.executeQuery();
			
			String mName = "";
			String email = "";
			Date creDate = null;
			String pwd = "";
			
//			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>(); //기본키를 통해 한명을 조회하므로 ArrayList를 쓸 이유가 없다
			
			MemberDto memberDto = null;
			
			if (rs.next()) {  // 한명만 조회하므로 while문 대신 if문을 사용해도 된다(조금 더 빠름)
				mNo = rs.getInt("MNO");
				mName = rs.getString("MNAME");   // 대소문자 구분안함을 보이기위해
				email = rs.getString("email");
				creDate = rs.getDate("cre_date");
				
				memberDto = new MemberDto();
				
				memberDto.setNo(mNo);
				memberDto.setName(mName);
				memberDto.setEmail(email);
				memberDto.setCreateDate(creDate);
			}
			
//			while(rs.next()) {
//				mNo = rs.getInt("MNO");
//				mName = rs.getString("MNAME");   // 대소문자 구분안함을 보이기위해
//				email = rs.getString("email");
//				creDate = rs.getDate("cre_date");
//				
//				memberDto = new MemberDto();
//				
//				memberDto.setNo(mNo);
//				memberDto.setName(mName);
//				memberDto.setEmail(email);
//				memberDto.setCreateDate(creDate);
				
//				memberList.add(memberDto);
				
				
				req.setAttribute("memberDto", memberDto);
				
				res.setCharacterEncoding("UTF-8");
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher("./memberDetailView.jsp");
				
				dispatcher.include(req, res);
			
//			}

			
		
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 나중에 예외 처리
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end
			
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
		} // finally 종료
		
	}
		
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MemberUpdateServlet의 doPost를 한다");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 결과값을 받아서 하는것이 아니므로 필요없어서, rs= reSuelt 없어도 됨

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = " jsp";
		
		req.setCharacterEncoding("UTF-8"); // 한글이 깨지지않도록 셋팅하는 것!!!
		

		String email = req.getParameter("email"); // 한글깨지지 않는 셋팅하고 한글 넣고싶으면 넣어라
		String name = req.getParameter("name");
		int mNo = Integer.parseInt(req.getParameter("no"));
				
		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "UPDATE MEMBERS";
			sql += " SET EMAIL = ?, MNAME = ?, MOD_DATE = SYSDATE";
			sql += " WHERE MNO = ?"; 		//기본키를 사용했으므로 이것을 무언가 수정할때 mNo만 넘기면 된다
			
			pstmt = conn.prepareStatement(sql); //문장을 준비만 한것-+sql을 전체를 넣어서
			
			pstmt.setString(1,  email); // 물음표에 대한 설정(물음표도 순서가 있다)
			pstmt.setString(2,  name);	// 동적으로 입력
			pstmt.setInt(3,  mNo);
					
			pstmt.executeUpdate(); // 수행 // insert, delete 같은 수정을 한다
			
//			추가 - 새로고침할때마다 다시 남아있는 이전 양식의 수행을 막으려면?
			res.sendRedirect("./list"); // 새 정보를 추가하고나서 ./list 경로를 던져서 - 상대경로를 찾아간다 
										// 새로고침해도 양식이 다시 입력되지않고 상대경로로 찾아간다
					
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end

			

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end

	}

}