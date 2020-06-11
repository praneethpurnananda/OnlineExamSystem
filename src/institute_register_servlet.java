

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class institute_register_servlet
 */
@WebServlet("/institute_register_servlet")
public class institute_register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public institute_register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			PreparedStatement ps=con.prepareStatement("insert into new_institute_table values(?,?,?,?)");
			String inst_name=request.getParameter("r1");
			String inst_id=request.getParameter("r2");
			String inst_place=request.getParameter("r3");
			String inst_pwd=request.getParameter("r4");
			ps.setString(1, inst_id);
			ps.setString(2, inst_name);
			ps.setString(3, inst_place);
			ps.setString(4, inst_pwd);
			ps.executeUpdate();
			response.setContentType("text/html");
			
			response.sendRedirect("institute_login.html");
			
			
	}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
