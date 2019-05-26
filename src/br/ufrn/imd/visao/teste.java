package br.ufrn.imd.visao;

import br.ufrn.imd.dominio.Noticia;

public class teste {

	public static void main(String[] args) {
		Noticia a = new Noticia("O RATO DE JOAQUINA COMEU O QUEIJO DO REI DE ROMA, QUE RATO BRAVO! O rêi era géntil:");
		a.ProcessarMensagem(2);
		System.out.println(a.getTextoProcessado());
	}

}
