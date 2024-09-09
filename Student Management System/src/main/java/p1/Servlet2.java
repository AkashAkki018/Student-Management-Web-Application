package p1;



import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



/**

 * Servlet implementation class Servlet2

 */

@WebServlet("/Servlet2")

public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public Servlet2() {

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

			int id=Integer.parseInt(request.getParameter("a1"));

			String s=request.getParameter("a2");

			int m=Integer.parseInt(request.getParameter("a3"));

			

			

			Class.forName("com.mysql.cj.jdbc.Driver");

			out.println("Driver Loaded");

			

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");

			out.println("Connection Established");

			

			Statement st=con.createStatement();

			out.println("statement created");

			

			int i=st.executeUpdate("UPDATE student SET "+s+" = "+m+" where id="+id+";");

			if (i>0)

				out.println("record updated");

			else

				out.println("record not updated");

			

			con.close();

		}

		

		catch(Exception e) {

			PrintWriter out=response.getWriter();

			out.println("Connection not established");

			

		}

		

		

	}



}





