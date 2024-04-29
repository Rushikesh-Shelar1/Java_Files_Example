package file;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class student{
	int roll;
	String name;
	String course;
	public student(int roll, String name, String course) {
		super();
		this.roll = roll;
		this.name = name;
		this.course = course;
	}
	public int getRoll() {
		return roll;
	}
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	
	
	
}
public class list_to_file  {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
	
		
		List<student> list=new ArrayList<student>();
		
		OutputStream output= new FileOutputStream("D://CSJ36.txt",true);
		for(int i=0; i<3; i++)
		{
			System.out.println("enter the roll no");
			int roll=sc.nextInt();
			System.out.println("enter the name");
			String name=sc.next();
			System.out.println("enter the course");
			String course=sc.next();
			student s1=new student(roll,name,course);
			list.add(s1);
			
		}
		System.out.println("File created at D://drive");
		for(student Su:list) {
			try {
			int roll_=Su.getRoll();
			String rollString=String.valueOf(roll_);
			byte[]arrayOfRoll=rollString.getBytes();//converting string to byte array
			output.write(arrayOfRoll);//writing empId to file output stream object
			output.write(",".getBytes());//writing "," to output stream object
			
			String name_=Su.getName();
			byte[]arrayOfName=name_.getBytes();
			output.write(arrayOfName);
			output.write(",".getBytes());
			
			String course1=Su.getCourse();
			byte[]arrayOfcourse=course1.getBytes();
			output.write(arrayOfcourse);
			output.write(",".getBytes());
			output.write("\n".getBytes());
			System.out.println("enter success");
			}catch(IOException e) {
				System.out.println(e);
			}
		}
	}

}
