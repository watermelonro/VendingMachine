import java.util.ArrayList;
import java.util.Scanner;

public class MyVendingMachine implements VendingMachineInteface {
	private int profit;
	public ArrayList<Product> productList = new ArrayList<Product>(3);
	Admin manager = new Admin();
	static Scanner sc  = new Scanner(System.in);
	
	public MyVendingMachine() {
		manager.setAdmin();
	}

	@Override
	public void setProduct() {
			System.out.println("몇 개의 제품을 입력하시겠습니까?: ");
			int productNum = checkInputValue();
			for(int i = 0; i<productNum; i++) {
				System.out.println("*****"+(i+1)+"번째 제품 *****");
				System.out.println("제품 이름: ");
				String name = sc.nextLine();
				System.out.println("제품 가격: ");
				int price = checkInputValue();
				System.out.println("제품 수량: ");
				int count = checkInputValue();
				productList.add(new Product(name, price, count));
			}
	}

	@Override
	public int menuPrint() {
		System.out.println("구매 할 제품의 번호를 입력하세요.");
		for(int i = 0; i<productList.size(); i++) {
			System.out.println((i+1) +"\t"+ productList.get(i).productName +"\t" + productList.get(i).price);
		}
		System.out.print("-->");
		int selectNum = checkInputValue();
		
		return selectNum;
	}

	@Override
	public int calSum(int selNo, int num) {
		int totalPrice;
		if(productList.get(selNo-1).stock < num) {
			System.out.println("수량이 부족합니다..");
			return 0;
		}
		else {
			System.out.println(productList.get(selNo-1).productName + " 을/를 " + num + "개 선택하셨습니다.");
			totalPrice = productList.get(selNo-1).price * num;
			int minusStock = productList.get(selNo-1).stock - num;
			Product reProduct = new Product(productList.get(selNo-1).productName, productList.get(selNo-1).price, minusStock);
			productList.set(selNo-1, reProduct);
			profit += totalPrice;
		}
		if(productList.get(selNo-1).stock < 1)
		{
			productList.remove(selNo-1);
		}
			
		

		return totalPrice;
		
	}

	@Override
	public void adminMenu() {
		boolean tf = manager.checkAdmin();
		if(!tf)
			System.out.println("관리자가 아닙니다.");
		while(tf) {
				System.out.println("1. 제품등록");
				System.out.println("2. 매출 확인");
				System.out.println("3. 전체 제품정보 확인");
				System.out.println("4. 재고 확인");
				System.out.println("5. 재고 추가");
				System.out.println("6. 이전 메뉴");
				System.out.println("--> ");
				int number = checkInputValue();
				if(number == 1)
					setProduct();
				else if(number == 2)
					System.out.println("현재 총 매출액: "+ profit);
				else if(number == 3)
				{
					System.out.println("#################");
					for(int i = 0; i< productList.size(); i++)
					{
						productList.get(i).showInfo();
						System.out.println("\n");
					}
					System.out.println("총 "+productList.size()+"개의 제품이 있습니다.");
					System.out.println("#################");
				}
				else if(number == 4)
				{
					System.out.println("어떤 상품의 재고를 확인할까요?");
					String name = sc.nextLine();
					checkStock(name);
				}
				else if(number == 5)
				{
					System.out.println("어떤 상품의 재고를 추가할까요? (제품이름): ");
					String addName = sc.nextLine();
					System.out.println("몇 개 추가할까요?: ");
					int addCount = checkInputValue();
					addStock(addName, addCount);
				}
					
				
				else if(number == 6)
					break;
			
			
		}
		
		
	}
	public void checkStock(String name) {
		for(int i = 0; i< productList.size(); i++) {
			if(productList.get(i).productName.equals(name))
			{
				System.out.println(name + " 재고: "+ productList.get(i).stock +"개");
				break;
			}else if(i == productList.size()-1)
				System.out.println("없는 상품입니다.");
		}
	}
	public void addStock(String name, int theNbOfPrct) {
		
		for(int i = 0; i<productList.size(); i++) {
			if(productList.get(i).productName.equals(name))
			{
				int price = productList.get(i).price;
				int add = productList.get(i).stock + theNbOfPrct;
				Product addProduct = new Product(name, price, add);
				productList.set(i,addProduct);
				System.out.println(name + " 상품 총 재고: " + productList.get(i).stock + "개");
			}else if(i == productList.size() - 1)
				System.out.println("없는 상품입니다.");
				
			
		}

	}
	public static int checkInputValue()
	{
		while(true)
		{
			try {
				String input = sc.nextLine();
				int number = Integer.parseInt(input);
				return number;
			} catch (NumberFormatException e) {
				System.out.println("문자를 입력하셨습니다. 숫자를 입력하세요.");
			}
		}
	}

}
