package FinalProject.ZFinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseSelenium {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host ="localhost";
		String port ="3306";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","root123");
	    Statement s=con.createStatement();
	    ResultSet rs=s.executeQuery("select * from data");
	    List<Integer> in=new ArrayList<Integer>();
	   while(rs.next())
	   {
		   
		System.out.print(rs.getString("name")+"  ");
		System.out.print(rs.getInt("id")+ "  ");
       System.out.print(rs.getString("location") + "  ");
		System.out.print(rs.getInt("age"));
		System.out.println("\t");
	   }
	
	   
	}

}
