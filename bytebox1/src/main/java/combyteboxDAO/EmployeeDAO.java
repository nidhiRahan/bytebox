

package combyteboxDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import combyteboxmodel.Employee;

public class EmployeeDAO {
 public static Connection getConnection(){
	Connection con = null;
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver ragister");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bytebox?enabledTLSProtocolsTLSv1.2", "root", "nidhi@123");
		
		System.out.println("DB connection");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 return con;
 }
 public static int saveData(Employee employee) {
	 int status=0;
	 System.out.println("savedata method");
	 Connection connection=EmployeeDAO.getConnection();
	System.out.println("con:"+connection);
	try {
		
		PreparedStatement ps=connection.prepareStatement("insert into employee(firstname,lastname,username,password,address,contact) values(?,?,?,?,?,?)");
	ps.setString(1,employee.getFirstname());
	ps.setString(2,employee.getLastname());
	ps.setString(3,employee.getUsername());
	ps.setString(4,employee.getPassword());
	ps.setString(5,employee.getAddress());
	ps.setString(6,employee.getContact());
	
	status=ps.executeUpdate();
	System.out.println("status"+status);
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return status;
 }
}
