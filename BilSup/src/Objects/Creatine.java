package Objects;
import java.util.Scanner;

import Interfaces.BilSupInterface;

public class Creatine extends BilSup implements BilSupInterface{
	
	private String creatineType;
	
	
	// no-arg constructor
		public Creatine(int id, String brandName,double price,String expireDate,String creatineType) {
			super(id, brandName, price, expireDate);
			this.creatineType=creatineType;
	    }

	/*	public void getInput()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter scoop size");
			scoopSize = scanner.nextDouble();
			

		}*/
		

		
		
		public void calculate(double scoopSize)
		{
			super.price = scoopSize * 5;	
			
		}
		
	public String getCreatineType() {
			return creatineType;
		}

	public void addTax(){
		super.price=super.price+super.price*0.05;
	}
	
	
		public String toString()
		{
			return "Creatine:" + super.toString() + "Creatine Type: " + creatineType + "\n"; 
		}

		@Override
		public void addBenefit() {
			// TODO Auto-generated method stub
			System.out.println("It holds water in muscles and increase power...");
			
		}
}
