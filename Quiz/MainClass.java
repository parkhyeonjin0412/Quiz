package Quiz;

import java.util.Scanner;

// Operation 연동
public class MainClass {

	public static void main(String[] args) throws Exception{ // 1
	//	DBClass test = new DBClass(); // 4_3번이 실행되는지 확인 
		Scanner input = new Scanner(System.in); // 5 
		int num; //5
		Operation op = new Operation(); // 6 연동할 객체
		while (true) { //5
			System.out.println("1.추가 2.수정 3.삭제 4.목록보기 5.개인정보보기"); //5 OP여기서 해줄꺼다
			num = input.nextInt();//5
			switch(num) { //5
			case 1 : 
				op.insert(); // 6
				break;
			case 2 : 
				op.modify(); // 6
				break;
			case 3 : 
				op.delete(); // 6
				break;
			case 4 : 
				op.list(); // 6
				break;
			case 5 : 
				op.info(); // 6
			}
		}
	}
}
