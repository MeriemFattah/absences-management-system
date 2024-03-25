package Password_modification;

public class modifier {
protected int username;
protected String password;
public int getUsername() {
	return username;
}
public void setUsername(int username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public modifier(int username, String password) {
	this.username = username;
	this.password = password;
}

}
