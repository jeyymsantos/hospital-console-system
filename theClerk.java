
public class theClerk extends myHospital{

	private String tempChoice = "";
	private String tempPatID = "";
	
	public void PatientInformation() throws Exception{
		boolean valChoice = false;
		do {
		System.out.println("\n====================================");
		System.out.println("   ***** PATIENT INFORMATION *****  ");
		System.out.println("====================================");
		System.out.printf("There are %d patient/s registered!\n\n", totalPat);
		System.out.println("[1] Search Patient");
		System.out.println("[0] Back");
		System.out.println("======================================");
		System.out.print("Enter Choice -> ");
		tempChoice = input.nextLine();
		
		switch(tempChoice) {
		case "1": {	 valChoice = true;break;	}
		case "0": { valChoice = true; break;}
		default: { System.out.println("Invalid input Please try again!\n");		}
		}
		}while(valChoice != true);
		
		if(tempChoice.equals("1"))
			{ SearchPatient();}

	}
	
	public void SearchPatient() throws Exception{
		boolean idFound = false;
		do {
			System.out.println("\n============================");
			System.out.println(" ***** SEARCH PATIENT ***** ");
			System.out.println("============================");
		System.out.print("[0] Exit\n\nEnter Patient's ID # : ");		
		tempPatID = input.nextLine();
		Loading();
		if(!tempPatID.equals("0") && !tempPatID.equals("")) {
			for(int i = 0; i < totalPat; i++) {
				if(tempPatID.equals(PatID.get(i))) {
					System.out.println("\nPATIENT INFORMATION");
					System.out.printf("Patient ID    : %s\n", PatID.get(i));
					System.out.printf("Patient Name  : %s\n", PatName.get(i).toUpperCase());
					System.out.printf("Patient Type  : %s\n", PatType.get(i));
					System.out.printf("Patient Room  : %s\n\n", PatRoom.get(i));
					
					System.out.println("PERSONAL INFORMATION");
					System.out.printf("Gender        : %s\n", PatGender.get(i));
					System.out.printf("Mobile Number : %s\n", PatMobNum.get(i));
					System.out.printf("Address       : %s\n", PatAddress.get(i));
					System.out.printf("Gender        : %s\n\n", PatGender.get(i));
					
					System.out.println("DOCTOR'S PRESCRIPTIONS");
					System.out.printf("Doctor        : %s\n", PatDoctor.get(i));
					System.out.printf("Disease       : %s\n", PatDisease.get(i));
					System.out.printf("Medication    : \n\t%s\n\n", PatMedication.get(i));
					
					System.out.println("BILLING TRANSACTIONS");
					System.out.printf("==============================================\n");
					System.out.println("TOTAL BALANCE  : " + PatBalance[i][0]);
					
					halt();
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
	
}
