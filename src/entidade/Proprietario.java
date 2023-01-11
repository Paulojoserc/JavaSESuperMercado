package entidade;

public class Proprietario {
private String login=null;
private String senha=null;

public Proprietario() {
	
}

public Proprietario(String login, String senha) {
	this.login = login;
	this.senha = senha;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

}
