package Objects;

import java.util.Scanner;

import Interfaces.BilSupInterface;

public class ProteinPowder extends BilSup implements BilSupInterface{
	
	private String weight;
	

	public ProteinPowder(int id, String brandName,double price, String expireDate,String weight) {
		super(id, brandName, price, expireDate);
		this.weight = weight;
	}
	
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void calculate(String flavourType)
	{
		if(flavourType.equalsIgnoreCase("banana"))
			super.price = 500.00;
			
		
		else if(flavourType.equalsIgnoreCase("strawberry"))
			super.price=600.00;
		else if(flavourType.equalsIgnoreCase("chocolate"))
			super.price=650.00;
	}
	
	
	
	@Override
	public String toString()
	{
		return "Protein Powder:" + super.toString() + "Weight: " + weight + "\n"; 
	}







	public void addTax(){
		super.price=super.price+super.price*0.10;
	}

	@Override
	public void addBenefit() {
		// TODO Auto-generated method stub
		System.out.println("It protects muscles and speed up muscles recovery");
	}
	
	
	
}
