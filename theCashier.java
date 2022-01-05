
public class theCashier extends myHospital {
	
	private String tempChoice = "";
	private String tempPatID = "";
	private int tempID = 0;
	private String tempBill = "";
	private String tempPayment = "";
	private int value = 0;
	
	public void BillingSystem() throws Exception {
		boolean valChoice = false;
		do {
		System.out.println("\n==============================");
		System.out.println("  ***** BILLING SYSTEM *****  ");
		System.out.println("==============================");
		System.out.printf("There are %d patient/s registered!\n\n", totalPat);
		System.out.println("[1] Add Bill");
		System.out.println("[2] Add Payment");
		System.out.println("[3] View Transactions");
		System.out.println("[0] Back");
		System.out.println("======================================");
		System.out.print("Enter Choice -> ");
		tempChoice = input.nextLine();
		
		switch(tempChoice) {
		case "1": {	 valChoice = true;break;	}
		case "2": {	 valChoice = true;break;	}
		case "3": {	 valChoice = true;break;	}
		case "0": { valChoice = true; break;}
		default: { System.out.println("Invalid input Please try again!\n");		}
		}
		}while(valChoice != true);
		
		if(tempChoice.equals("1"))
			{ tempID = SearchID();
			  option(tempID);}
		
		else if(tempChoice.equals("2"))
			{ tempID = SearchID();
			  AddPayment(tempID);}
		
		else if(tempChoice.equals("3"))
			{ tempID = SearchID(); 
			  viewTransactions(tempID);}
	}
	
	public void BillComputation(int userID) {
		int getCtr = billCounter[userID][0];
		PatBill[userID][0] = 0;
		
		for(int i = 0; i < getCtr; i++) {
			int getBill = listOfBills[userID][i];
			PatBill[userID][0] += rateOfBill[getBill];
		}
		
		PatBalance[userID][0] = PatBill[userID][0] - PatPayment[userID][0];
		
	}
	
	public void AddPayment(int userID) throws Exception {
		System.out.println("\n===========================");
		System.out.println("  ***** ADD PAYMENT *****  ");
		System.out.println("===========================");
		
		int getCtr = billCounter[userID][0];
		
		if(getCtr == 0) {
			System.out.println("No records found!");
		}
		else {
		System.out.println("\n========================");
		System.out.println("      BILL RECORDS      ");
		System.out.println("========================");
		System.out.printf("Billing ID : %s\n", PatID.get(userID));
		System.out.printf("Billing Name : %s\n", PatName.get(userID));
		
		for(int i = 0; i < getCtr; i++) {
			int getBill = listOfBills[userID][i];
			System.out.printf("\n[%s] %s\t%s", i+1, nameOfBill.get(getBill), rateOfBill[getBill]);
		}
		BillComputation(userID);
		System.out.println("\n=================================");
		System.out.println("TOTAL BILLS  : " + PatBill[userID][0]);
		System.out.println("PAYMENT MADE : " + PatPayment[userID][0]);
		System.out.println("BALANCE      : " + PatBalance[userID][0]);

		
		if(PatBalance[userID][0] == 0) {
			
			System.out.println("Medical Bills have been settled already.");
		}
		else {
			
			System.out.print("Enter amount of payment = > ");
			tempPayment = input.nextLine();
			
			value = checkPayment(tempPayment);
			
			if(value == 0 ) { System.out.println("Invalid payment!");}
			else {
				if(value >= PatBill[userID][0]) {
				double tempChange = value - PatBalance[userID][0];
				SavingChanges();
					System.out.println("Payment Successful!");
					System.out.println("========================");
					System.out.println("CHANGE : " + tempChange);
					System.out.println("========================");
				PatBill[userID][0] = 0;
				PatBalance[userID][0] = 0;
				PatPayment[userID][0] = 0;
				billCounter[userID][0] = 0;
				
				}
				else {
					PatPayment[userID][0] += value;
					PatBalance[userID][0] = PatBalance[userID][0] - value;
					SavingChanges();
					System.out.println("Payment Successful!");
					}
				}
			
			}
		}
		halt();
	}
	
	
	public int checkPayment(String a) {
		char[] checker = a.toCharArray();
		StringBuilder change = new StringBuilder();
		for(char i: checker) {
			if(Character.isDigit(i)) {
				change.append(i);
			}
		}
		
		int finalValue  = 0;
		String newValue = String.valueOf(change);
		if(newValue.equals(null) || newValue.equals("")) {
			finalValue = 0;
		}
		else{
			finalValue = Integer.parseInt(newValue);
		}
		
		return finalValue;
		
	}
	public int SearchID() throws Exception {
		boolean idFound = false;
		
		System.out.println("\n==============================");
		System.out.println("  ***** SEARCH PATIENT *****  ");
		System.out.println("==============================");
		
		do {
		System.out.print("[0] Exit\n\nEnter Patient's ID # : ");		
		tempPatID = input.nextLine();
		
		Loading();
		if(!tempPatID.equals("0") && !tempPatID.equals("")) {
			for(int i = 0; i < totalPat; i++) {
				if(tempPatID.equals(PatID.get(i))) {

					idFound = true;
					tempID = i;
				}
			}
			if(idFound == false)
				System.out.println("ID not found!\n");
		}
		else if(tempPatID.equals("0")) {
			idFound = true;
		}
		else
			System.out.println("Invalid input!");
		}while(idFound != true);
		return tempID;
	}
	
