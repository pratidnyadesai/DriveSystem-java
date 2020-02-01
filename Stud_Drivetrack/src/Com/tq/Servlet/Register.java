package Com.tq.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Com.tq.Daoutil.Daoutil;
import Com.tq.Javabean.Regpojo;

/**
 * Servlet implementation class Register
 */

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("in do post");
		BufferedReader br = request.getReader();
		String s = br.readLine();
		System.out.println("angular data=" + s);

		ObjectMapper mp = new ObjectMapper();
		Regpojo rp = mp.readValue(s, Regpojo.class);

		System.out.println("java object=" + rp);

		try {
			Connection con = Daoutil.getDBConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into tpo(tponame,email,tpousername,password) values(?,?,?,?)");

			ps.setObject(1, rp.getTponame());
			ps.setObject(2, rp.getEmail());
			ps.setObject(3, rp.getTpousername());
			ps.setObject(4, rp.getPassword());

			int status = ps.executeUpdate();

			Map<String, String> m = new HashMap<>();

			if (status == 1) {
				m.put("msg", "succesfully register");
			} else {
				m.put("msg", "error");
			}
			System.out.println("map object=" + m);

			String jsonstr = mp.writeValueAsString(m);

			System.out.println("json string=" + jsonstr);

			PrintWriter pw = response.getWriter();

			pw.write(jsonstr);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
