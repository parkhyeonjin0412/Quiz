package Quiz;

// 데이터 저장
public class MemberDTO { // DTO는 테이블이 가지고있는거에 컬러명만 만들어준다다
	private String accountId; //13
	private String name; //13
	private String addr; //13
	
	// 14 set,get만들기
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

}
