package servicos;

public abstract class VerificarService implements BandeiraCartao {
private Integer setor =null;

public VerificarService() {	
}
public VerificarService(Integer setor) {
	this.setor = setor;
}
public Integer getSetor() {
	return setor;
}
public void setSetor(Integer setor) {
	this.setor = setor;
}


}
