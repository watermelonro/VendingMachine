import java.util.Scanner;

public class MainUI {

	public static void main(String[] args) {
		
		MyVendingMachine machine = new MyVendingMachine();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 제품 구매");
			System.out.println("2. 관리자");
			System.out.println("3. 종료");
			System.out.print("--> ");
			int num = MyVendingMachine.checkInputValue();
			if(num == 1)
			{
				if(machine.productList.size() == 0)
				{
					System.out.println("등록된 상품이 없습니다.");
				}else {
					int productNum = machine.menuPrint();
					System.out.println("수량: ");
					int count = MyVendingMachine.checkInputValue();
					int totalPrice = machine.calSum(productNum,count);
					if (totalPrice == 0)
					{
						System.out.println("재고부족으로 구매 불가");
					}
					else {
						System.out.println("총금액: "+totalPrice+ "원");
					}
				}

				
				
			}
			else if(num == 2)
				machine.adminMenu();
			else if(num == 3)
				break;
			
		}
	}

}
