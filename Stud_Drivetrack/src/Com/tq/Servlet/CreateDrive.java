package Com.tq.Servlet;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import Com.tq.Daoutil.Dao_Operations;
import Com.tq.Javabean.Drive;
import Com.tq.Json.Convert_jstja_jatjs;

@WebServlet("/CreateDrive")
public class CreateDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = request.getReader();
		String s = br.readLine();

		Drive cd = (Drive) Convert_jstja_jatjs.getObjectFromJSON(s, Drive.class);
		try {
			Map<String, String> mapResponse = Dao_Operations.insertUser(cd);
			String jsonString = Convert_jstja_jatjs.getJSONFromObject(mapResponse);
			response.getWriter().write(jsonString);

			response.flushBuffer();

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
