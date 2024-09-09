package p1;



import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.util.*;

import java.sql.*;



/**

 * Servlet implementation class Servlet3

 */

@WebServlet("/Servlet3")

public class Servlet3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public Servlet3() {

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

			int id=Integer.parseInt(request.getParameter("b1"));

		

			Class.forName("com.mysql.cj.jdbc.Driver");

			out.println("Driver Loaded");

			

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");

			out.println("Connection Established");

			

			Statement st=con.createStatement();

			out.println("statement created");

			

			int i=st.executeUpdate("delete from student where id="+id+"");

			if (i>0)

				out.println("record deleted");

			else

				out.println("record not deleted");

			

			con.close();

		}

		

		catch(Exception e) {

			PrintWriter out=response.getWriter();

			out.println("Connection not established");

			

		}

		

		

	}



}
