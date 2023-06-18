package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new FileReader("c:\\temp\\ws-eclipse\\fileManipulation\\item-list.csv"))) {
			String line = br.readLine();

			while (line != null) {
				String[] vect = line.split(",");
				String name = vect[0];
				Double value = Double.parseDouble(vect[1]);
				int quantity = Integer.parseInt(vect[2]);
				list.add(new Product(name, value, quantity));
				
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("c:\\temp\\ws-eclipse\\fileManipulation\\out\\summary.csv"))) {
			for(Product product : list) {
				bw.write(product.getName() + "," + String.format("%.2f", product.totalValue()));
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();;
		}
	}

}
