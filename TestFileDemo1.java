package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class TestFileDemo1 {

	public static void main(String[] args) {
		try {
		OutputStream output= new FileOutputStream("D://CSJ36.txt",true);
		System.out.println("File created at D://drive");
		Scanner sc=new Scanner(System.in);/*
		System.out.println("enter your message");
		String msg=sc.nextLine();
		//void write(byte[] b)
		//void write(byte b)
		//byte[] getBytes
		// byte[] bytes="ABC".getBytes();
		//System.out.println(Arrays.toString(bytes));
		byte[] bytes=msg.getBytes();
		//void write(byte[] b)throws IOException
		output.write(bytes);
		System.out.println("Successfully written file");
		*/
		System.out.println("enter your message");
		String msg=sc.nextLine();
		byte[] bytes=msg.getBytes();
		output.write(bytes);
		output.write("\n".getBytes());
		
		
		System.out.println("enter emp id");
		int empid=sc.nextInt();
	
		String id=String.valueOf(empid);	//converting int to string
		
		byte[]arrayOfId=id.getBytes();//converting string to byte array
		
		output.write(arrayOfId);//writing empId to file output stream object
		
		output.write(",".getBytes());//writing "," to output stream object
		
		System.out.println("enter emp name");
		String empName=sc.next();
		byte[]arrayOfName=empName.getBytes();
		output.write(arrayOfName);
		output.write(",".getBytes());
		System.out.println("enter emp salary");
		double salary=sc.nextDouble();
		String sal=String.valueOf(salary);
		byte[]arrayOfSalary=sal.getBytes();
		output.write(arrayOfSalary);
		output.write("\n".getBytes());
		System.out.println("emp info saved to file");
		
		}catch(IOException e) {
			
		}
	}

}
