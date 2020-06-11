

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student_register_servlet")
public class student_register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public student_register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
		String studentName = request.getParameter("r1");
		String studentId = request.getParameter("r2");
		String mobileNumber = request.getParameter("r3");
		String institutionId = request.getParameter("r4");
		String password = request.getParameter("r5");
		ps.setString(1, studentId);
		ps.setString(2, studentName);
		ps.setString(3, mobileNumber);
		ps.setString(4, institutionId);
		ps.setString(5, password);
		ps.executeUpdate();
		response.setContentType("text/html");
		
		response.sendRedirect("studentlogin.html");
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
