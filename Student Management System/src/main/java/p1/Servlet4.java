package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		try {

			PrintWriter out=response.getWriter();

			int id=Integer.parseInt(request.getParameter("c1"));

		

			Class.forName("com.mysql.cj.jdbc.Driver");

			out.println("Driver Loaded");

			

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");

			out.println("Connection Established");

			

			Statement st=con.createStatement();

			out.println("statement created");

			

			String query4="select * from student.student ";

			ResultSet rs=st.executeQuery(query4);


			while(rs.next()) {
			if(rs.getInt(1)==id) {
			out.println("Student Id "+rs.getInt(1));
			out.println("Student Name "+rs.getString(2));
			out.println("M1 "+rs.getInt(3));
			out.println("M2 "+rs.getInt(4));
			out.println("M3 "+rs.getInt(5));
			out.println("M4 "+rs.getInt(6));
			out.println("M5 "+rs.getInt(7));
			out.println("M6 "+rs.getInt(8));
			}
			}
		}

		

		catch(Exception e) {

			PrintWriter out=response.getWriter();

			out.println("Connection not established");

			

		}

		
	}

}
