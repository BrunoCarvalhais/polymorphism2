package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

        List<Product> product = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Product #" + i + " data:");
            System.out.print("Commom, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (ch == 'i'){
                System.out.println("Custom fee: ");
                double customsFee = sc.nextDouble();
                product.add(new ImportedProduct(name, price, customsFee));
            } else if (ch == 'c'){
                product.add(new Product(name, price));
            } else {
                System.out.println("Manufacture date (DD/MM/YYYY)");
                Date manufactureDate = sdf.parse(sc.next());
                product.add(new UsedProduct(name, price, manufactureDate));
            }
        }

        System.out.println("Price Tags: ");
        for (Product prd : product){
            System.out.println(prd.priceTag());
        }
    }
}
