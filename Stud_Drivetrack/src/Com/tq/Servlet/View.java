package Com.tq.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.tq.Daoutil.Daoutil;
import Com.tq.Javabean.Drive;
import Com.tq.Json.Convert_jstja_jatjs;

@WebServlet("/ViewDriveServlet")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Drive> al = new ArrayList<>();
		try (Connection con = Daoutil.getDBConnection();
				PreparedStatement ps = con.prepareStatement("select * from drive");

				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Drive c = new Drive();

				c.setDid(rs.getInt(1));
				c.setCmpname(rs.getString(2));
				c.setNoofres(rs.getInt(3));
				c.setExpreq(rs.getInt(4));
				c.setCtc(rs.getInt(5));
				c.setJoincrt(rs.getInt(6));
				c.setBond(rs.getString(7));
				c.setPosition(rs.getInt(8));
				c.setFollowup(rs.getDate(9));
				c.setEducrt(rs.getInt(10));
				c.setGstnum(rs.getString(18));
			

				al.add(c);
			}
			String s = Convert_jstja_jatjs.getJSONFromObject(al);
			PrintWriter pw = response.getWriter();
			pw.write(s);
			pw.flush();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}