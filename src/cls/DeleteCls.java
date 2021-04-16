package cls;

import java.util.Scanner;

import dao.MemberDao;
import dto.MemberDto;

public class DeleteCls {

	Scanner sc = new Scanner(System.in);
	
	public void delete() {
		System.out.print("삭제할 이름 = ");
		String name = sc.next();
		
		MemberDao dao = MemberDao.getInstance();
		boolean b = dao.delete(name);
		if(b) {
			System.out.println("정상적으로 삭제 되었습니다");
			return;
		}
		
		System.out.println("삭제되지 않았습니다");
	}
}
