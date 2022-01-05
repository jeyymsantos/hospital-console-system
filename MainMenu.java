import java.util.Scanner;

public class MainMenu extends myLogin{
	static Scanner input = new Scanner(System.in);
	private boolean valChoice = false;
	
	static theAdmin myAdmin = new theAdmin();
	static theClerk myClerk = new theClerk();
	static theCashier myCashier = new theCashier();
	
	public void AdminMenu(int getID) throws Exception{
		Loading();
    	String tempChoice;
		do {
			System.out.println("===============================");
	    	System.out.println("     ***** MAIN MENU *****     ");
			System.out.println("===============================");
			System.out.printf("Welcome, %s!\n", username[getID].toUpperCase());
			System.out.println("[1] File Maintenance");
			System.out.println("[2] Change Password");
			System.out.println("[3] Logout");
			System.out.println("[0] Exit System");
			System.out.println("===============================");
			System.out.print("Enter Choice -> ");
			tempChoice = input.nextLine();
			
			switch(tempChoice) {
				case "1": {	myAdmin.FileMaintenance(); break;		}
				case "2": {	changePass(getID); break;		}
				case "3": { valChoice = true; break; }
				case "0": { valChoice = true; break; }
				default: { System.out.println("Invalid input Please try again!");	halt();	}
			}
		}while(valChoice != true);
		
		if(tempChoice.equals("3"))
			{LoggingOut();validateLogin();}
		else
			exitMessage();
	}
	
	public void CashierMenu(int getID) throws Exception {
		Loading();
    	String tempChoice;
		do {
			System.out.println("===============================");
	    	System.out.println("     ***** MAIN MENU *****     ");
			System.out.println("===============================");
			System.out.printf("Welcome, %s!\n", username[getID].toUpperCase());
			System.out.println("[1] Billing System");
			System.out.println("[2] Change Password");
			System.out.println("[3] Logout");
			System.out.println("[0] Exit System");
			System.out.println("===============================");
			System.out.print("Enter Choice -> ");
			tempChoice = input.nextLine();
			
			switch(tempChoice) {
			case "1": {	myCashier.BillingSystem(); break;		}
			case "2": {	changePass(getID); break;		}
			case "3": { valChoice = true; break; }
			case "0": { valChoice = true; break; }
			default: { System.out.println("Invalid input Please try again!"); halt();		}
		}
	}while(valChoice != true);
	
	
	if(tempChoice.equals("3"))
		{LoggingOut();
		validateLogin();}
	else
		exitMessage();
	
	}
	
	public void ClerkMenu(int getID) throws Exception{
		Loading();
    	String tempChoice;
		do {
			System.out.println("===============================");
	    	System.out.println("     ***** MAIN MENU *****     ");
			System.out.println("===============================");
			System.out.printf("Welcome, %s!\n", username[getID].toUpperCase());
			System.out.println("[1] Patient's Information");
			System.out.println("[2] Change Password");
			System.out.println("[3] Logout");
			System.out.println("[0] Exit System");
			System.out.println("===============================");
			System.out.print("Enter Choice -> ");
			tempChoice = input.nextLine();
			
			switch(tempChoice) {
			case "1": {	myClerk.PatientInformation(); break;}
			case "2": {	changePass(getID); break;}
			case "3": { valChoice = true; break; }
			case "0": { valChoice = true; break; }
			default: { System.out.println("Invalid input Please try again!");halt();		}
		}
	}while(valChoice != true);
	
	if(tempChoice.equals("3"))
		{LoggingOut();validateLogin();}
	else
		exitMessage();
	}
	
	public void changePass(int id) throws Exception{
		String choice, tempPassword;
		System.out.println("     ***** CHANGE PASSWORD *****     ");
		System.out.println("=====================================");
		System.out.print("Enter new password : ");
		tempPassword = input.nextLine();
		System.out.println("\n[1] Save Changes");
		System.out.println("[0] Cancel");
		System.out.print("\nEnter your choice => ");
		choice = input.nextLine();
		
		switch(choice) {
		case "1": {SavingChanges();System.out.println("Changes saved!");
					password[id] = tempPassword; halt(); break;}
		case "0": {System.out.println("Changes not saved!"); halt(); break; }
		}
	}
	
	public void exitMessage() {
		System.out.println("\nThank you for using the Hospital Management System!");
	}
}
