package Objects;
import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.BilSupInterface;
public class MultiVitamin extends BilSup implements BilSupInterface{
	
 
      private String pillSize;


      
      public MultiVitamin(int id, String brandName,double price,String expireDate,String pillSize)
      {
    	  super(id, brandName, price, expireDate);
    	  this.pillSize = pillSize; 
    	
      }
      
    
      
      
  	public void addTax(){	super.price=super.price+super.price*0.08;}

	@Override
	public void addBenefit() {
		// TODO Auto-generated method stub
		System.out.println("It protects heart and brain health... ");
		
	}




	@Override
	public String toString() {
		return "Multi Vitamin:" + super.toString() + "Pill Size: " + pillSize + "\n"; 
	}
	
	
	
	
}
