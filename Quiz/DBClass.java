package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBClass {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 19 오라클의 정보
	private String id = "java"; // 19
	private String pwd = "1234"; // 19

	public DBClass() { // 2
		try { // 3
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("드라이브 로드 되었습니다! ");
	}

	// public void insert(String inputId, String inputName, String inputAddr) { //12
	public int insert(MemberDTO dto) { // 17 12처럼 해두되지만 16번을 받아줘야되서 dto에 값저장 / 24로 인해 void가 int값으로 바뀜
		String sql = "insert into quiz_member(account_id, name, addr) values(?,?,?)"; // 18

		int result = 0;
		try { // 18
			Connection con = DriverManager.getConnection(url, id, pwd); // 18 연결의 하기위해선 오라클의 정보필요 //20 sql을 url,id,pwd로
																		// 변경
			// System.out.println("연결 성공 con : " + con); // 21
			PreparedStatement ps = con.prepareStatement(sql); // 22 전송할수있는 쿼리문 만들어주기
			ps.setString(1, dto.getAccountId()); // 23 dto에 값저장되어있음
			ps.setString(2, dto.getName()); // 23
			ps.setString(3, dto.getAddr()); // 23
			result = ps.executeUpdate(); // 24 실행되면 result값이 1로바뀜
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // 25
	}

	public ArrayList<MemberDTO> list() { // 30 //38 리스트를 둘려줘야해서 ArrayList<MemberDTO> 수정
		String sql = "select * from quiz_member"; // 32
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); // 35 - 39
		try { // 31 테이터베이스 기능
			Connection con = DriverManager.getConnection(url, id, pwd); // 31
			PreparedStatement ps = con.prepareStatement(sql); // 31
			ResultSet rs = ps.executeQuery(); // 33 , query가 리절트값을 받아서 resultset rs 추가
			// ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); // 35 원래여기있다가 빠짐

			while (rs.next()) { // 34 출력하는 기능을 빼준다 System.out.println("id : "+ 뺴기
				MemberDTO dto = new MemberDTO(); // 35
				dto.setAccountId(rs.getString("account_id")); // 34 -> 36 35번으로인해 dto.setAccountId(rs 추가 된다
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr")); // while 문의 내용은 memberdto랑 같다 똑같이 맞춰으니깐 그래서 35를 넣어준다
				list.add(dto); // 37 하나하나의 목록을 dto로 저장
			}
		} catch (Exception e) { // 31
			e.printStackTrace(); // 31
		}
		return list; // 37 try 안에서 만들어져서 오류가 떠서 리스트 값을 빼줘야한다 38번실행

	}

	public MemberDTO info(String search) { // 46 MemberDTO 해당 반환타입 개인정보를 가져오기위해 사용자의 값이 가져와야함 // 48 String search 추가
		String sql = "select * from quiz_member where account_id = '" + search + "'"; // 49
		MemberDTO dto = null; //51 해당하지 않은 값이면 null 을가짐
		try { // 50 위에 작성한거 복사해와두됨
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql); // 퀴리문 전송 객체 
			ResultSet rs = ps.executeQuery(); // 실행

			while (rs.next()) { // if (rs.next())처리해주는게 더좋다 이유는 한명 정보니깐 
				dto = new MemberDTO(); // 52 데이터를 잘불러오면 객체를 만들겠다 데이터가 있으면 실행 없으면 null
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