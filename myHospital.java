import java.util.*;

public class myHospital {

	public String[] username = {"admin",	 "cashier", "clerk"};
	public String[] password = {"admin1234", "cashier5678", "itsclerk"};
	public static int totalPat = 10;
	public int empCounter = 0;
	
	public static ArrayList<String> PatID = new ArrayList<String>();
	public static ArrayList<String> PatName = new ArrayList<String>();
	public static ArrayList<String> PatRoom = new ArrayList<String>();
	public static ArrayList<String> PatType = new ArrayList<String>();
	public static ArrayList<String> PatGender = new ArrayList<String>();
	public static ArrayList<String> PatMobNum = new ArrayList<String>();
	public static ArrayList<String> PatDateOfBirth = new ArrayList<String>();
	public static ArrayList<String> PatAddress = new ArrayList<String>();
	public static ArrayList<String> PatDoctor = new ArrayList<String>();
	public static ArrayList<String> PatDisease = new ArrayList<String>();
	public static ArrayList<String> PatMedication = new ArrayList<String>();
	
	static myLogin login = new myLogin();
	static Scanner input = new Scanner(System.in);
	static theCashier cashier = new theCashier();
	
	
	public static ArrayList<String> nameOfBill = new ArrayList<String>();
	public static double rateOfBill[] = new double[100];
	public static int listOfBills[][] = new int[100][100];
	public static int billCounter[][] = new int[100][100];
	public static double PatBill[][] = new double[100][100];
	public static double PatPayment[][] = new double[100][100];
	public static double PatBalance[][] = new double[100][100];
	
	
	public void halt() {
		
		String stop = "";
		System.out.print("\nEnter any key to proceed...");
		stop = input.nextLine();
		System.out.println();
		
	}
	
	public static void Loading() throws java.lang.Exception {
		
		System.out.println("=====================");
		System.out.print("Loading");
		Thread.sleep(700);
		System.out.print(".");
		Thread.sleep(700);
		System.out.print(".");
		Thread.sleep(700);
		System.out.println(".");
		System.out.println("=====================\n");
	}
	
	public static void SavingChanges() throws java.lang.Exception{
		System.out.println("=====================");
		System.out.print("Saving changes");
		Thread.sleep(700);
		System.out.print(".");
		Thread.sleep(700);
		System.out.print(".");
		Thread.sleep(700);
		System.out.println(".");
		System.out.println("=====================\n");
	}
	
	public static void LoggingOut() throws java.lang.Exception{
		System.out.println("=====================");
		System.out.print("Logging out. Please wait");
		Thread.sleep(700);
		System.out.print(".");
		Thread.sleep(700);
		System.out.print(".");
		Thread.sleep(700);
		System.out.println(".");
		System.out.println("=====================\n");
	}
	
