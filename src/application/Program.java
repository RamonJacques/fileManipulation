package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		try (BufferedReader br = new BufferedReader(
				new FileReader("c:\\temp\\ws-eclipse\\fileManipulation\\item-list.csv"))) {
			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
