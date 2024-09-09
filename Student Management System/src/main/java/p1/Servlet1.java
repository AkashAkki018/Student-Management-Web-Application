package p1;



import java.io.IOException;

import javax.servlet.*;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.*;

import java.sql.*;

/**

 * Servlet implementation class Servlet1

 */

@WebServlet("/Servlet1")

public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public Servlet1() {

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

		int id=Integer.parseInt(request.getParameter("t1"));

		String name=request.getParameter("t2");

		int s1=Integer.parseInt(request.getParameter("t3"));

		int s2=Integer.parseInt(request.getParameter("t4"));

		int s3=Integer.parseInt(request.getParameter("t5"));

		int s4=Integer.parseInt(request.getParameter("t6"));

		int s5=Integer.parseInt(request.getParameter("t7"));

		int s6=Integer.parseInt(request.getParameter("t8"));

		

		Class.forName("com.mysql.cj.jdbc.Driver");

		out.println("Driver Loaded");

		

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");

		out.println("Connection Established");

		

		Statement st=con.createStatement();

		out.println("statement created");

		

		int i=st.executeUpdate("insert into student values("+id+",'"+name+"',"+s1+","+s2+","+s3+","+s4+","+s5+","+s6+")");

		if (i>0)

			out.println("record inserted");

		else

			out.println("record not inserted");

		

		con.close();

		

	}

	

	catch(Exception e) {

		PrintWriter out=response.getWriter();

		out.println("Connection not established");

		

	}

	}



}