package Com.tq.Servlet;

import java.io.IOException;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.tq.Daoutil.Dao_Operations;

import Com.tq.Javabean.Logpojo;
import Com.tq.Json.Convert_jstja_jatjs;

@WebServlet("/log")
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Logpojo log = (Logpojo) Convert_jstja_jatjs.getObjectFromJSON(jsonobject, Logpojo.class);

		Map<String, String> mp = null;
		mp = Dao_Operations.chklogin(log);
		String jsonString = (String) Convert_jstja_jatjs.getJSONFromObject(mp);
		response.getWriter().write(jsonString);
		response.flushBuffer();
	}
}
