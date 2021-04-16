package cls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class PrintCls {

	

	public void print() {
	
		
		MemberDao dao = MemberDao.getInstance();
		
		  List<MemberDto> list = dao.print();
		
	        if (list != null) {

		        for (int i = 0; i < list.size(); i++) {
		        	MemberDto dto = list.get(i);
		            System.out.println(dto.toString());
		        }
	        } else {
	            System.out.println("데이터를 찾을수가 없습니다.");
	        }

	}
}
