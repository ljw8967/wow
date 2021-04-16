package cls;

import java.util.Scanner;

import dao.MemberDao;
import dto.MemberDto;

public class InsertCls {

	Scanner sc = new Scanner(System.in);
	
	public void insert() {
		System.out.print("NAME = ");
		String name = sc.next();
		
		System.out.print("TEL = ");
		String tel = sc.next();
		
		System.out.print("DEPT = ");
		String dept = sc.next();
		
		System.out.print("AGE = ");
		String age = sc.next();
		
		MemberDao dao = MemberDao.getInstance();
		boolean b = dao.insert(new MemberDto(name, tel, dept, age));
		if(b) {
			System.out.println("정상적으로 추가 되었습니다");
			return;
		}
		
		System.out.println("추가되지 않았습니다");
	}
}













