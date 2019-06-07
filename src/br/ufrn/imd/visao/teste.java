package br.ufrn.imd.visao;

import br.ufrn.imd.dominio.Noticia;
import br.ufrn.imd.dominio.NoticiaSimilaridade;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.text.similarity.CosineDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;

import br.ufrn.imd.dominio.LeituraFileCSV;
public class teste {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String mudanca = "";
		String caminho = "C:\\Users\\Yan\\Downloads\\boatos.csv";
		Noticia web = new Noticia();
		Noticia web2 = new Noticia();
		web2.setTextoOriginal("O rato roeu tudo, nossa?");
		web2.setTextoProcessado("O rato roeu tudo, nossa eeage qegqgq qaegqeg gegeqwgqw?");
		web2.ProcessarMensagem(3);
		web.setTextoProcessado("O rato roeu tudo, nmossa?");
		web.setTextoOriginal("O rato roeu tudo, nmossa?");
		web.ProcessarMensagem(3);
		HashMap<String, Noticia> a = LeituraFileCSV.LerCSVGerarHashMap(caminho, 4);
		double similaridadePercentual = 0.25;
		double aux;
		double aux2;
		ArrayList<NoticiaSimilaridade> retorno = new ArrayList<NoticiaSimilaridade>();
		Set<String> chaves = a.keySet();
		CosineDistance c = new CosineDistance();
		LevenshteinDistance b = new LevenshteinDistance();
		System.out.println(c.apply(web.getTextoProcessado(), web2.getTextoProcessado()));
		

	}

}
