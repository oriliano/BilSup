package Others;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

import Objects.BilSup;
import Objects.Creatine;
import Objects.MultiVitamin;
import Objects.ProteinPowder;
public class BilSupSys {
	private static HashSet<Creatine> cr = new HashSet<Creatine>();
	private static HashSet<ProteinPowder> pr = new HashSet<ProteinPowder>();
	private static HashSet<MultiVitamin> mv = new HashSet<MultiVitamin>();
	private static LinkedHashMap<Integer,ArrayList<BilSup>> alSup = new LinkedHashMap<Integer,ArrayList<BilSup>>();
	
	public static BilSup searchSupId(int id)
	{
		ArrayList<BilSup> b = new ArrayList<BilSup>();
		
		for (int i = 1; i <=3; i++) {
			b = alSup.get(i);
			
			for(BilSup bs : b) {
				if(bs.CheckId(id)) {
					return bs;
				}
			}
		}
		return null;
	}
	
	public static boolean removeSup(int id) {
		try {	
		BilSup b = searchSupId(id);
		
		if (b instanceof Creatine) {
            cr.remove(b);
            alSup.remove(1, b);
            return true;
        } else if (b instanceof MultiVitamin) {
        	mv.remove(b);
        	alSup.remove(2, b);
        	return true;
        } else if (b instanceof ProteinPowder) {
        	pr.remove(b);
        	alSup.remove(3, b);
        	return true;
        }
	}catch (ConcurrentModificationException e) {
	        // Handle the exception (print a message, log it, etc.)
	        System.out.println("ConcurrentModificationException caught");
	    }
		return false;
	}
	
	public static String display() {
		String result="Display All:\n";
		
		ArrayList<BilSup> b = new ArrayList<BilSup>();
		
		for (int i = 1; i <=3; i++) {
			b = alSup.get(i);
			
			for(BilSup bs : b) {
				result+=b.toString() + "\n";
			}
		}
		
		return result;
	}
	
	public static boolean add(String type, int id, String brandName, int price, String date, String crType, String weight, String size){
		boolean res = false;
		Creatine creatine;
		ProteinPowder proteinP;
		MultiVitamin multiVitamin;
		ArrayList<BilSup> ar = new ArrayList<BilSup>();
		
		if (searchSupId(id)!= null) {
			return false;
		}
		
		if (type.equalsIgnoreCase("creatine")) {
			creatine = new Creatine(id, brandName, price, date, crType);
			cr.add(creatine);	
			ar = alSup.get(1);
			alSup.put(1, ar);
			res = true;
		} else if (type.equalsIgnoreCase("MultiVitamin")) {
			multiVitamin = new MultiVitamin(id, brandName, price, date, size);
			mv.add(multiVitamin);
			ar = alSup.get(2);
			alSup.put(2, ar);
			res = true;
		
		} else {
				proteinP = new ProteinPowder(id, brandName, price, date, weight);
				pr.add(proteinP);	
				ar = alSup.get(3);
				alSup.put(3, ar);
				res = true;
		 } 
	
		return res;
	}
	
	public static void buyCreatine(String brandName) {
			
		try {
		for(Creatine c : cr) {
			if(c.getBrandName().equalsIgnoreCase(brandName)) {
				removeSup(c.getId());
			}
		}
		}catch (ConcurrentModificationException e) {
	        // Handle the exception (print a message, log it, etc.)
	        System.out.println("");
	    }
	
	}
	
	public static void buyProtein(String brandName) {
	try {	
		for(ProteinPowder c : pr) {
			if(c.getBrandName().equalsIgnoreCase(brandName)) {
				removeSup(c.getId());
			}
		}
	}catch (ConcurrentModificationException e) {
        // Handle the exception (print a message, log it, etc.)
        System.out.println("");
    }
	}
	
	public static void buyVitamin(String brandName) {
		
		try {	
			for(MultiVitamin c : mv) {
				if(c.getBrandName().equalsIgnoreCase(brandName)) {
					removeSup(c.getId());
				}
			}
		}catch (ConcurrentModificationException e) {
	        // Handle the exception (print a message, log it, etc.)
	        System.out.println("");
	    }
			
	}
	
