package Quiz;

import java.util.Scanner;

// Operation ����
public class MainClass {

	public static void main(String[] args) throws Exception{ // 1
	//	DBClass test = new DBClass(); // 4_3���� ����Ǵ��� Ȯ�� 
		Scanner input = new Scanner(System.in); // 5 
		int num; //5
		Operation op = new Operation(); // 6 ������ ��ü
		while (true) { //5
			System.out.println("1.�߰� 2.���� 3.���� 4.��Ϻ��� 5.������������"); //5 OP���⼭ ���ٲ���
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
