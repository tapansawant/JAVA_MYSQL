//Q1. Create a menu-driven JAVA project “ Product Management System” to manage all the products  in a company using MySQL database.
//
//        Db name : ABCDCompany
//
//        1. Add the PRODUCTS ( ProductCode, product name,brand , price , model, year of manufacturing , expiry date  ) to the database after reading it from the user
//        2. View All products
//        3. Search a product using product  code ( read product code from the user )
//        4. Update product details using product Code( read product code from the user )
//        5. Delete a product  using product Code ( read product code from the user )
//        6. Display all the details of products  whose price  is greater than 50000
//        7. Display the count of total number of products  in the company
//        8. Display all the product details in alphabetical order

//Name: Tapan Sawant


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int options;
        while(true) {
            System.out.println("Press 1 to Add the Products");
            System.out.println("Press 2 to View all Products");
            System.out.println("Press 3 to Search Product based on Product Code");
            System.out.println("Press 4 to Update product details using product Code");
            System.out.println("Press 5 to Delete a product using product Code");
            System.out.println("Press 6 to Display all the details of products  whose price  is greater than 50000");
            System.out.println("Press 7 to Display the count of total number of products  in the company");
            System.out.println("Press 8 to Display all the product details in alphabetical order");
            System.out.println("Press 9 to Exit");
            System.out.println("*************************************************************");
            System.out.println("Make ur choice");

            options = sc.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Enter Product Code : ");
                    String pcode = sc.next();
                    System.out.println("Enter Product name: ");
                    String pname = sc.next();
                    System.out.println("Enter brand name : ");
                    String brand = sc.next();
                    System.out.println("Enter price: ");
                    String price = sc.next();
                    System.out.println("Enter Model: ");
                    String model = sc.next();
                    System.out.println("Enter Year of Manufacuring: ");
                    String year_man = sc.next();
                    System.out.println("Enter Expiry Date: ");
                    String expiry_date = sc.next();
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `product_details`(`ProductCode`, `productname`, `brand`, `price`, `model`, `year_of_manufacture`, `expiry_date`) VALUES ("+pcode+",'"+pname+"','"+brand+"',"+price+",'"+model+"','"+year_man+"','"+expiry_date+"')");
                        System.out.println("Product Data Inserted Successfully");
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `product_details` WHERE 1");
                        while(rs.next()) {
                            System.out.println("ID : "+ rs.getInt("id"));
                            System.out.println("Product Code : "+ rs.getInt("ProductCode"));
                            System.out.println("Product Name : "+ rs.getString("productname"));
                            System.out.println("Brand : "+ rs.getString("brand"));
                            System.out.println("Price of Product : "+ rs.getInt("price"));
                            System.out.println("Model : "+ rs.getString("model"));
                            System.out.println("Year of manufacture : "+ rs.getString("year_of_manufacture"));
                            System.out.println("Expiry date : "+ rs.getString("expiry_date"));
                            System.out.println("------------------------------");
                        }

                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 3:
                    try {
                        System.out.println("Enter Product Code to search Product");
                        String pCode = sc.next();

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `product_details` WHERE `ProductCode` =  "+pCode+"");
                        while(rs.next()) {
                            System.out.println("ID : "+ rs.getInt("id"));
                            System.out.println("Product Code : "+ rs.getInt("ProductCode"));
                            System.out.println("Product Name : "+ rs.getString("productname"));
                            System.out.println("Brand : "+ rs.getString("brand"));
                            System.out.println("Price of Product : "+ rs.getInt("price"));
                            System.out.println("Model : "+ rs.getString("model"));
                            System.out.println("Year of manufacture : "+ rs.getString("year_of_manufacture"));
                            System.out.println("Expiry date : "+ rs.getString("expiry_date"));
                            System.out.println("------------------------------");
                        }
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 4:
                    System.out.println("Enter Product Code to update : ");
                    String prcode = sc.next();
                    System.out.println("Enter New Product name: ");
                    String prname = sc.next();
                    System.out.println("Enter New brand name : ");
                    String pbrand = sc.next();
                    System.out.println("Enter New price: ");
                    String prprice = sc.next();
                    System.out.println("Enter New Model: ");
                    String pmodel = sc.next();
                    System.out.println("Enter New Year of Manufacuring: ");
                    String p_year_man = sc.next();
                    System.out.println("Enter New Expiry Date: ");
                    String p_expiry_date = sc.next();
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("UPDATE `product_details` SET `productname`='"+prname+"',`brand`='"+pbrand+"',`price`="+prprice+",`model`='"+pmodel+"',`year_of_manufacture`='"+p_year_man+"',`expiry_date`='"+p_expiry_date+"' WHERE `ProductCode` = "+prcode+"");
                        System.out.println("Updated Successfully");
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 5:
                    try {
                        System.out.println("Enter Product Code to delete");
                        String Pcode = sc.next();

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.execute("DELETE FROM `product_details` WHERE `ProductCode` = "+Pcode+"");
                        System.out.println("Deleted successfully");

                    } catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 6:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `product_details` WHERE `price` >= 50000");
                        while(rs.next()) {
                            System.out.println("ID : "+ rs.getInt("id"));
                            System.out.println("Product Code : "+ rs.getInt("ProductCode"));
                            System.out.println("Product Name : "+ rs.getString("productname"));
                            System.out.println("Brand : "+ rs.getString("brand"));
                            System.out.println("Price of Product : "+ rs.getInt("price"));
                            System.out.println("Model : "+ rs.getString("model"));
                            System.out.println("Year of manufacture : "+ rs.getString("year_of_manufacture"));
                            System.out.println("Expiry date : "+ rs.getString("expiry_date"));
                            System.out.println("------------------------------");
                        }
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;



                case 7:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT COUNT(productname) as Product_name FROM `product_details`");
                        if (rs.next()) {
                            int count= rs.getInt("Product_name");
                            System.out.println("The no of products in company are "+ count);
                            System.out.println("-------------------------------------------------");
                        }
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;



                case 8:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyabcd?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `product_details` ORDER BY productname ASC");
                        while(rs.next()) {
                            System.out.println("ID : "+ rs.getInt("id"));
                            System.out.println("Product Code : "+ rs.getInt("ProductCode"));
                            System.out.println("Product Name : "+ rs.getString("productname"));
                            System.out.println("Brand : "+ rs.getString("brand"));
                            System.out.println("Price of Product : "+ rs.getInt("price"));
                            System.out.println("Model : "+ rs.getString("model"));
                            System.out.println("Year of manufacture : "+ rs.getString("year_of_manufacture"));
                            System.out.println("Expiry date : "+ rs.getString("expiry_date"));
                            System.out.println("------------------------------");
                        }
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
