import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean cont = true;
		
		double liability = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to US income tax calculator.");
		
		while(cont) {
			
			double income = getIncome(sc);
			
			String status = getStatus(sc);
			
			System.out.println(status);
			//liability = Math.round(getLiability(income, status) * 100) / 100;
			liability = getLiability(income, status);
			
			System.out.println("Your base income tax liability is $" + liability);
			
			cont = getContInput(sc);
			
		}
		
		System.out.println("Thank you for using my US income tax calculator.");
	}
	
	static double getIncome(Scanner sc) {
		
		double num;
		
		try {
			
			System.out.print("Enter your annual income in $: ");
			num = Double.parseDouble(sc.next());
			return num;
			
		} catch(Exception e) {
			System.out.println("Please enter a valid income.\n");
			return getIncome(sc);
		}
		
		
	}
	
	static String getStatus(Scanner sc) {
		if(getMariageStatus(sc)) {
			System.out.println("Are you:"
					+ "\n (J) filing jointly \n (W) as widow \n (S) seperately \n (H) or head of household?"); 
			String response = sc.next();
			switch(response.toUpperCase()) {
			case "J":
				return "jointly";
			case "W":
				return "widow";
			case "S":
				return "seperately";
			case "H":
				return "head of household";
			default:
				System.out.println("That was not a valid response!");
				return getStatus(sc);
			}
		}else {
			return "single";
		}
	}
	
	static boolean getMariageStatus(Scanner sc) {
		
		System.out.print("Are you married? (Y or N) ");
		String response = sc.next();
		
		if(response.toUpperCase().equals("Y")) {
			return true;
		}else if(response.toUpperCase().equals("N")) {
			return false;
		}else {
			System.out.println("That was not a valid response!\n" );
			return getMariageStatus(sc);
		}
		
	}
	
	static double getLiability(double income, String status) {
		if(status.equals("single")) {
			if(income >= 415051) {
				return ((income - 415050) * .396) + 120529.75;
			}else if(income >= 413351) {
				return ((income - 413350) * .35) + 119934.75; 
			}else if(income >= 190151) {
				return ((income - 190150) * .33) + 190150.75; 
			}else if(income >= 91151) {
				return ((income - 91150) * .28) + 18558.75; 
			}else if(income >= 37651) {
				return ((income - 37650) * .25) + 5183.75; 
			}else if(income >= 9276) {
				return ((income - 9275) * .15) + 927.50; 
			}else {
				return (income * .10); 
			}
		}
		if(status.equals("jointly") || status.equals("widow")) {
			if(income >= 466951) {
				return ((income - 466950) * .396) + 130578.50;
			}else if(income >= 413351) {
				return ((income - 413350) * .35) + 111818.50; 
			}else if(income >= 231451) {
				return ((income - 231450) * .33) + 51791.50; 
			}else if(income >= 151901) {
				return ((income - 151900) * .28) + 29517.50; 
			}else if(income >= 75301) {
				return ((income - 75300) * .25) + 10367.50; 
			}else if(income >= 18551) {
				return ((income - 18550) * .15) + 1855; 
			}else {
				return (income * .10);
			}
		}
		if(status.equals("seperately")) {
			if(income >= 233476) {
				return ((income - 233475) * .396) + 65289.25;
			}else if(income >= 206676) {
				return ((income - 206675) * .35) + 55909.25; 
			}else if(income >= 115726) {
				return ((income - 115725) * .33) + 25895.75; 
			}else if(income >= 75951) {
				return ((income - 75950) * .28) + 14758.75; 
			}else if(income >= 37651) {
				return ((income - 37650) * .25) + 5183.75; 
			}else if(income >= 9276) {
				return ((income - 9275) * .15) + 927.50; 
			}else {
				return (income * .10); 
			}
		}
		if(status.equals("head of household")) {
			if(income >= 441001) {
				return ((income - 441000) * .396) + 125936;
			}else if(income >= 413351) {
				return ((income - 413350) * .35) + 116258.50; 
			}else if(income >= 210801) {
				return ((income - 210800) * .33) + 49417; 
			}else if(income >= 130151) {
				return ((income - 130150) * .28) + 26835; 
			}else if(income >= 50401) {
				return ((income - 50400) * .25) + 6897.50; 
			}else if(income >= 13251) {
				return ((income - 13250) * .15) + 1325; 
			}else {
				return (income * .10); 
			}
		}
		return 0;
	}
	
	static boolean getContInput(Scanner sc) {
		System.out.println("Would you like to calculate another tax liability? (Y or N) ");
		String input = sc.next();
		if(input.toUpperCase().equals("Y")) {
			return true;
		}
		if(input.toUpperCase().equals("N")) {
			return false;
		}else {
			System.out.println("That was an invalid input!");
			return getContInput(sc);
		}
	}
	
}
