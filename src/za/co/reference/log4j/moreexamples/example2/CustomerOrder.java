package za.co.reference.log4j.moreexamples.example2;

public class CustomerOrder{
	
	public CustomerOrder(String productName, int productCode, int productPrice){
		this.productName = productName;
		this.productCode = productCode;
		this.productPrice = productPrice;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public int getProductCode(){
		return productCode;
	}
	
	public void setProductCode(int productCode){
		this.productCode = productCode;
	}
	
	public int getProductPrice(){
		return productPrice;
	}
	
	public void setProductPrice(int productPrice){
		this.productPrice = productPrice;
	}

	private String productName;
	private int productCode;
	private int productPrice;

}