	public static double calCreatine(String brandName, int scoopSize)
	 {
		 double  crPrice = 0;
		 if (brandName.equalsIgnoreCase("ProteinOcean"))
		 {
			 crPrice = 3 * scoopSize;
		 }
		 else if (brandName.equalsIgnoreCase("Hiq"))
		 {
			 crPrice = 4 * scoopSize;
		 }
		 else {
			 crPrice = 5 * scoopSize;
		 }
		 return crPrice;
	 }
	
	public static double calPowder(String brandName, String flavorType)
	 {
		 double pwPrice = 0;
		 if(brandName.equalsIgnoreCase("ProteinOcean"))
		 {
			 if (flavorType.equalsIgnoreCase("Chocolate"))
			 {
				 pwPrice = 600 * 5;
			 }
			 else if (flavorType.equalsIgnoreCase("Banana"))
			 {
				 pwPrice = 600 * 4;
			 }
			 else {
				 pwPrice = 600 * 3.5;
			 }
			 return pwPrice;
			 
			 
		 }
		 else if (brandName.equalsIgnoreCase("Hiq"))
		 {
			 if (flavorType.equalsIgnoreCase("Chocolate"))
			 {
				 pwPrice = 600 * 5;
			 }
			 else if (flavorType.equalsIgnoreCase("Banana"))
			 {
				 pwPrice = 600 * 4;
			 }
			 else {
				 pwPrice = 600 * 3.5;
			 }
			 return pwPrice;
		 }
		 else {
			 if (flavorType.equalsIgnoreCase("Chocolate"))
			 {
				 pwPrice = 2500 * 5;
			 }
			 else if (flavorType.equalsIgnoreCase("Banana"))
			 {
				 pwPrice = 2500 * 4;
			 }
			 else {
				 pwPrice = 2500 * 3.5;
			 }
			 return pwPrice;
		 }
		 
	 }
	
	public static double calVitamin(String brandName, String SexType, String vitType)
	 {
		 double vitPrice = 0;
		 if(brandName.equalsIgnoreCase("ProteinOcean"))
		 {
			 if (SexType.equalsIgnoreCase("Male"))
			 {
				 if (vitType.equalsIgnoreCase("A"))
				{
					 vitPrice = 1600 * 5;
				}
						 else if (vitType.equalsIgnoreCase("B"))
						 {
							 vitPrice = 1200 * 4;
						 }
						 else {
							 vitPrice = 900 * 3.5;
						 }
						 return vitPrice;
			 }
		    else
			 {
				 if (vitType.equalsIgnoreCase("A"))
						 {
					 vitPrice = 300 * 5;
						 }
						 else if (vitType.equalsIgnoreCase("B"))
						 {
							 vitPrice = 200 * 4;
						 }
						 else {
							 vitPrice = 100 * 3.5;
						 }
						 return vitPrice;
			 }
			
			 
			 
		 }
	 
		 else if (brandName.equalsIgnoreCase("Hiq"))
		 {  
			 if (SexType.equalsIgnoreCase("Male"))
					 {
						 if (vitType.equalsIgnoreCase("A"))
								 {
									 vitPrice = 400 * 5;
								 }
								 else if (vitType.equalsIgnoreCase("B"))
								 {
									 vitPrice = 200 * 4;
								 }
								 else {
									 vitPrice = 130 * 3.5;
								 }
								 return vitPrice;
					 }
					 else if (SexType.equalsIgnoreCase("Female"))
					 {
						 if (vitType.equalsIgnoreCase("A"))
								 {
							 vitPrice = 620 * 5;
								 }
								 else if (vitType.equalsIgnoreCase("B"))
								 {
									 vitPrice = 600 * 4;
								 }
								 else {
									 vitPrice = 1000 * 3.5;
								 }
								 return vitPrice;
					 }
		 }
		 else {
			 if (SexType.equalsIgnoreCase("Male"))
					 {
						 if (vitType.equalsIgnoreCase("A"))
								 {
							 vitPrice = 300 * 5;
								 }
								 else if (vitType.equalsIgnoreCase("B"))
								 {
									 vitPrice = 200 * 4;
								 }
								 else {
									 vitPrice = 100 * 3.5;
								 }
								 return vitPrice;
					 }
					 else if (SexType.equalsIgnoreCase("Female"))
					 {
						 if (vitType.equalsIgnoreCase("A"))
								 {
							       vitPrice = 100 * 5;
								 }
								 else if (vitType.equalsIgnoreCase("B"))
								 {
									 vitPrice = 500 * 4;
								 }
								 else {
									 vitPrice = 900 * 3.5;
								 }
								 return vitPrice;
					 }
		 }
		return vitPrice;
		 
	 }