	public void option(int i) throws Exception{
		boolean found = false;
		
		System.out.println("\n==========================");
		System.out.println("     SERVICES OFFERED     ");
		System.out.println("==========================");
		
		System.out.println("[1] Out-Patient Services");
		System.out.println("[2] Medical Records Services");
		System.out.println("[3] In-Patient Services");
		System.out.println("[4] Other Charges");
		System.out.println("[0] Back\n");
		
		do {
		System.out.print("Enter your choice => ");
		tempChoice = input.nextLine();
		
		switch(tempChoice) {
		case "1": found = true; break;
		case "2": found = true; break;
		case "3": found = true; break;
		case "4": found = true; break;
		case "0": found = true; break;
		default: System.out.println("Invalid input!\n");
		}
		
		}while(found != true);
		
		switch(tempChoice) {
		case "1": OutServices(i); break;
		case "2": MedicalRecords(i); break;
		case "3": InServices(i); break;
		case "4": OtherServices(i);break;
		}
	}
	
	public void OutServices(int i) throws Exception{
		boolean found = false;
		
		System.out.println("========================");
		System.out.println("  ***** ADD BILL *****  ");
		System.out.println("========================");
		System.out.println("OUT-PATIENT SERVICES\n");
		for(int a = 1; a < 10; a++) {
			System.out.printf("[%s] %s\t%s\n", a, nameOfBill.get(a), rateOfBill[a]);
		}
		
		do {
		System.out.print("\nEnter bill # => ");
		tempBill = input.nextLine();
		
		switch(tempBill) {
		case "1": found = true; break;
		case "2": found = true; break;
		case "3": found = true; break;
		case "4": found = true; break;
		case "5": found = true; break;
		case "6": found = true; break;
		case "7": found = true; break;
		case "8": found = true; break;
		case "9": found = true; break;
		case "0": found = true; break;
		default: System.out.println("Invalid input!\n");
		}
		}while(found != true);
		
		if(!tempBill.equals("0")) {
			confirmBill(i);
		}

	}
	
	public void MedicalRecords(int i) throws Exception{
		boolean found = false;
		
		System.out.println("\n  ***** ADD BILL *****  ");
		System.out.println("============================");
		System.out.println("  MEDICAL RECORDS SERVICES\n");
		for(int a = 10; a < 13; a++) {
			System.out.printf("[%s] %s\t%s\n", a, nameOfBill.get(a), rateOfBill[a]);
		}
		
		do {
		System.out.print("\nEnter bill # => ");
		tempBill = input.nextLine();
		
		switch(tempBill) {
		case "10": found = true; break;
		case "11": found = true; break;
		case "12": found = true; break;
		case "0": found = true; break;
		default: System.out.println("Invalid input!\n");
		}
		}while(found != true);
		
		if(!tempBill.equals("0")) {
			confirmBill(i);
		}

	}
	
