package servicos;

import erro.Personalizado;

public interface BandeiraCartao {
	String verificarBandeira() throws Personalizado;

	default String senha(int senha) throws Personalizado {
		if (senha == 123) {
			return "Senha v�lida";
		} else {
			throw new Personalizado("Senha Inv�lida");
		}
	}
}
