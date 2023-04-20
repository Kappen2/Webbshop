package Skobutik;

import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String firstName = JOptionPane.showInputDialog(null, "Skriv in ditt förnamn: ");
        String lastName = JOptionPane.showInputDialog(null, "Skriv in ditt efternamn: ");
        String pass = JOptionPane.showInputDialog(null, "Skriv in ditt lösenord: ");
        firstName = firstName.trim();
        lastName = lastName.trim();
        pass = pass.trim();
        Connect.connectToDatabase();
        int customerId = Connect.findCustomer(firstName, lastName, pass);
        String brand = JOptionPane.showInputDialog(null, "Skriv vilket märke du vill ha");
        String color = JOptionPane.showInputDialog(null, "Skriv vilken färg du vill ha");
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Skriv vilken storlek du vill ha"));
        int productId = Connect.chooseProduct(brand, color, size);
        int orderId = Connect.findOrder(customerId);
        Connect.AddToCart(customerId, orderId, productId);
        System.out.println("En " + color + " " + brand + ", storlek " + size + " har lagts i din varukorg");
    }
}
