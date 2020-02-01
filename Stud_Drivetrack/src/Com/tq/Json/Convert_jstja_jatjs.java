package Com.tq.Json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Convert_jstja_jatjs {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static Object getObjectFromJSON(String jsonString, Class<?> className) {
		Object rd = null;

		try {
			rd = mapper.readValue(jsonString, className);
		} catch (Exception e) {
			System.out.println(e);
		}
		return rd;
	}

	public static String getJSONFromObject(Object object) {
		String jsonData = null;

		try {
			jsonData = mapper.writeValueAsString(object);

		} catch (Exception e) {

		}
		return jsonData;
	}

}
