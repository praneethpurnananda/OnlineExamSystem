import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class student_exam_start
 */
@WebServlet("/student_exam_start")
public class student_exam_start extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_exam_start() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub


try{

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
String vsql = "select sno,question,option1,option2,option3,option4 from new_question_table";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(vsql);
ResultSetMetaData rsmd = rs.getMetaData();
response.setContentType("text/html");
PrintWriter out=response.getWriter();
String s1,s2,s3,s4;
int i=1;
while(rs.next())
{

out.println("<form name='exam' action='resultpage' method='post'><b>" + rs.getString(1)+ " . "  + rs.getString(2)+   "</b><br><br>");
s1 = rs.getString(3);
s2 = rs.getString(4);
s3 = rs.getString(5);
s4 = rs.getString(6);
out.println("<input type=radio name=opt"+i+" value="+1+">"+s1+  " <br><br>");
out.println("<input type=radio name=opt"+i+ " value="+2+ ">"+s2+  "<br><br>");
out.println("<input type=radio name=opt"+i+ " value="+3+ ">"+s3+  "<br><br>");
out.println("<input type=radio name=opt"+i+ " value="+4+ ">"+s4+  "<br><br>");
i++ ;
}
out.println("<input name ='submit' value='Submit' type='submit'/>");
}
catch(Exception e)
{
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