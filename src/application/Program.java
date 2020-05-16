package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Commom, used or imported (c/u/i)? ");
			char res = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(res == 'i') {
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, fee);
				list.add(product);
			}
			else if (res == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date d = sdf.parse(sc.next());
				Product product = new UsedProduct(name, price, d);
				list.add(product);
			}
			else if (res == 'c') {
				Product product = new Product(name, price);
				list.add(product);
			}
			System.out.println();
		}
		System.out.println("PRICE TAGS:");
		for (Product p : list) {
			System.out.println(p.priceTag());
		}
		
	}

}
