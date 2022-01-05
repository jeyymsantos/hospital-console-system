

public class myLogin extends myHospital{
	
	private String tempUsername = "";
	private String tempPassword = "";
	private boolean validate = false;
	
	// Validation of User-Login
	public void validateLogin() throws Exception {
		System.out.println("***** HOSPITAL MANAGEMENT SYSTEM *****");
		System.out.println("=====            v1.0            =====");
		System.out.println("======================================\n");
		do {
			do {
				System.out.print("Enter your username : ");
				tempUsername = input.nextLine();
			}while(!noInput(tempUsername));
			
			do {
				System.out.print("Enter your password : ");
				tempPassword = input.nextLine();
			}while(!noInput(tempPassword));
		
		}while(!checker());
		mainMethod();
	}
	
	public boolean noInput(String check) {
		boolean validate = false;
		switch(check) 
		{
		case "": System.out.println("Field required!\n"); validate = false; break;
		default: validate = true;
		}
		return validate;
	}
	public boolean checker() {
		for(int ctr = 0; ctr < username.length; ctr++) 
		{
			if(tempUsername.equals(username[ctr]) && tempPassword.equals(password[ctr])) {
				System.out.println("Access granted!\n");
				validate = true;
				empCounter = ctr;
			}
		}
		if(validate == false)
			{System.out.println("Invalid input!\n");}
		return validate;
	}
	
	public void mainMethod() throws Exception{
		MainMenu myMenu = new MainMenu();
		switch(empCounter) {
		case 1: {myMenu.CashierMenu(empCounter); break;}
		case 2: {myMenu.ClerkMenu(empCounter);break;}
		case 0: {myMenu.AdminMenu(empCounter); break;}
		}
		
	}
	
	
}
