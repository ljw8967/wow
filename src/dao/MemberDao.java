package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

// singleton
public class MemberDao {	// DB와 접속하는 class

	private static MemberDao dao = null;
	
	private MemberDao() {
		DBConnection.initConnection();
	}
	
	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	public boolean insert(MemberDto dto) {
		String sql = " INSERT INTO TB_MEMBER(NAME, TEL, DEPT, AGE) "
				+ " VALUES( ?, ?, ?, ? ) ";
		System.out.println(sql);
				

		Connection conn = DBConnection.getConnection();	
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getDept());
			psmt.setString(4, dto.getAge());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return count>0?true:false;		
	}	

	
	 public boolean delete(String name) {
		 
	        String sql = " DELETE FROM TB_MEMBER WHERE ID = '" + name + "' ";
	 
	        System.out.println(sql);
	 
	        Connection conn = DBConnection.getConnection();
	        Statement stmt = null;
	 
	        int count = 0;
	 
	        try {
	            stmt = conn.createStatement();
	            count = stmt.executeUpdate(sql);
	 
	            System.out.println("성공적으로 삭제되었습니다.");
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	 
	        } finally {
	 
	            try {
	                DBClose.close(conn, stmt, null);
	 
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	 
	        }
	        return count > 0 ? true : false;
	    }
	 
	 public boolean Update(String name, String dept) {
	        // Query
	        String sql = " UPDATE TB_MEMBER " + "SET DEPT = " + dept + " " + "WHERE NAME = '" + name + "'";
	 
	        System.out.println(sql);
	 
	        Connection conn = DBConnection.getConnection();
	        Statement stmt = null;
	 
	        int count = 0;
	 
	        // db connect
	        try {
	            stmt = conn.createStatement();
	 
	            // db process
	            count = stmt.executeUpdate(sql);
	 
	            System.out.println("성공적으로 수정되었습니다.");
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	 
	            try {
	                DBClose.close(conn, stmt, null);
	 
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	 
	        }
	        return count > 0 ? true : false;
	    }
	 
	 public List<MemberDto> getList(String name) {
		 
	        String sql = " SELECT * " + " FROM TB_MEMBER WHERE NAME = ?";
	 
	        System.out.println(sql);
	 
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement psmt = null;
	        ResultSet rs = null; // DB로부터 결과를 리턴받는 값
	 
	        List<MemberDto> list = new ArrayList<MemberDto>();
	 
	        try {
	            psmt = conn.prepareStatement(sql);
	            psmt.setString(1, name);
	            rs = psmt.executeQuery();
	 
	            while (rs.next()) {
	                String name1 = rs.getString("name");
	                String tel = rs.getString("tel");
	                String dept = rs.getString("dept");
	                String age = rs.getString("age");
	 
	                MemberDto dto = new MemberDto(name1, tel, dept, age);
	 
	                list.add(dto);
	 
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            DBClose.close(conn, psmt, rs);
	        }
	        return list;
	    }
	 
	 
	 public List<MemberDto> print() {
		  String sql = " SELECT * " + 
				  	" FROM TB_MEMBER ";
		  
	        System.out.println(sql);
	 
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement psmt = null;
	        ResultSet rs = null; // DB로부터 결과를 리턴받는 값
	 
	        List<MemberDto> list = new ArrayList<MemberDto>();
	 
	        try {
	            psmt = conn.prepareStatement(sql);
	            rs = psmt.executeQuery();
	 
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String tel = rs.getString("tel");
	                String dept = rs.getString("dept");
	                String age = rs.getString("age");
	 
	                MemberDto dto = new MemberDto(name, tel, dept , age);
	 
	                list.add(dto);
	 
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            DBClose.close(conn, psmt, rs);
	        }
	        return list;
	 
	}

	
	
}