	public static String[] getCreatineNames() {
        String[] output = new String[cr.size()];
        int i = 0;
        for (Creatine c : cr) {
        	output[i] = c.getBrandName();
        	i++;
        }
       
        return output;
    }
	
	public static String[] getProteinNames() {
		String[] output = new String[pr.size()];
		if(!pr.isEmpty()) {
			int i = 0;
	        for (ProteinPowder c : pr) {
	        	output[i] = c.getBrandName();
	        	i++;
	        }	
		}
        
        
       
        return output;
    }
	
	public static String[] getVitaminNames() {
        String[] output = new String[mv.size()];
        if(!mv.isEmpty()) {
        int i = 0;
        for (MultiVitamin c : mv) {
        	output[i] = c.getBrandName();
        	i++;
        }
        }
       
        return output;
    }
	
	public static void readFromFile() {
		File f1;
		Scanner sc;
		int supId;
		double price;
		String supName;
		String supType;
		String date,vitType, size;
		BilSup b;
		String crType,proSize;
		Creatine creatine;
		ProteinPowder proteinP;
		MultiVitamin multiVitamin;
		ArrayList<BilSup> crAl = new ArrayList<BilSup>();
		ArrayList<BilSup> mvAl = new ArrayList<BilSup>();
		ArrayList<BilSup> prAl = new ArrayList<BilSup>();
		f1 = new File("supplement.txt");
		try {
			sc = new Scanner(f1);
			while(sc.hasNext())
			{
				supType=sc.next();
				
				if (supType.equalsIgnoreCase("creatine")) {
				 	supId=sc.nextInt();
					supName=sc.next();
					price=sc.nextDouble();
					date=sc.next();
					crType=sc.next();
					System.out.println(supId + supName + price + date + crType);
					creatine = new Creatine(supId, supName, price, date, crType);
					System.out.println("Added Creatine");
					cr.add(creatine);	
					crAl.add(creatine);
			 } else if (supType.equalsIgnoreCase("MultiVitamin")) {
					supId=sc.nextInt();
					supName=sc.next();
					price=sc.nextDouble();
					date=sc.next();
					size = sc.next();
					System.out.println(supId + supName + price + date + size);
					multiVitamin = new MultiVitamin(supId, supName, price, date, size);
					System.out.println("Added Mv");
					mv.add(multiVitamin);
					mvAl.add(multiVitamin);
				} else {
					 	supId=sc.nextInt();
						supName=sc.next();
						price=sc.nextDouble();
						date=sc.next();
						proSize=sc.next();
						System.out.println(supId + supName + price + date + proSize);
						proteinP = new ProteinPowder(supId, supName, price, date, proSize);
						System.out.println("Added Protein");
						pr.add(proteinP);	
						prAl.add(proteinP);
				 } 
				
				}	
			sc.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		alSup.put(1, crAl);
		alSup.put(2, prAl);
		alSup.put(3, mvAl);
		
		
	}
	
	 public static String displayCreatine() {

	        String output = "";
	        for (Creatine c : cr) {
	            output += c.toString() + "\n";
	        }
	        return output;
	    }
	
	
	 public static String displayVitamin() {
	        String output = "";
	        for (MultiVitamin v : mv) {
	            output += v.toString() + "\n";
	        }
	        return output;
	    }
	 public static String displayProtein() {
		 
	        String output = "";
	        for (ProteinPowder p : pr) {
	            output += p.toString() + "\n";
	        }
	        return output;
	    }
	

	
}
