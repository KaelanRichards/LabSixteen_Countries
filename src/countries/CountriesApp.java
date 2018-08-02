package countries;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userInput = 0;
		
		ArrayList<String> arrList = new ArrayList<>();
		
		CountriesTextFile.createFile("Countries.txt");
		System.out.println("Welcome to the countries Maintenance Application");
		
		
		do {
			printMenu();
			userInput = Validator.getInt(scan, "Enter a number: ", 1, 3);
			if (userInput == 1) {
				arrList = CountriesTextFile.readFromFile();
				for (String country : arrList) {
					System.out.println(country);
				}
				
			} else if (userInput == 2) {
				String userCountry = Validator.getString(scan, "Enter Country");
				CountriesTextFile.writeToFile(userCountry);
			} else if (userInput == 3){
				System.out.println("Bye!");
			}
			
		} while (!(userInput==3));
		

	}

	public static void printMenu() {

		System.out.println("1 - See the list of Countries");
		System.out.println("2 - Add a country");
		System.out.println("3 - Exit");

	}
}
