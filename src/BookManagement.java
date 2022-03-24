import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int options;
        while(true) {
            System.out.println("1. add book datails");
            System.out.println("2. view all books");
            System.out.println("4. Exit");
            System.out.println("Select an option");

            options = sc.nextInt();
            switch(options)
            {
                case 1:
                    System.out.println("Enter Bookname");
                    String book_name = sc.next();
                    System.out.println("Enter Author name");
                    String author = sc.next();
                    System.out.println("Enter Publisher name");
                    String publisher = sc.next();
                    System.out.println("Enter Distributor");
                    String distributor = sc.next();
                    System.out.println("Enter Price");
                    String price = sc.next();

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `bookdetails`(`bookname`, `Author`, `publisher`, `distributor`, `price`) VALUES('"+book_name+"','"+author+"','"+publisher+"','"+distributor+"','"+price+"')");
                        System.out.println("Inserted successfully");
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;

                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `bookdetails` WHERE 1");
                        while(rs.next()) {
                            System.out.println("ID = "+ rs.getInt("id"));
                            System.out.println("Book Name = "+ rs.getString("bookname"));
                            System.out.println("Author = "+ rs.getString("Author"));
                            System.out.println("Publisher = "+ rs.getString("publisher"));
                            System.out.println("Distributor = "+ rs.getString("distributor"));
                            System.out.println("Price = "+rs.getString("price"));
                            System.out.println("------------------------------");
                        }

                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;




                case 3:
                    System.exit(0);

                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
