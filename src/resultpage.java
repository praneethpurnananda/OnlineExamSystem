

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
 * Servlet implementation class resultpage
 */
@WebServlet("/resultpage")
public class resultpage extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultpage() {
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
Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st= con.createStatement();
ResultSet rs=st.executeQuery("select * from new_question_table");
ResultSetMetaData rsmd = rs.getMetaData();
String s2,s3;
String s1="";
int i=1;
PrintWriter pw=response.getWriter();
int count=0;
while(rs.next())
{
String x=Integer.toString(i);
s2=request.getParameter("opt"+x);
if(s2.equals("1")) {s1=rs.getString(3);}
else if(s2.equals("2")) {s1=rs.getString(4);}
else if(s2.equals("3")) {s1=rs.getString(5);}
else if(s2.equals("4")) {s1=rs.getString(6);}
s3=rs.getString(7);
if(s3.equalsIgnoreCase(s1))
{
count=count+1;
}

i++;

}


pw.println("<h1>your marks :"+count+"</h1><a href='Home.html'>Logout</a>");


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