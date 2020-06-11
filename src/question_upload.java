

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class question_upload
 */
@WebServlet("/question_upload")
public class question_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public question_upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		try{
			PrintWriter out=response.getWriter();
			String sno = request.getParameter("sno");
			String ques = request.getParameter("ques");
			String opt1 = request.getParameter("opt1");
			String opt2 = request.getParameter("opt2");
			String opt3 = request.getParameter("opt3");
			String opt4 = request.getParameter("opt4");
			String ans = request.getParameter("ans");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String vsql = "insert into new_question_table values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(vsql);
			pstmt.setString(1, sno);
			pstmt.setString(2,ques);
			pstmt.setString(3,opt1);
			pstmt.setString(4,opt2);
			pstmt.setString(5,opt3);
			pstmt.setString(6,opt4);
			pstmt.setString(7,ans);
			pstmt.executeUpdate();
			response.setContentType("text/html");
			 response.sendRedirect("postdashboard.html");
			}
			//rs = stmt.executeQuery(vsql);
			catch(Exception e){
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
