import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDriven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int options;
        while(true) {
            System.out.println("1. add student");
            System.out.println("2. view all students");
            System.out.println("3. delete a student");
            System.out.println("4. Exit");
            System.out.println("Select an option");

            options = sc.nextInt();
            switch(options)
            {
                case 1:
                    //System.out.println("Add students option selectes");
                    System.out.println("Enter name");
                    String name = sc.next();
                    System.out.println("Enter Gr no");
                    String Gr_no = sc.next();
                    System.out.println("enter roll no");
                    String RollNo = sc.next();;
                    System.out.println("enter college");
                    String college = sc.next();


                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `students`(`Name`, `Roll_No`, `Gr._No`, `College`) VALUES('"+name+"',"+RollNo+","+Gr_no+",'"+college+"')");
                        System.out.println("Inserted successfully");
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;

                case 2:
                    //System.out.println("view all options selected");
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `students` WHERE 1");
                        while(rs.next()) {
                            System.out.println("ID = "+ rs.getInt("id"));
                            System.out.println("Name = "+ rs.getString("Name"));
                            System.out.println("Roll No = "+ rs.getInt("Roll_No"));
                            System.out.println("Gr No.= "+ rs.getInt("Gr._No"));
                            System.out.println("College Name = "+rs.getString("College"));
                            System.out.println("------------------------------");
                        }

                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;

                case 3:
                    //System.out.println("3rd option selected");

                    try {
                        System.out.println("Enter roll no of student to delete");
                         int rollno = sc.nextInt();

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.execute("DELETE FROM `students` WHERE `Roll_No` = " + rollno);
                        System.out.println("Deleted successfully");

                    } catch(Exception object) {
                        System.out.println(object);
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("invalid coice");
            }
        }
    }
}
