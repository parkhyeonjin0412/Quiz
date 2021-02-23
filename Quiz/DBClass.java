package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBClass {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 19 ����Ŭ�� ����
	private String id = "java"; // 19
	private String pwd = "1234"; // 19

	public DBClass() { // 2
		try { // 3
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("����̺� �ε� �Ǿ����ϴ�! ");
	}

	// public void insert(String inputId, String inputName, String inputAddr) { //12
	public int insert(MemberDTO dto) { // 17 12ó�� �صε����� 16���� �޾���ߵǼ� dto�� ������ / 24�� ���� void�� int������ �ٲ�
		String sql = "insert into quiz_member(account_id, name, addr) values(?,?,?)"; // 18

		int result = 0;
		try { // 18
			Connection con = DriverManager.getConnection(url, id, pwd); // 18 ������ �ϱ����ؼ� ����Ŭ�� �����ʿ� //20 sql�� url,id,pwd��
																		// ����
			// System.out.println("���� ���� con : " + con); // 21
			PreparedStatement ps = con.prepareStatement(sql); // 22 �����Ҽ��ִ� ������ ������ֱ�
			ps.setString(1, dto.getAccountId()); // 23 dto�� ������Ǿ�����
			ps.setString(2, dto.getName()); // 23
			ps.setString(3, dto.getAddr()); // 23
			result = ps.executeUpdate(); // 24 ����Ǹ� result���� 1�ιٲ�
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // 25
	}

	public ArrayList<MemberDTO> list() { // 30 //38 ����Ʈ�� �ѷ�����ؼ� ArrayList<MemberDTO> ����
		String sql = "select * from quiz_member"; // 32
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); // 35 - 39
		try { // 31 �����ͺ��̽� ���
			Connection con = DriverManager.getConnection(url, id, pwd); // 31
			PreparedStatement ps = con.prepareStatement(sql); // 31
			ResultSet rs = ps.executeQuery(); // 33 , query�� ����Ʈ���� �޾Ƽ� resultset rs �߰�
			// ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); // 35 ���������ִٰ� ����

			while (rs.next()) { // 34 ����ϴ� ����� ���ش� System.out.println("id : "+ ����
				MemberDTO dto = new MemberDTO(); // 35
				dto.setAccountId(rs.getString("account_id")); // 34 -> 36 35���������� dto.setAccountId(rs �߰� �ȴ�
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr")); // while ���� ������ memberdto�� ���� �Ȱ��� �������ϱ� �׷��� 35�� �־��ش�
				list.add(dto); // 37 �ϳ��ϳ��� ����� dto�� ����
			}
		} catch (Exception e) { // 31
			e.printStackTrace(); // 31
		}
		return list; // 37 try �ȿ��� ��������� ������ ���� ����Ʈ ���� ������Ѵ� 38������

	}

	public MemberDTO info(String search) { // 46 MemberDTO �ش� ��ȯŸ�� ���������� ������������ ������� ���� �����;��� // 48 String search �߰�
		String sql = "select * from quiz_member where account_id = '" + search + "'"; // 49
		MemberDTO dto = null; //51 �ش����� ���� ���̸� null ������
		try { // 50 ���� �ۼ��Ѱ� �����ؿ͵ε�
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql); // ������ ���� ��ü 
			ResultSet rs = ps.executeQuery(); // ����

			while (rs.next()) { // if (rs.next())ó�����ִ°� ������ ������ �Ѹ� �����ϱ� 
				dto = new MemberDTO(); // 52 �����͸� �ߺҷ����� ��ü�� ����ڴ� �����Ͱ� ������ ���� ������ null
				dto.setAccountId(rs.getString("account_id"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto; //53 
	}
	public int delete(String delId) { //56
		String sql = "delete from quiz_member where account_id=?"; //56
		int result = 0; //56
		try { //56
			Connection con = DriverManager.getConnection(url, id, pwd); //57
			PreparedStatement ps = con.prepareStatement(sql); // 57
			ps.setString(1, delId); // 57
			result = ps.executeUpdate(); //57
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int modify(MemberDTO dto) { //60
	
		int result = 0;
		String sql = "update quiz_member set account_id=?, Name=?, where Addr=?";
		
		try { //61
			Connection con = DriverManager.getConnection(url, id, pwd); 
			PreparedStatement ps = con.prepareStatement(sql); 
			
			ps.setString(1, dto.getAccountId()); 
			ps.setString(2, dto.getName()); 
			ps.setString(3, dto.getAddr());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	
	}
}