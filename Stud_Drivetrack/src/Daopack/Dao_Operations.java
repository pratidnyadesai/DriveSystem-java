package Daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import Pojopack.Drive;

public class Dao_Operations {

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) 
		{
			statement.setObject(i + 1, values[i]);
		}

	}

	public static Map<String, String> insertUser(Drive cd) throws JSONException {

		int affectedRows = 0;
		HashMap<String, String> mapResponse = new HashMap<>();
		try {
			Connection con = Daoutil.getDBConnection();
			PreparedStatement pst = con.prepareStatement(
					"insert into drive(cmpname,noofres,expreq,ctc,joincrt,bond,position,followup,educrt) values(?,?,?,?,?,?,?,?,?)");

			String cmpname=cd.getCmpname();
			 int noofres=cd.getNoofres();
			int expreq=cd.getExpreq();
			 int ctc=cd.getCtc();
			 int joincrt=cd.getJoincrt();
			 String bond=cd.getBond();
			 int position=cd.getPosition();
			 Date followup=cd.getFollowup();
			 int educrt=cd.getEducrt();
			
			Object[] parameter = { cmpname, noofres, expreq, ctc, joincrt, bond, position, followup,
					educrt };
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

}
