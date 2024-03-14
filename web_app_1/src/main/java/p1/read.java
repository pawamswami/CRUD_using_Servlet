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

@WebServlet("/read")
public class read extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public read() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<table border='2'>");
		pw.println("<tr>");
		pw.println("<th>");
		pw.println("Name");
		pw.println("</th>");
		pw.println("<th>");
		pw.println("city");
		pw.println("</th>");
		pw.println("<th>");
		pw.println("email");
		pw.println("</th>");
		pw.println("<th>");
		pw.println("mobile");
		pw.println("</th>");
		pw.println("</tr>");
		pw.println("</table>");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psa_jan", "root", "test");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from registration ");
			while (rs.next()) {
				pw.println("<tr>");
				pw.println("<td>");
				pw.println(rs.getString(1));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(2));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(3));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(4));
				pw.println("</td>");
				pw.println("</tr>");
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");
	}

}
