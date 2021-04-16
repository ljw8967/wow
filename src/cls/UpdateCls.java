package cls;

import java.util.Scanner;

import dao.MemberDao;

public class UpdateCls {
Scanner sc = new Scanner(System.in);
	
	public void update() {
		System.out.print("수정할 name = ");
		String name = sc.next();
		
		System.out.print("수정될 DEPT = ");
		String dept = sc.next();
		
		MemberDao dao = MemberDao.getInstance();
		boolean b = dao.Update(name, dept);
		if(b) {
			System.out.println("정상적으로 수정 되었습니다");
			return;
		}
		
		System.out.println("수정되지 않았습니다");
	}
}
