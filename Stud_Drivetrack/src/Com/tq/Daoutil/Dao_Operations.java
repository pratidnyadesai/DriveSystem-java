package Com.tq.Daoutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import Com.tq.Javabean.Drive;
import Com.tq.Javabean.Logpojo;

public class Dao_Operations {

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}

	}

	public static Map<String, String> insertUser(Drive cd) throws JSONException {

		int affectedRows = 0;
		HashMap<String, String> mapResponse = new HashMap<>();
		try (Connection con = Daoutil.getDBConnection();
				PreparedStatement pst = con.prepareStatement(
						"insert into drive(cmpname,noofres,expreq,ctc,joincrt,bond,position,followup,educrt,gstnum) values(?,?,?,?,?,?,?,?,?,?)");) {

			String cmpname = cd.getCmpname();
			int noofres = cd.getNoofres();
			int expreq = cd.getExpreq();
			int ctc = cd.getCtc();
			int joincrt = cd.getJoincrt();
			String bond = cd.getBond();
			int position = cd.getPosition();
			Date followup = cd.getFollowup();
			int educrt = cd.getEducrt();
			String gstnum = cd.getGstnum();

			Object[] parameter = { cmpname, noofres, expreq, ctc, joincrt, bond, position, followup, educrt, gstnum };
			setValues(pst, parameter);

			affectedRows = pst.executeUpdate();
			if (affectedRows == 1)
				mapResponse.put("Msg", "SuccessFul SignUp");
			else
				mapResponse.put("Msg", "Error_In_SignUp");
			return mapResponse;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return mapResponse;

	}

	public static Map<String, String> chklogin(Logpojo log) {

		Map<String, String> mapobject = new HashMap<String, String>();

		try (Connection con = Daoutil.getDBConnection();
				PreparedStatement ps = con.prepareStatement("select *from tpo");
				ResultSet status = ps.executeQuery();) {
			while (status.next()) {
				if (status.getString(3).equals(log.getEmail()) && status.getString(5).equals(log.getPassword())) {
					mapobject.put("status", "user");
					break;
				}

				else {
					mapobject.put("status", "Error");
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return mapobject;
	}

	static int did;

	public static void deleteInDB() {

		try (Connection con = Daoutil.getDBConnection();
				PreparedStatement ps = con.prepareStatement("delete from drive where did=?");) {
			ps.setObject(1, did);

			int status = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		}
	}
}
