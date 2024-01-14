
package Objects;
import java.util.Scanner;

public abstract class BilSup {
	// data members
	protected int id;
	protected String brandName;
    protected double price;
    protected String expireDate;
    protected int stock;
   
    
    public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// no-arg constructor
    public BilSup(int id, String brandName,double price,String expireDate) {
    	this.id=id;
    	this.brandName= brandName;
    	this.price=price;
    	this.expireDate=expireDate;
    	this.stock = 5;	
    }

	public String getBrandName() {
		return brandName;
	}


	public Double getPrice() {
		return price;
	}


	public String getExpireDate() {
		return expireDate;
	}



	public int getId() {
		return id;
	}
	
	public boolean CheckId(int id)
	{
		
		return this.id == id; 
	}

	@Override
	public String toString() {
		return "\nId:" + id + "\nBrand Name: " + brandName + "\nPrice: " + price + "\nExpire Date: " + expireDate
				+ "\n";
	}

	
	


	

    
}
