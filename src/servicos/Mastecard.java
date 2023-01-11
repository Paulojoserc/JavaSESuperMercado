package servicos;

import erro.Personalizado;

public class Mastecard extends VerificarService {

	public Mastecard(Integer setor) {
		super(setor);
	}

	@Override
	public String verificarBandeira() throws Personalizado {
		if(getSetor()!=54 || getSetor()!=55 || getSetor()!=56 || getSetor()!=57) {
			throw new Personalizado("**BANDEIRA NÃO CONFERE PARA MASTERCCARD**");
		}else {
			return"**BANDEIRA CORRETA**";
		}
	}

}
