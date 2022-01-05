

public class theAdmin extends myHospital{
	
		private String tempChoice;
		private boolean valChoice = false;
		private int editChecker = 0;
		private String tempPatID;
		private String tempPatName;
		private String tempPatGender;
		private String tempPatRoom;
		private String tempPatType;
		private String tempPatDateOfBirth;
		private String tempPatMobNum;
		private String tempPatAddress;
		private String tempPatDoctor;
		private String tempPatMedication;
		private String tempPatDisease;
		
	public void FileMaintenance() throws Exception {
		
		do {
		System.out.println("\n======================================");
		System.out.println("     ***** FILE MAINTENANCE *****     ");
		System.out.println("======================================");
		System.out.printf("There are %d patient/s registered!\n\n", totalPat);
		System.out.println("[1] Add Patient");
		System.out.println("[2] Edit Patient");
		System.out.println("[3] Delete Patient");
		System.out.println("[4] Display Patients");
		System.out.println("[0] Back");
		System.out.println("======================================");
		System.out.print("Enter Choice -> ");
		tempChoice = input.nextLine();
		
		switch(tempChoice) {
		case "1": {	 valChoice = true;break;	}
		case "2": {  valChoice = true;break;		}
		case "3": {  valChoice = true;break; }
		case "4": {  valChoice = true;break; }
		case "0": { valChoice = true; break;}
		default: { System.out.println("Invalid input Please try again!\n");	halt();}
		}
		}while(valChoice != true);
		
		if(tempChoice.equals("1"))
			{AddPatient();
			
		
			}
		else if(tempChoice.equals("2"))
			{EditPatient();
			
			}
		else if(tempChoice.equals("3"))
			{DeletePatient();
			
			}
		else if(tempChoice.equals("4"))
			{viewPatients();
			
			}
	}
	
	
	public void AddPatient() throws Exception{
		editChecker = 0;
		System.out.println("\n=================================");
		System.out.println("     ***** ADD PATIENT *****     ");
		System.out.println("=================================");
		
		do {
			System.out.print("Enter Patient's ID # : ");		
			tempPatID = input.nextLine();
		}while(validatePatID(tempPatID) == true);
		
		do {
		System.out.print("Enter Patient's Name : ");
		tempPatName = input.nextLine();
		}while(validatePatInfo(tempPatName) == true);
		
		System.out.print("Enter Patient's Type : ");
		tempPatType = input.nextLine();
			if(tempPatType.equals("IN-PATIENT")) {
				do {
				System.out.print("Enter Patient's Room # : ");
				tempPatRoom = input.nextLine();
				}while(validatePatRoom() == true);
			}
			
		do {	
		System.out.print("Enter Patient's Gender : ");
		tempPatGender = input.nextLine();
		}while(validatePatInfo(tempPatGender) == true);
		
		do {
		System.out.print("Enter Patient's Date of Birth : ");
		tempPatDateOfBirth = input.nextLine();
		}while(validatePatInfo(tempPatDateOfBirth) == true);
		
		do {
		System.out.print("Enter Patient's Mobile # : ");
		tempPatMobNum = input.nextLine();
		}while(validatePatInfo(tempPatMobNum) == true);
		
		do {
		System.out.print("Enter Patient's Address : ");
		tempPatAddress = input.nextLine();
		}while(validatePatInfo(tempPatAddress) == true);
		
		do{
			System.out.print("Enter Doctor's Name : ");
		tempPatDoctor = input.nextLine();
		}while(validatePatInfo(tempPatDoctor) == true);
		
		do {
		System.out.print("Enter Patient's Disease : ");
		tempPatDisease = input.nextLine();
		}while(validatePatInfo(tempPatDisease) == true);
		
		do {
		System.out.print("Enter Patient's Medication : ");
		tempPatMedication = input.nextLine();
		}while(validatePatInfo(tempPatMedication) == true);
		
		displayPatient();
	
	}
	
	
	public boolean validatePatInfo(String x) {
		boolean found = false;
			if(x.equals("")){
				found = true;
				System.out.println("Please input field! Try again!\n");}
			else {
				found = false;
			}
		return found;
	}
	
	
	
	public boolean validatePatRoom() {
		boolean found = false;
		for(int ctr =0; ctr < totalPat; ctr++) 
		{
			if(tempPatRoom.equals(PatRoom.get(ctr))) {
				found = true;
			}
		}
		if(found == true)
			{System.out.println("Patient Room unavailable! \nPlease try again!\n");}

		return found;
	}
	
	public boolean validatePatID(String x) {
		boolean found = false;
		if(x.equals("")) {
			System.out.println("Patient ID needed!\n");
			found = true;
		}
		else {
		for(int ctr =0; ctr < totalPat; ctr++) 
		{
			if(tempPatID.equals(PatID.get(ctr))) {
				found = true;
			}
		}
		if(found == true)
			{System.out.println("Patient ID unavailable! \nPlease try again!\n");}
		}
		return found;
	}
	
