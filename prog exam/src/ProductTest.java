public class ProductTest {

    public static void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int[][] mockSales = {
                {25, 18, 20},
                {15, 10, 12},
                {18, 15, 20}
        };
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        Product product = new Product(mockSales, productNames);

        int totalSales = product.GetTotalProductsSold();

        if (totalSales == 153) {
            System.out.println("GetTotalProductSales_WithValidData_ReturnsCorrectValue() PASSED!");
        } else {
            System.out.println("GetTotalProductSales_WithValidData_ReturnsCorrectValue() FAILED!");
        }
    }

    public static void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        int[][] mockSales = {
                {25, 18, 20},
                {15, 10, 12},
                {18, 15, 20}
        };
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        Product product = new Product(mockSales, productNames);

        double avgSales = product.GetAverageProductSold();

        if (avgSales == 17.0) {
            System.out.println("GetAverageSales_WithValidData_ReturnsCorrectValue() PASSED!");
        } else {
            System.out.println("GetAverageSales_WithValidData_ReturnsCorrectValue() FAILED!");
        }
    }
}
