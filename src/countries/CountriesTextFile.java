package countries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



public class CountriesTextFile {
	
	public static ArrayList<String> readFromFile() {
		
		String fileName = "countries.txt"; 

		ArrayList<String> arrList = new ArrayList<>();
		
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				arrList.add(line);
				line = reader.readLine();

			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}
		return arrList;
	}
	
	public static void writeToFile(String country) {
		
		String fileName = "countries.txt";


		Path writeFile = Paths.get(fileName);

		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));

			outW.println(country);
			outW.close();
			System.out.println("Yessir");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}

	}
	
	public static void createFile(String fileName) {

		// String dirString = "CountriesFolder";
		

		Path filePath = Paths.get(fileName);

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation");

			}
		}

		System.out.println("File name: " + filePath.getFileName());
		System.out.println("Absolute at: " + filePath.toAbsolutePath());

	}

	// Create folder
	public static void createDirectory(String path) {

		// String path = "test";
		Path dirPath = Paths.get(path);

		// Path dirPath = Paths.get("resources"); // This is another way to do it

		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
				System.out.println("Folder was created successfully!");

			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
		}

	}
	
}
