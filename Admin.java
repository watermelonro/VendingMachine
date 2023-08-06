import java.util.Scanner;

public class Admin {
	private int id;
	private String pw;
	Scanner sc = new Scanner(System.in);
	
	public void setAdmin() {
		System.out.println("관리자를 생성합니다.");
		System.out.print("새로운 id를 생성하세요(숫자만 가능)");
		this.id = MyVendingMachine.checkInputValue();
		System.out.print("새로운 pw를 생성하세요(숫자, 영문_대소문자 생성가능)");
		this.pw = sc.next();
		int length = pw.length();
		StringBuilder maskedPassword = new StringBuilder(length);
		for(int i = 0; i<length;i++)
			maskedPassword.append("*");
		System.out.println("새로운 관리자 id: "+ this.id + "\tpw: "+ maskedPassword);
	}
	public boolean checkAdmin() {
		System.out.println("관리자 권한이 있어야 하는 메뉴입니다.");
		System.out.println("id: ");
		int adminId =  MyVendingMachine.checkInputValue();
		System.out.println("pw: ");
		String adminPw = sc.next();
		if(adminId == id && adminPw.equals(pw)) 
			return true;
		else
		{
			System.out.println("관리자 권한이 없습니다.");
			return false;
		}
			
	
	}

}
