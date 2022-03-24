//1.	 Create a java project “ Employee Management System” to manage the employees in a company using MySQL database .
//        Database name : CompanyDb
//        •	Add the Employees ( empCode, name, phone, email, designation, salary, company name, address,  )
//        •	View All employees
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int options;
        while(true) {
            System.out.println("Press 1 to Add Employess");
            System.out.println("Press 2 to View all employees");
            System.out.println("Press 3 to Exit");
            System.out.println("--");
            System.out.println("Make ur choice");

            options = sc.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Enter employee code: ");
                    String empcode = sc.next();
                    System.out.println("Enter emplyees name: ");
                    String name = sc.next();
                    System.out.println("Enter phone no: ");
                    String phone = sc.next();
                    System.out.println("Enter email: ");
                    String mail = sc.next();
                    System.out.println("Enter designation: ");
                    String designation = sc.next();
                    System.out.println("Enter salary: ");
                    String Salary = sc.next();
                    System.out.println("Enter company name: ");
                    String company = sc.next();
                    System.out.println("Enter address: ");
                    String address = sc.next();

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `employee_table`(`empCode`, `name`, `phone`, `email`, `salary`, `designation`, `company_name`, `address`) VALUES("+empcode+",'"+name+"','"+phone+"','"+mail+"',"+Salary+",'"+designation+"','"+company+"','"+address+"')");
                        System.out.println("Data Inserted Successfully");
                    }
                    catch(Exception object) {
                        System.out.println(object);
                    }
                    break;


                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `employee_table` WHERE 1");
                        while(rs.next()) {
                            System.out.println("ID = "+ rs.getInt("id"));
                            System.out.println("Employee Code = "+ rs.getInt("empCode"));
                            System.out.println("Employee Name = "+ rs.getString("name"));
                            System.out.println("Employee phone = "+ rs.getString("phone"));
                            System.out.println("Employee email = "+ rs.getString("email"));
                            System.out.println("Employee salary = "+ rs.getInt("salary"));
                            System.out.println("Employee designation = "+ rs.getString("designation"));
                            System.out.println("Employee Compmany = "+ rs.getString("company_name"));
                            System.out.println("Employee Address = "+ rs.getString("address"));
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
                    System.out.println("Invalid choice");
            }
        }

    }
}
