package br.ufrn.imd.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.text.similarity.CosineDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class CalculoSimilaridade {

	public static ArrayList<NoticiaSimilaridade> SimilaridadeBancoDados(Noticia web, HashMap<String,Noticia> bancoFake, int similaridade) 
	{
		double similaridadePercentual = 1-similaridade/100;
		double aux;
		double aux2;
		ArrayList<NoticiaSimilaridade> retorno = new ArrayList<NoticiaSimilaridade>();
		Set<String> chaves = bancoFake.keySet();
		CosineDistance a = new CosineDistance();
		LevenshteinDistance b = new LevenshteinDistance();
		NoticiaSimilaridade inserir;
		for (String iterator : chaves)
		{
			aux = a.apply(bancoFake.get(iterator).getTextoProcessado(), web.getTextoProcessado());
			aux2 = b.apply(bancoFake.get(iterator).getTextoProcessado(), web.getTextoProcessado());
			if(aux<=similaridadePercentual && aux2<=similaridadePercentual) 
			{
				inserir = new NoticiaSimilaridade();
				inserir.setTextoOriginal(bancoFake.get(iterator).getTextoOriginal());
				inserir.setTextoProcessado(bancoFake.get(iterator).getTextoProcessado());
				inserir.setUrl(bancoFake.get(iterator).getUrl());
				inserir.setSimilaridadeCosine(aux);
				inserir.setSimilaridadeLevenshtein(aux2);
				retorno.add(inserir);
			}
		}

		return retorno;
	}

}
