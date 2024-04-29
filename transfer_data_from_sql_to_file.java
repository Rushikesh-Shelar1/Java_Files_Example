package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class transfer_data_from_sql_to_file {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
		OutputStream output= new FileOutputStream("D://CSJ36.txt",true);
		System.out.println("File created at D://drive");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			Statement smt=con.createStatement();
			ResultSet rs= smt.executeQuery("select * from emp2");
			
			
			while(rs.next()) {
				
				int emp_id= rs.getInt(1);
				String id=String.valueOf(emp_id);	
				byte[]arrayOfId=id.getBytes();
				output.write(arrayOfId);
				output.write(",".getBytes());
				
				
				String emp_name=rs.getNString(2);
				byte[]arrayOfName=emp_name.getBytes();
				output.write(arrayOfName);
				output.write(",".getBytes());
				
				
				double emp_salary=rs.getDouble(3);
				String sal=String.valueOf(emp_salary);
				byte[]arrayOfSalary=sal.getBytes();
				output.write(arrayOfSalary);
				output.write("\n".getBytes());
				System.out.println("emp info saved to file");
				
			}
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
