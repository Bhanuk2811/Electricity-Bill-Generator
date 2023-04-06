package fin;

import java.sql.*;
public class conn {
	public static void main(String[] args) {

	}
	Connection c;
	Statement s;
	conn()
	{
		try {
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/BBG","root","2023");
		s = c.createStatement();
		}catch( Exception e)
		{
		e.printStackTrace();
		}


}
}