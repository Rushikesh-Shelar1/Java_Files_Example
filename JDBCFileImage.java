package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCFileImage {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
			InputStream input =new FileInputStream("D://ashok stambh.jpg");
			PreparedStatement pst=con.prepareStatement("insert into UserProfile values(?,?)");
			pst.setInt(1,109);
			pst.setBinaryStream(2, input);
			int status=pst.executeUpdate();
			if(status>0) {
				System.out.println("inserted");
				FileOutputStream fout=new FileOutputStream("D://sample.jpg");
				PreparedStatement pst1=con.prepareStatement("select user_photo from UserProfile where user_id=?");
				pst1.setInt(1,109);
				ResultSet rs=pst1.executeQuery();
				rs.next();
				byte[] imageBytes=rs.getBytes(1);
				fout.write(imageBytes);
				System.out.println("fetched from DB ....check your file");
				
				
				}
			else
			{
				System.out.println("unnable to load image file");
			}
			
			
			}catch(Exception e) {
			System.out.println(e);
		}

	}

}
