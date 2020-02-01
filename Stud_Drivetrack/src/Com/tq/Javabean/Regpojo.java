package Com.tq.Javabean;

public class Regpojo {
	private String tponame;
	private String email;
	private String tpousername;
	private String password;
	public String getTponame() {
		return tponame;
	}
	public void setTponame(String tponame) {
		this.tponame = tponame;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTpousername() {
		return tpousername;
	}
	public void setTpousername(String tpousername) {
		this.tpousername = tpousername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Regpojo [tponame=" + tponame + ", email=" + email + ", tpousername=" + tpousername + ", password="
				+ password + "]";
	}

	}
