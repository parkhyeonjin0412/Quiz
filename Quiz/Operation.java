package Quiz;

import java.util.ArrayList;
import java.util.Scanner;

// 연산, DBC연동
public class Operation { 
	Scanner  input;
	DBClass dc;
	public Operation() { // 10 new라는거를 많이 쓰지않아 메소드 만들어주기
		input = new Scanner(System.in); //8
		dc = new DBClass(); // 10
	}
	public void insert() { // 7
		System.out.println("추가 기능"); //7
		String inputId = null, inputName = null, inputAddr=null; //9 사용자로부터 입력 받음
		System.out.println("저장 아이디 : "); //9
		inputId = input.next(); 
		System.out.println("저장 이름 : "); //9
		inputName = input.next();
		System.out.println("저장 주소 : "); //9
		inputAddr = input.next();  // 저장했으니깐 데이터 베이스로 연결해야된다
		
		MemberDTO dto = new MemberDTO(); // 15  11번으로 해두되지만 값이 많아질수있어서 이렇게 정리
		dto.setAccountId(inputId);
		dto.setAddr(inputAddr);
		dto.setName(inputName);
		
		int re = dc.insert(dto); // 16 dto를 인설트를 받아주면되서 // 26 resulte 값을 받아야해서 int re 추가
		// dc.insert(inputId, inputName, inputAddr); // 11 사용자로부터 받은 값을 데이타베이스로 / dbc클래스로 넘어간다
		if(re ==1) // 27  // 28 table에서 select * from quiz_member;추가
			System.out.println("저장");
		else
			System.out.println("문제발생");
	}
	public void modify() { // 7
		System.out.println("수정 기능");
		MemberDTO dto = new MemberDTO();//58 
		System.out.println("수정 아이디 : "); // 58 작성후 데이터베이스로 이동 
		dto.setAccountId(input.next());
		System.out.println("수정 이름 : ");
		dto.setName(input.next());
		System.out.println("수정 주소 : ");
		dto.setAddr(input.next());
		
		int result = dc.modify(dto); // 59
		if(result == 1) { 
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
		
	}
	public void delete() {// 7
		System.out.println("삭제 기능");
		System.out.println("삭제할 아이디 입력 : "); // 55
		String delId = input.next(); // 55
		int result = dc.delete(delId); //55
		if(result == 1) { // 55
			System.out.println("삭제완료");
		}else {
			System.out.println("삭제 할수없읍니다");
		}
	}
	public void list() {// 7
		System.out.println("전체목록 기능");
		ArrayList<MemberDTO> list = dc.list(); // 29 데이터베이스가 리스트에 접근  40 ArrayList<MemberDTO> list = 추가
		
		System.out.println("========================"); // 42
		System.out.println("아이디\t이름\t주소");
		System.out.println("========================");
		if(list.size() == 0) { // 41
			System.out.println("저장되어있는 데이터가 없다");
		}else {
			
			/*for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getAccountId()); //43
				System.out.println(list.get(i).getName()); //43
				System.out.println(list.get(i).getAddr()); //43
				System.out.println("--------------------------");
			}
			*/ // 둘다 사용가능
			for(MemberDTO d:list) { // 43
				System.out.print(d.getAccountId()+"\t");
				System.out.print(d.getName()+"\t");
				System.out.println(d.getAddr());
				System.out.println("--------------------------");
			}
		}
	}
	public void info() {// 7
		System.out.println("개인정보 기능");
		System.out.println("검색할 아이디 입력 : ");// 47 중복x값을(테이블)에서  받고잇어서 추가해야함
		String searchId = input.next(); 
		
		MemberDTO dto = dc.info(searchId); // 44 한사람의 정보이기 때문에 // searchId 입력받은 아이디 넘겨주겠다
		if(dto != null) { //54
			//데이터가 있는경우
			System.out.println("id : " +dto.getAccountId());
			System.out.println("이름 : " +dto.getName());
			System.out.println("주소 : " +dto.getAddr());
		}else {
			System.out.println("해당 아이디가 존재 하지않습니다");
		}
	}
}