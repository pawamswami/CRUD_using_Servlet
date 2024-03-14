package p2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public update() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String mobile = request.getParameter("number");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psa_jan", "root", "test");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update registration set mobile='" + mobile + "'where email ='" + email + "'");
			 System.out.println("Data updated");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
