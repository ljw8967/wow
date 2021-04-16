package main;

import java.util.Scanner;

import cls.DeleteCls;
import cls.InsertCls;
import cls.PrintCls;
import cls.SearchCls;
import cls.UpdateCls;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		InsertCls ic = new InsertCls();
		DeleteCls dc = new DeleteCls();
		UpdateCls uc = new UpdateCls();
		SearchCls sc = new SearchCls();
		PrintCls pc = new PrintCls();

		boolean run = true;

		while (run) {
			System.out.println("1. 등록");
			System.out.println("2. 삭제");
			System.out.println("3. 수정");
			System.out.println("4. 검색");
			System.out.println("5. 출력");
			System.out.println("6. 종료");
			System.out.print(">>> ");

			// switch-case문을 사용하기 위해 key값 입력받기
			int key = scan.nextInt();

			// 원하는 case문을 사용하기 위해 입력받은 key값 넣어주기
			switch (key) {
			case 1: // 등록
				ic.insert();
				break;

				
			case 2: // 등록
				dc.delete();
				break;

			case 3: // 수정
				uc.update();
				break;

			case 4: // 검색
				sc.search();
				break;
				
			case 5: // 출력
                pc.print();
                break;

			case 6: // 종료
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		}
	}

}
