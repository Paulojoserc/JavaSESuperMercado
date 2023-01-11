package servicos;

import erro.Personalizado;

public class Visa extends VerificarService {
public Visa(Integer setor) {
	super(setor);
}
	@Override
	public String verificarBandeira() throws Personalizado {
		if(getSetor()!=4) {
			throw new Personalizado("**BANDEIRA NÃO CONFERE PARA VISA**");
		}else {
			return "**BANDEIRA CONFERE**" ;	
		}
		
	}

}
