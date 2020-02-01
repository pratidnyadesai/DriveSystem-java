package Com.tq.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.tq.Daoutil.Dao_Operations;
import Com.tq.Daoutil.Daoutil;

@WebServlet("/DeleteServlet")
public class Deleteserv extends HttpServlet {
	static int did;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str = request.getReader().readLine();
		did = Integer.parseInt(str);

		Dao_Operations.deleteInDB();

	}
}