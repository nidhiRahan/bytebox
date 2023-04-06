package combyteboxweb;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import combyteboxDAO.EmployeeDAO;
import combyteboxmodel.Employee;

/**
 * Servlet implementation class Employeeservlet
 */
@WebServlet("/empservlet")
public class Employeeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Employeeservlet() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service..!");
		String Firstname=request.getParameter("firstname");
		String Lastname=request.getParameter("lastname");
		String Username=request.getParameter("username");
		String Password=request.getParameter("password");
		String Address=request.getParameter("address");
		String contact=request.getParameter("contact");
		System.out.println("username"+Username);
		
		Employee employee=new Employee();
		employee.setFirstname(Firstname);
		employee.setLastname(Lastname);
		employee.setUsername(Username);
		employee.setPassword(Password);
		employee.setAddress(Address);
		employee.setContact(contact);
		
		
		int status=EmployeeDAO.saveData(employee);
		if(status>0) {
			System.out.println("record success");
		}
		else {
			System.out.println("not success");
		}
	}

}
