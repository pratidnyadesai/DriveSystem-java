package Servletpack;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import Daopack.Dao_Operations;
import Pojopack.Drive;
import Cnvrtpack.convert_jstja_jatjs;

@WebServlet("/CreateDrive")
public class CreateDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br =request.getReader();
		String s = br.readLine();
		System.out.println(s);

		Drive cd = (Drive) convert_jstja_jatjs.getObjectFromJSON(s,Drive.class);
		System.out.println(cd);
		try {

			Map<String, String> mapResponse = Dao_Operations.insertUser(cd);
			String jsonString = convert_jstja_jatjs.getJSONFromObject(mapResponse);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
