public class PrintProduct { private IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void printReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int)Math.round(product.GetAverageProductSold()));
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
        System.out.println("**************************************************");
    }
}
