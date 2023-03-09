package Skobutik;

import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Connect c = new Connect();
        String firstName = JOptionPane.showInputDialog(null, "Skriv in ditt förnamn: ");
        String lastName = JOptionPane.showInputDialog(null, "Skriv in ditt efternamn: ");
        String pass = JOptionPane.showInputDialog(null, "Skriv in ditt lösenord: ");
        firstName = firstName.trim();
        lastName = lastName.trim();
        pass = pass.trim();
        c.connectToDatabase();
        int customerId = c.findCustomer(firstName, lastName, pass);
        String brand = JOptionPane.showInputDialog(null, "Skriv vilket märke du vill ha");
        String color = JOptionPane.showInputDialog(null, "Skriv vilken färg du vill ha");
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv vilken storlek du vill ha"));
        int productId = c.chooseProduct(brand, color, size);
        int orderId = c.findOrder(customerId);
        c.AddToCart(customerId, orderId, productId);
    }
}
