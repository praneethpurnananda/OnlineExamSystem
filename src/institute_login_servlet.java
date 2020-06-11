

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class institute_login_servlet
 */
@WebServlet("/institute_login_servlet")
public class institute_login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public institute_login_servlet() {
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
			PreparedStatement ps=con.prepareStatement("select * from new_institute_table where instituteid=? and password=?");
			String un=request.getParameter("t1");
			String pw=request.getParameter("t2");
			ps.setString(1,un);
			ps.setString(2, pw);
			ResultSet rs=ps.executeQuery();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			if(rs.next())
			{
				response.sendRedirect("institutedashboard.html");
			}
			else
			{
				out.println("<h1>Invalid Credentialss</h1>");
				out.println("<a href='institute_login.html'>click here</a> to try again");
			}
		}
		catch(Exception e) {
			System.out.println(e);
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
