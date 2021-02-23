package Quiz;

import java.util.ArrayList;
import java.util.Scanner;

// ����, DBC����
public class Operation { 
	Scanner  input;
	DBClass dc;
	public Operation() { // 10 new��°Ÿ� ���� �����ʾ� �޼ҵ� ������ֱ�
		input = new Scanner(System.in); //8
		dc = new DBClass(); // 10
	}
	public void insert() { // 7
		System.out.println("�߰� ���"); //7
		String inputId = null, inputName = null, inputAddr=null; //9 ����ڷκ��� �Է� ����
		System.out.println("���� ���̵� : "); //9
		inputId = input.next(); 
		System.out.println("���� �̸� : "); //9
		inputName = input.next();
		System.out.println("���� �ּ� : "); //9
		inputAddr = input.next();  // ���������ϱ� ������ ���̽��� �����ؾߵȴ�
		
		MemberDTO dto = new MemberDTO(); // 15  11������ �صε����� ���� ���������־ �̷��� ����
		dto.setAccountId(inputId);
		dto.setAddr(inputAddr);
		dto.setName(inputName);
		
		int re = dc.insert(dto); // 16 dto�� �μ�Ʈ�� �޾��ָ�Ǽ� // 26 resulte ���� �޾ƾ��ؼ� int re �߰�
		// dc.insert(inputId, inputName, inputAddr); // 11 ����ڷκ��� ���� ���� ����Ÿ���̽��� / dbcŬ������ �Ѿ��
		if(re ==1) // 27  // 28 table���� select * from quiz_member;�߰�
			System.out.println("����");
		else
			System.out.println("�����߻�");
	}
	public void modify() { // 7
		System.out.println("���� ���");
		MemberDTO dto = new MemberDTO();//58 
		System.out.println("���� ���̵� : "); // 58 �ۼ��� �����ͺ��̽��� �̵� 
		dto.setAccountId(input.next());
		System.out.println("���� �̸� : ");
		dto.setName(input.next());
		System.out.println("���� �ּ� : ");
		dto.setAddr(input.next());
		
		int result = dc.modify(dto); // 59
		if(result == 1) { 
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
		
	}
	public void delete() {// 7
		System.out.println("���� ���");
		System.out.println("������ ���̵� �Է� : "); // 55
		String delId = input.next(); // 55
		int result = dc.delete(delId); //55
		if(result == 1) { // 55
			System.out.println("�����Ϸ�");
		}else {
			System.out.println("���� �Ҽ������ϴ�");
		}
	}
	public void list() {// 7
		System.out.println("��ü��� ���");
		ArrayList<MemberDTO> list = dc.list(); // 29 �����ͺ��̽��� ����Ʈ�� ����  40 ArrayList<MemberDTO> list = �߰�
		
		System.out.println("========================"); // 42
		System.out.println("���̵�\t�̸�\t�ּ�");
		System.out.println("========================");
		if(list.size() == 0) { // 41
			System.out.println("����Ǿ��ִ� �����Ͱ� ����");
		}else {
			
			/*for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getAccountId()); //43
				System.out.println(list.get(i).getName()); //43
				System.out.println(list.get(i).getAddr()); //43
				System.out.println("--------------------------");
			}
			*/ // �Ѵ� ��밡��
			for(MemberDTO d:list) { // 43
				System.out.print(d.getAccountId()+"\t");
				System.out.print(d.getName()+"\t");
				System.out.println(d.getAddr());
				System.out.println("--------------------------");
			}
		}
	}
	public void info() {// 7
		System.out.println("�������� ���");
		System.out.println("�˻��� ���̵� �Է� : ");// 47 �ߺ�x����(���̺�)����  �ް��վ �߰��ؾ���
		String searchId = input.next(); 
		
		MemberDTO dto = dc.info(searchId); // 44 �ѻ���� �����̱� ������ // searchId �Է¹��� ���̵� �Ѱ��ְڴ�
		if(dto != null) { //54
			//�����Ͱ� �ִ°��
			System.out.println("id : " +dto.getAccountId());
			System.out.println("�̸� : " +dto.getName());
			System.out.println("�ּ� : " +dto.getAddr());
		}else {
			System.out.println("�ش� ���̵� ���� �����ʽ��ϴ�");
		}
	}
}