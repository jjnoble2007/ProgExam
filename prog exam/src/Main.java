import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {
                "Cozy Nights Monarch",
                "Restonic Barbados",
                "Sealy Phuket"
        };

        int[][] sales = new int[3][3];

        // Collecting user input following sample screenshot style
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                sales[i][j] = scanner.nextInt();
            }
        }

        Product productObj = new Product(sales, products);
        PrintProduct printer = new PrintProduct(productObj);
        printer.printReport();

        scanner.close();
    }
}