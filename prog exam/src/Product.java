
public class Product implements IProduct {
    private int[][] salesData;
    private String[] productNames;

    public Product(int[][] salesData, String[] productNames) {
        this.salesData = salesData;
        this.productNames = productNames;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int totalElements = 0;
        for (int i = 0; i < salesData.length; i++) {
            totalElements += salesData[i].length;
        }
        return (double) total / totalElements;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int bestProductIndex = 0;

        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                currentProductTotal += salesData[i][j];
            }
            if (currentProductTotal > maxSales) {
                maxSales = currentProductTotal;
                bestProductIndex = i;
            }
        }
        return productNames[bestProductIndex] + " (" + maxSales + ")";
    }
}