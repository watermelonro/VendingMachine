
public class Product {
	String productName;
	int price;
	int stock;
	
	public Product(String productName, int price, int stock)
	{
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}
	public boolean sellProduct(int num) {
		if (stock < num) 
			return false;
		else
			return true;
	}
	public void showInfo() {
		System.out.println("제품이름: " + productName);
		System.out.println("제품 가격: "+ price);
		System.out.println("제품 재고: "+ stock);
	}

}
