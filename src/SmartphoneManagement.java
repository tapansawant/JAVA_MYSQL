//
//2. Create a java project “ smart phone management system ” to manage the smartphone data  using MySQL database .
//        Database name : SmartPhoneDb
//        •	Add the smartphones ( imei, brand , model , price  )
//        •	View All smartphones
//        •	Search phones based on brand
//        •	Edit the smart phone data using imei number
//        •	Delete the smart phone data from db using imei number


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SmartphoneManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int options;
        while(true) {
            System.out.println("Press 1 to Add the Smartphones");
            System.out.println("Press 2 to View all smartphones");
            System.out.println("Press 3 to Search phones based on brand");
            System.out.println("Press 4 to Edit smartphone data using imei number");
            System.out.println("Press 5 to Delete the smart phone data from db using imei number");
            System.out.println("Press 6 to Exit");
            System.out.println("***********");
            System.out.println("Make ur choice");

            options = sc.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Enter imei : ");
                    String imei = sc.next();
                    System.out.println("Enter brand name: ");
                    String brand = sc.next();
                    System.out.println("Enter model : ");
                    String model = sc.next();
                    System.out.println("Enter price: ");
                    String price = sc.next();
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `smartphone`(`imei`, `brand`, `model`, `price`) VALUES('"+imei+"','"+brand+"','"+model+"',"+price+")");
                        System.out.println("Data Inserted Successfully");
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `smartphone` WHERE 1");
                        while(rs.next()) {
                            System.out.println("ID = "+ rs.getInt("id"));
                            System.out.println("IMEI no. = "+ rs.getString("imei"));
                            System.out.println("Brand Name = "+ rs.getString("brand"));
                            System.out.println("Model = "+ rs.getString("model"));
                            System.out.println("Price of Smartphone = "+ rs.getInt("price"));
                            System.out.println("------------------------------");
                        }

                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 3:
                    try {
                        System.out.println("Enter brand name to search");
                        String Brandname = sc.next();

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `smartphone` WHERE `brand` =  '"+Brandname+"'");
                        while(rs.next()) {
                            System.out.println("ID = "+ rs.getInt("id"));
                            System.out.println("IMEI no. = "+ rs.getString("imei"));
                            System.out.println("Brand Name = "+ rs.getString("brand"));
                            System.out.println("Model = "+ rs.getString("model"));
                            System.out.println("Price of Smartphone = "+ rs.getInt("price"));
                            System.out.println("------------------------------");
                        }

                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 4:
                    System.out.println("Enter imei to edit : ");
                    String Imei = sc.next();
                    System.out.println("Enter New Brand name :");
                    String Newbrand = sc.next();
                    System.out.println("Enter New Model :");
                    String NewModelname = sc.next();
                    System.out.println("Enter New Price :");
                    String Newprice = sc.next();
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("UPDATE `smartphone` SET `brand`='"+Newbrand+"',`model`='"+NewModelname+"',`price`='"+Newprice+"' WHERE `imei` = '"+Imei+"'");
                        System.out.println("Updated Successfully");
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 5:
                    try {
                        System.out.println("Enter imei no to delete");
                        String imeiNo = sc.next();

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.execute("DELETE FROM `smartphone` WHERE `imei` = '"+imeiNo+"'");
                        System.out.println("Deleted successfully");

                    } catch(Exception object) {
                        System.out.println(object);
                    }
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