	public void InServices(int i)throws Exception {
		boolean found = false;
		
		System.out.println("\n========================");
		System.out.println("  ***** ADD BILL *****  ");
		System.out.println("========================");
		System.out.println("   IN-PATIENT SERVICES\n");
		for(int a = 13; a < 19; a++) {
			
			System.out.printf("[%s] %s\t%s\n", a, nameOfBill.get(a), rateOfBill[a]);
			}
		
		do {
		System.out.print("\nEnter bill # => ");
		tempBill = input.nextLine();
		
		switch(tempBill) {
		case "13": found = true; break;
		case "14": found = true; break;
		case "15": found = true; break;
		case "16": found = true; break;
		case "17": found = true; break;
		case "18": found = true; break;
		case "0": found = true; break;
		default: System.out.println("Invalid input!\n");
		}
		}while(found != true);
		
		if(!tempBill.equals("0")) {
			
			confirmBill(i);
		}

	}
	
	
	public void OtherServices(int i) throws Exception{
		boolean found = false;
		
		System.out.println("\n========================");
		System.out.println("  ***** ADD BILL *****  ");
		System.out.println("========================");
		System.out.println("     OTHER SERVICES\n");
		for(int a = 19; a < 25; a++) {
			System.out.printf("[%s] %s\t%s\n", a, nameOfBill.get(a), rateOfBill[a]);
		}
		
		do {
		System.out.print("\nEnter bill # => ");
		tempBill = input.nextLine();
		
		switch(tempBill) {
		case "19": found = true; break;
		case "20": found = true; break;
		case "21": found = true; break;
		case "22": found = true; break;
		case "23": found = true; break;
		case "24": found = true; break;
		case "0": found = true; break;
		default: System.out.println("Invalid input!\n");
		}
		}while(found != true);
		
		if(!tempBill.equals("0")) {
			confirmBill(i);
		}

	}
	
	public void confirmBill(int userID) throws Exception{
		boolean found = false;
		do {
		System.out.println("\n========================");
		System.out.println("      CONFIRM BILL      ");
		System.out.println("========================");
		System.out.printf("Billing ID : %s\n", PatID.get(userID));
		System.out.printf("Billing Name : %s\n", PatName.get(userID));
		System.out.printf("*****\n%s\t%s\n", nameOfBill.get(Integer.parseInt(tempBill)).toUpperCase(), rateOfBill[Integer.parseInt(tempBill)]);
		
		
		System.out.println("\n[1] Confirm\n[0] Cancel");
		System.out.print("Enter your choice => ");
		tempChoice = input.nextLine();
		
		switch(tempChoice) {
		case "1": found = true; break;
		case "0": found = true; break;
		default: System.out.println("Invalid input!\n");
		}
		}while(found != true);
		
		if(tempChoice.equals("1")) {
			int getCtr = 0;
			getCtr = billCounter[userID][0];
			
			listOfBills[userID][getCtr] = Integer.parseInt(tempBill);
			billCounter[userID][0]++;
			SavingChanges();
			System.out.println("Bill has been added successfull!\n");
			
			
		}
		halt();
	}
	
	public void viewTransactions(int userID) throws Exception{
		int getCtr = billCounter[userID][0];
		
		if(getCtr == 0) {
			System.out.println("No records found!");
		}
		else {
		System.out.println("\n========================");
		System.out.println("      BILL RECORDS      ");
		System.out.println("========================");
		System.out.printf("Billing ID : %s\n", PatID.get(userID));
		System.out.printf("Billing Name : %s\n", PatName.get(userID));
		
		for(int i = 0; i < getCtr; i++) {
			int getBill = listOfBills[userID][i];
			System.out.printf("\n[%s] %s\t%s", i+1, nameOfBill.get(getBill), rateOfBill[getBill]);
		}
		BillComputation(userID);
		System.out.println("\n========================");
		System.out.println("TOTAL BILLS  : " + PatBill[userID][0]);
		System.out.println("PAYMENT MADE : " + PatPayment[userID][0]);
		System.out.println("BALANCE      : " + PatBalance[userID][0]);
		}
		halt();
		
		
	}
	
	
	}
	