	public void displayPatient() throws Exception {
		System.out.println("\n===============================");
		System.out.println("  ***** CONFIRM PATIENT *****  ");
		System.out.println("===============================");
		System.out.printf("ID Number     : %s\n", tempPatID);
		System.out.printf("Name          : %s\n", tempPatName);
		System.out.printf("Type          : %s\n", tempPatType);
		if(tempPatType.equals("IN-PATIENT")) {
			System.out.printf("ID Number     : %s\n", tempPatRoom);
		}
		System.out.printf("Gender        : %s\n", tempPatGender);
		System.out.printf("Date of Birth : %s\n", tempPatDateOfBirth);
		System.out.printf("Mobile #      : %s\n", tempPatMobNum);
		System.out.printf("Address       : %s\n", tempPatAddress);
		System.out.printf("Doctor        : %s\n", tempPatDoctor);
		System.out.printf("Disease       : %s\n", tempPatDisease);
		System.out.printf("Medication    : %s\n", tempPatMedication);
		
		// CONFIRM SAVING OF PATIENT OR NOT
		do {
		valChoice = false;
		System.out.println("\n[1] Save Patient");
		System.out.println("[0] Cancel");
		System.out.print("Enter your choice => ");
		tempChoice = input.nextLine();
		
		if(tempChoice.equals("1")) {
			PatID.add(tempPatID);
			PatName.add(tempPatName);
			PatType.add(tempPatType);
			if(tempPatType.equals("IN-PATIENT")) {
				PatRoom.add(tempPatRoom);
			}
			else {
				PatRoom.add("---");
			}
			PatGender.add(tempPatGender);
			PatDateOfBirth.add(tempPatDateOfBirth);
			PatMobNum.add(tempPatMobNum);
			PatAddress.add(tempPatAddress);
			PatDoctor.add(tempPatDoctor);
			PatDisease.add(tempPatDisease);
			PatMedication.add(tempPatMedication);
			
			if(editChecker == 0) {
				totalPat++;
			}
			SavingChanges();
			System.out.println("Patient saved successfuly!"); halt();
			valChoice = true; 
				}
		
		else if(tempChoice.equals("0")) { 
			System.out.println("Patient not saved!\n"); halt();
			valChoice = true;

		}
		else{ 
			System.out.println("Invalid input!"); }
		
		}while(valChoice != true);
}
	
	public void viewPatients() {
		if(totalPat == 0 ) {
			System.out.println("\n=============================");
			  System.out.println("===SORRY! NO RECORD FOUND!===");
			  System.out.println("=============================\n");
		}
		else {
			for(int i = 0; i < totalPat; i++) {
				theCashier myCashier = new theCashier();
				myCashier.BillComputation(i);
				System.out.println("\n==============================================");
				System.out.printf("Patient ID   : %s\n", PatID.get(i));
				System.out.printf("Patient Type : %s\n", PatType.get(i));
				System.out.printf("Patient Room : %s\n", PatRoom.get(i));
				System.out.printf("Patient Name : %s\n", PatName.get(i));
				System.out.printf("==============================================\n");
				System.out.println("TOTAL BALANCE  : " + PatBalance[i][0]);	
				
		}
		}
		halt();
		
	}
	
