package Servletpack;

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

import org.codehaus.jackson.map.ObjectMapper;

import Daopack.Daoutil;
import Pojopack.Drive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi i am post");
		BufferedReader br = request.getReader();
		String s = br.readLine();

		ObjectMapper obj = new ObjectMapper();
		Drive r = obj.readValue(s, Drive.class);
		/*
		 * System.out.println("javaobject" + r);
		 */
		try {
			Connection con = Daopack.Daoutil.getDBConnection();

			PreparedStatement ps = con.prepareStatement(
					"update drive set cmpname=?,noofres=?,expreq=?,ctc=?,joincrt=?,bond=?,position=?,followup=?,educrt=? where did=?");

			ps.setObject(1, r.getCmpname());
			ps.setObject(2, r.getNoofres());
			ps.setObject(3, r.getExpreq());
			ps.setObject(4, r.getCtc());
			ps.setObject(5, r.getJoincrt());
			ps.setObject(6, r.getBond());
			ps.setObject(7, r.getPosition());
			ps.setObject(8, r.getFollowup());
			ps.setObject(9, r.getEducrt());
			ps.setObject(10, r.getDid());

			int status = ps.executeUpdate();

			Map<String, String> m = new HashMap<>();

			if (status == 1) {
				m.put("Data", "succesfully updated");
			} else {
				m.put("Data", "error");
			}
			System.out.println("map object=" + m);

			String jsonstr = obj.writeValueAsString(m);

			System.out.println("json string=" + jsonstr);

			PrintWriter pw = response.getWriter();

			pw.write(jsonstr);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}