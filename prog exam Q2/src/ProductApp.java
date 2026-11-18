
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ProductApp extends JFrame {
    JTextField txtCustomer, txtPrice;
    JComboBox<String> cmbProduct;

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Menu Bar
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        mb.add(fileMenu);
        mb.add(toolsMenu);
        setJMenuBar(mb);

        // Form Labels & Fields
        JLabel lbl1 = new JLabel("Customer Name:");
        lbl1.setBounds(30, 30, 120, 25);
        add(lbl1);

        txtCustomer = new JTextField();
        txtCustomer.setBounds(160, 30, 180, 25);
        add(txtCustomer);

        JLabel lbl2 = new JLabel("Select Product:");
        lbl2.setBounds(30, 80, 120, 25);
        add(lbl2);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(160, 80, 180, 25);
        add(cmbProduct);

        JLabel lbl3 = new JLabel("Enter Price:");
        lbl3.setBounds(30, 130, 120, 25);
        add(lbl3);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 130, 180, 25);
        add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(100, 180, 180, 30);
        add(btnProcess);

        // Button and Menu Actions
        btnProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAndSave();
            }
        });

        processItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAndSave();
            }
        });

        clearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCustomer.setText("");
                txtPrice.setText("");
                cmbProduct.setSelectedIndex(0);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Helper method to do calculations and write to file
    void calculateAndSave() {
        try {
            String customer = txtCustomer.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double comm = calc.GetCommission();
            double total = calc.GetTotal();

            // Show popup message box
            JOptionPane.showMessageDialog(this,
                    "Customer Name: " + customer + "\n" +
                            "Product: " + product + "\n" +
                            "VAT: R " + vat + "\n" +
                            "COMMISSION: R " + comm + "\n" +
                            "TOTAL: R " + total);

            // Save to data.txt
            FileWriter fw = new FileWriter("data.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("DATA LOG");
            pw.println("**************************************************");
            pw.println("Customer Name: " + customer);
            pw.println("Product: " + product);
            pw.println("VAT: R " + vat);
            pw.println("COMMISSION: R " + comm);
            pw.println("TOTAL: R " + total);
            pw.println("**************************************************");
            pw.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price!");
        }
    }

    public static void main(String[] args) {
        new ProductApp().setVisible(true);
    }
}