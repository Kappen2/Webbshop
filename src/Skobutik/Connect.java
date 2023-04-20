package Skobutik;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

public class Connect {
    public static int findCustomer(String firstname, String lastname, String password) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("src/Skobutik/Settings.properties"));
        int customer = 0;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement prep = con.prepareStatement("SELECT id from kund where förnamn = ? and efternamn = ? and lösenord = ?");
            /*PreparedStatement prep = (firstname,lastname, password) -> {con.prepareStatement("SELECT id from kund where förnamn = "+firstname+" and efternamn = "+lastname+" and lösenord = "+password);};*/
            prep.setString(1, firstname);
            prep.setString(2, lastname);
            prep.setString(3, password);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                customer = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Ett fel uppstod");
            throw new RuntimeException(e);
        }
        return customer;
    }
        public static void connectToDatabase() throws IOException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/Skobutik/Settings.properties"));

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(("SELECT pris, storlek, antal, märke, färg from produkt"));

            List<Produkt> prod = new ArrayList<>();

            while (rs.next()) {
                Produkt temp = new Produkt();
                int pris = rs.getInt("pris");
                temp.setPris(pris);
                int storlek = rs.getInt("storlek");
                temp.setStorlek(storlek);
                int antal = rs.getInt("antal");
                temp.setAntal(antal);
                String färg = rs.getString("färg");
                temp.setFärg(färg);
                String märke = rs.getString("märke");
                temp.setMärke(märke);
                prod.add(temp);
            }
            prod.forEach(pro -> System.out.println(pro.getPris() + " " + pro.getStorlek() + " " + pro.getAntal() + " " + pro.getFärg() + " " + pro.getMärke()));

        } catch (SQLException e) {
            System.out.println("Ett fel uppstod");
            throw new RuntimeException(e);
        }
    }

    public static int chooseProduct(String brand, String color, int size) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("src/Skobutik/Settings.properties"));
        int chosenProduct = 0;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement prep = con.prepareStatement("SELECT id from produkt where märke = ? and färg = ? and storlek = ?");
            prep.setString(1, brand);
            prep.setString(2, color);
            prep.setInt(3, size);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                chosenProduct = rs.getInt("id");
            }
        }
        catch (SQLException e) {
            System.out.println("Ett fel uppstod");
            throw new RuntimeException(e);
        }
        return chosenProduct;
    }
    public static void AddToCart(int customerId, int orderId, int productId) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("src/Skobutik/Settings.properties"));

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            CallableStatement call = con.prepareCall("Call AddToCart(?,?,?)");
            call.setInt(1, customerId);
            call.setInt(2, orderId);
            call.setInt(3, productId);
            call.executeQuery();
        }
        catch (SQLException e) {
            System.out.println("Ett fel uppstod");
            throw new RuntimeException(e);
    }
    }
    public static int findOrder(int customerId) throws IOException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/Skobutik/Settings.properties"));
        int orderId = 0;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"))) {
            PreparedStatement prep = con.prepareStatement("SELECT id from beställning where kundId = ?");
            prep.setInt(1, customerId);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                orderId = rs.getInt("id");
            }
        } catch (SQLException e) {
            Consumer n = t -> System.out.println(t);
            n.accept("Ett fel uppstod");
            throw new RuntimeException(e);
        }
        return orderId;
    }
}
