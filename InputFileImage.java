package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputFileImage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file =new File("D://CSJ36.jpg");
		
		System.out.println(file.canExecute());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());//return string
		System.out.println(file.getFreeSpace());//return long
		file.mkdir();
		
		
		FileOutputStream fout=new FileOutputStream(file);
		System.out.println("image file created");
		//we want to read a image file content and copy into newly created file
		InputStream input =new FileInputStream("D://ashok stambh.jpg");
		//InputStream class provides a method called int read()
		//int read() throws IOException 
		int b=0;
		while((b=input.read())!=-1) {
			fout.write(b);
		}
		System.out.println("check your file");
	}

}