	public static void ServicesList() {
		
		nameOfBill.add("");
		//Out-Pat Services
		nameOfBill.add("Pre-Natal Service       "); 	rateOfBill[1] = 75.00;
		nameOfBill.add("General Consultation    ");		rateOfBill[2] = 75.00;
		nameOfBill.add("Follow-up Check Up      ");		rateOfBill[3] = 75.00;
		nameOfBill.add("Immunization            ");		rateOfBill[4] = 50.00;
		nameOfBill.add("Tuli                    ");		rateOfBill[5] = 450.00;
		nameOfBill.add("Non-Stress Test         ");		rateOfBill[6] = 200.00;
		nameOfBill.add("ElectroCardiography     ");		rateOfBill[7] = 200.00;
		nameOfBill.add("Papsmear                ");		rateOfBill[8] = 300.00;
		nameOfBill.add("Dental                  ");		rateOfBill[9] = 300.00;
		
		//Medical Records Services
		nameOfBill.add("Medical Certificate     ");		rateOfBill[10] = 115.00;
		nameOfBill.add("Live Birth              ");		rateOfBill[11] = 100.00;
		nameOfBill.add("Re-issue Live Birth     ");		rateOfBill[12] = 100.00;
		
		//In-Patient Services
		nameOfBill.add("Emergency Room Fee      ");		rateOfBill[13] = 800.00;		
		nameOfBill.add("Operating Room Fee      ");		rateOfBill[14] = 800.00;		
		nameOfBill.add("Laboratory Fee          ");		rateOfBill[15] = 800.00;		
		nameOfBill.add("Doctor's Fee            ");		rateOfBill[16] = 500.00;		
		nameOfBill.add("Private Room Fee        ");		rateOfBill[17] = 1000.00;	
		nameOfBill.add("Ward Room Fee           ");		rateOfBill[18] = 500.00;	
		
		//Other Charges
		nameOfBill.add("Admission Charges       ");		rateOfBill[19] = 100.00;
		nameOfBill.add("Injection Charges       ");		rateOfBill[20] = 50.00;
		nameOfBill.add("Attendant Food Charges  ");		rateOfBill[21] = 50.00;
		nameOfBill.add("Patient Food Charges    ");		rateOfBill[22] = 50.00;
		nameOfBill.add("Nebulization Charges    ");		rateOfBill[23] = 100.00;
		nameOfBill.add("Nurse Charges        ");		rateOfBill[24] = 200.00;	
	}
	public static void PatientsList() {
		PatID.add("PAT-01");
		PatName.add("Santos, Jhon Mark L.");
		PatRoom.add("RM-01");
		PatType.add("IN-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09308683775");
		PatDateOfBirth.add( "July 30, 2002");
		PatAddress.add("#0370, Brgy. Corazon, Calumpit, Bulacan");
		PatDoctor.add("Dr. Trinidad");
		PatDisease.add("Cancer");
		PatMedication.add("Therapy");
		
		PatID.add("PAT-02");
		PatName.add("De Guzman, AJ");
		PatRoom.add("RM-02");
		PatType.add("IN-PATIENT");
		PatGender.add("Female");
		PatMobNum.add("09559111058");
		PatDateOfBirth.add( "August 21, 2003");
		PatAddress.add("Iba Wawa, Hagonoy Bulacan");
		PatDoctor.add("Dr. Espanto");
		PatDisease.add("Dengue");
		PatMedication.add("Vaccines, Anti-flammatory & pain reliever medicines");
		
		PatID.add("PAT-03");
		PatName.add("Robles, Brenley Ian");
		PatRoom.add("RM-03");
		PatType.add("IN-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09123456789");
		PatDateOfBirth.add("June 30, 2002");
		PatAddress.add("Balita, Brgy. Dakila, Malolos, Bulacan");
		PatDoctor.add("Dr. Pascual");
		PatDisease.add("Dengue");
		PatMedication.add("Vaccines, Anti-flammatory & pain reliever medicines");
		
		PatID.add("PAT-04");
		PatName.add("Vergara, Terje C.");
		PatRoom.add("RM-04");
		PatType.add("IN-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09987654321");
		PatDateOfBirth.add("July 26, 2002");
		PatAddress.add("Corazon, Calumpit, Bulacan");
		PatDoctor.add("Dr. Rivera");
		PatDisease.add("Surgery");
		PatMedication.add("Bed rest for 5-7 days");
		
		PatID.add("PAT-05");
		PatName.add("Torres, Brett Russel P.");
		PatRoom.add("RM-05");
		PatType.add("IN-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("0954316780");
		PatDateOfBirth.add("September 25, 2002");
		PatAddress.add("Capalangan, Apalit, Pampanga");
		PatDoctor.add("Dr. Santos");
		PatDisease.add("Dengue");
		PatMedication.add("Vaccines, Anti-flammatory & pain reliever medicines");
		
		PatID.add("PAT-06");
		PatName.add("Cruz, Justine Renz");
		PatRoom.add("RM-06");
		PatType.add("OUT-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09514236870");
		PatDateOfBirth.add("December 28, 2003");
		PatAddress.add("Corazon, Calumpit, Bulacan");
		PatDoctor.add("Dr. Santos");
		PatDisease.add("Common Colds");
		PatMedication.add("Biogesic");
		
		PatID.add("PAT-07");
		PatName.add("Gazzingan, Christian");
		PatRoom.add("RM-07");
		PatType.add("OUT-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09998877665");
		PatDateOfBirth.add("February 14, 2003");
		PatAddress.add("Grand Royale, Malolos, Bulacan");
		PatDoctor.add("Dr. Jimenez");
		PatDisease.add("Tuli");
		PatMedication.add("Pain-reliver medicines and acetaminophen");
		
		PatID.add("PAT-08");
		PatName.add("Evangelista, Johnver C.");
		PatRoom.add("RM-08");
		PatType.add("OUT-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09123612789");
		PatDateOfBirth.add("May 16, 2003");
		PatAddress.add("Longos, Calumpit, Bulacan");
		PatDoctor.add("Dr. Santiago");
		PatDisease.add("Re-issue of Live Birth");
		PatMedication.add("N/A");
		
		PatID.add("PAT-09");
		PatName.add("Mendoza, Ryan Lorenz");
		PatRoom.add("RM-09");
		PatType.add("OUT-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09297029724");
		PatDateOfBirth.add("December 19, 2002");
		PatAddress.add("Gardenville, Calumpit, Bulacan");
		PatDoctor.add("Dr. Santiago");
		PatDisease.add("Dental");
		PatMedication.add("Ibuprofen and acetaminophen");
		
		PatID.add("PAT-10");
		PatName.add("Villanueva, Ezekiel Francae E.");
		PatRoom.add("RM-10");
		PatType.add("OUT-PATIENT");
		PatGender.add("Male");
		PatMobNum.add("09654106978");
		PatDateOfBirth.add("August 6, 2002");
		PatAddress.add("Capalangan, Apalit, Pampanga");
		PatDoctor.add("Dr. Jimenez");
		PatDisease.add("General Consultation");
		PatMedication.add("N/A");
		
	}
	public static void main(String args[]) throws Exception{		

		PatientsList();
		ServicesList();
		totalPat = PatID.size();
		login.validateLogin();
	}

}














































































