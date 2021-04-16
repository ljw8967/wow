package cls;

import java.util.List;
import java.util.Scanner;

import dao.MemberDao;
import dto.MemberDto;

public class SearchCls {
	Scanner sc = new Scanner(System.in);
	
	public void search() {
		System.out.print("검색할 이름 = ");
		String name = sc.next();
		
		
		MemberDao dao = MemberDao.getInstance();
		
		  List<MemberDto> list = dao.getList(name);
		
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
