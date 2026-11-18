public class ProductCalculationTest {

    public static void GetVat_WithValidData_ReturnsCorrectValue() {
        double price = 3500.0;
        ProductCalculations calc = new ProductCalculations(price);

        double vat = calc.GetVat();

        if (vat == 525.0) {
            System.out.println("GetVat_WithValidData_ReturnsCorrectValue() PASSED!");
        } else {
            System.out.println("GetVat_WithValidData_ReturnsCorrectValue() FAILED!");
        }
    }

    public static void GetTotal_WithValidData_ReturnsCorrectValue() {
        double price = 3500.0;
        ProductCalculations calc = new ProductCalculations(price);

        double total = calc.GetTotal();

        if (total == 4200.0) {
            System.out.println("GetTotal_WithValidData_ReturnsCorrectValue() PASSED!");
        } else {
            System.out.println("GetTotal_WithValidData_ReturnsCorrectValue() FAILED!");
        }
    }
}