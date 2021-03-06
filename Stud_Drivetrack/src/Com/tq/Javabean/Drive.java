package Com.tq.Javabean;

import java.sql.Date;

public class Drive {

	private int did;
	private String cmpname;
	private int noofres;
	private int expreq;
	private int ctc;
	private int joincrt;
	private String bond;
	private int position;
	private Date followup;
	private int educrt;
	private String gstnum;

	
	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getCmpname() {
		return cmpname;
	}

	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}

	public int getNoofres() {
		return noofres;
	}

	public void setNoofres(int noofres) {
		this.noofres = noofres;
	}

	public int getExpreq() {
		return expreq;
	}

	public void setExpreq(int expreq) {
		this.expreq = expreq;
	}

	public int getCtc() {
		return ctc;
	}

	public void setCtc(int ctc) {
		this.ctc = ctc;
	}

	public int getJoincrt() {
		return joincrt;
	}

	public void setJoincrt(int joincrt) {
		this.joincrt = joincrt;
	}

	public String getBond() {
		return bond;
	}

	public void setBond(String bond) {
		this.bond = bond;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Date getFollowup() {
		return followup;
	}

	public void setFollowup(Date followup) {
		this.followup = followup;
	}

	public int getEducrt() {
		return educrt;
	}

	public void setEducrt(int educrt) {
		this.educrt = educrt;
	}
	public String getGstnum() {
		return gstnum;
	}

	public void setGstnum(String gstnum) {
		this.gstnum = gstnum;
	}

	@Override
	public String toString() {
		return "Drive [did=" + did + ", cmpname=" + cmpname + ", noofres=" + noofres + ", expreq=" + expreq + ", ctc="
				+ ctc + ", joincrt=" + joincrt + ", bond=" + bond + ", position=" + position + ", followup=" + followup
				+ ", educrt=" + educrt + ", gstnum=" + gstnum + "]";
	}



}