	public void setEditPatient(int userID) throws Exception{
		System.out.println("\n===============================");
		System.out.println("  ***** CONFIRM PATIENT *****  ");
		System.out.println("===============================");
		System.out.printf("ID Number     : %s\n", tempPatID);
		System.out.printf("Name          : %s\n", tempPatName);
		System.out.printf("Type          : %s\n", tempPatType);
		if(tempPatType.equals("IN-PATIENT")) {
			System.out.printf("ID Number     : %s\n", tempPatRoom);
		}
		System.out.printf("Gender        : %s\n", tempPatGender);
		System.out.printf("Date of Birth : %s\n", tempPatDateOfBirth);
		System.out.printf("Mobile #      : %s\n", tempPatMobNum);
		System.out.printf("Address       : %s\n", tempPatAddress);
		System.out.printf("Doctor        : %s\n", tempPatDoctor);
		System.out.printf("Disease       : %s\n", tempPatDisease);
		System.out.printf("Medication    : %s\n", tempPatMedication);
		
		// CONFIRM SAVING OF PATIENT OR NOT
		do {
		valChoice = false;
		System.out.println("\n[1] Save Patient");
		System.out.println("[0] Cancel");
		System.out.print("Enter your choice => ");
		tempChoice = input.nextLine();
		
		if(tempChoice.equals("1")) {
			PatID.set(userID, tempPatID);
			PatName.set(userID, tempPatName);
			PatType.set(userID, tempPatType);
			if(tempPatType.equals("IN-PATIENT")) {
				PatRoom.set(userID, tempPatRoom);
			}
			else {
				PatRoom.set(userID,"---");
			}
			PatGender.set(userID, tempPatGender);
			PatDateOfBirth.set(userID, tempPatDateOfBirth);
			PatMobNum.set(userID, tempPatMobNum);
			PatAddress.set(userID, tempPatAddress);
			PatDoctor.set(userID, tempPatDoctor);
			PatDisease.set(userID, tempPatDisease);
			PatMedication.set(userID, tempPatMedication);
			
			if(editChecker == 0) {
				totalPat++;
			}
			SavingChanges();
			System.out.println("Patient saved successfuly!"); halt();
			valChoice = true; 
				}
		
		else if(tempChoice.equals("0")) { 
			System.out.println("Patient not saved!\n"); halt();
			valChoice = true;

		}
		else{ 
			System.out.println("Invalid input!"); }
		
		}while(valChoice != true);
	}
	
	
	public void EditPatient() throws Exception{
		boolean idFound = false;
		do {
			System.out.println("\n================================");
			System.out.println("    ***** EDIT PATIENT *****    ");
			System.out.println("================================");
		System.out.print("[0] Exit\n\nEnter Patient's ID # : ");		
		tempPatID = input.nextLine();
		
		if(!tempPatID.equals("0")) {
			for(int i = 0; i < totalPat; i++) {
				if(tempPatID.equals(PatID.get(i))) {
					int userCounter = i;
					do {
					System.out.print("Enter Patient's Name : ");
					tempPatName = input.nextLine();
					}while(validatePatInfo(tempPatName) == true);
					System.out.print("Enter Patient's Type : ");
					tempPatType = input.nextLine();
					if(tempPatType.equals("IN-PATIENT")) {
						System.out.print("Enter Patient's Room # : ");
						tempPatRoom = input.nextLine();
					}
					
					do {
					System.out.print("Enter Patient's Gender : ");
					tempPatGender = input.nextLine();
					}while(validatePatInfo(tempPatGender) == true);
					
					do {
					System.out.print("Enter Patient's Date of Birth : ");
					tempPatDateOfBirth = input.nextLine();
					}while(validatePatInfo(tempPatDateOfBirth) == true);
					
					do {
					System.out.print("Enter Patient's Mobile # : ");
					tempPatMobNum = input.nextLine();
					}while(validatePatInfo(tempPatMobNum) == true);
					
					do {
					System.out.print("Enter Patient's Address : ");
					tempPatAddress = input.nextLine();
					}while(validatePatInfo(tempPatAddress) == true);
					
					do {
					System.out.print("Enter Doctor's Name : ");
					tempPatDoctor = input.nextLine();
					}while(validatePatInfo(tempPatDoctor) == true);
					
					do {
					System.out.print("Enter Patient's Disease : ");
					tempPatDisease = input.nextLine();
					}while(validatePatInfo(tempPatDisease) == true);
					
					do {
					System.out.print("Enter Patient's Medication : ");
					tempPatMedication = input.nextLine();
					}while(validatePatInfo(tempPatMedication) == true);
					
					editChecker = 1;
					setEditPatient(userCounter);
					idFound = true;
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
	}
	
	public void DeletePatient() throws Exception{
		boolean idFound = false;
		do {
			System.out.println("\n==================================");
			System.out.println("    ***** DELETE PATIENT *****    ");
			System.out.println("==================================");
		System.out.print("[0] Cancel\n\nEnter Patient's ID # : ");		
		tempPatID = input.nextLine();
		
		if(!tempPatID.equals("0")) {
			for(int i = 0; i < totalPat; i++) {
			
			if(tempPatID.equals("")) {
				continue;
			}
				
			else if(tempPatID.equals(PatID.get(i))) {
					
					System.out.println("[1] Confirm Delete");
					System.out.println("[0] Cancel");
					System.out.printf("Delete %s? => ", tempPatID);
					tempChoice = input.nextLine();
					
					if(tempChoice.equals("1")) {
						PatID.remove(i);
						PatName.remove(i);
						PatType.remove(i);
						PatRoom.remove(i);
						PatGender.remove(i);
						PatMobNum.remove(i);
						PatDateOfBirth.remove(i);
						PatAddress.remove(i);
						PatDoctor.remove(i);
						PatDisease.remove(i);
						PatMedication.remove(i);
						totalPat--;
						SavingChanges();
						System.out.println("Patient successfuly deleted!");
						idFound = true;
					}
					else if(tempChoice.equals("0")){
						System.out.println("Patient has not been deleted.");
						idFound = true;
					}
					else {
						System.out.println("Invalid input! Changes not saved!");
					}
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
		halt();
	}
	
	
}
