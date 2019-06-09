package br.ufrn.imd.controle;
import br.ufrn.imd.dominio.NoticiaSimilaridade;
import br.ufrn.imd.dominio.LeituraFileCSV;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import br.ufrn.imd.dominio.CalculoSimilaridade;
import br.ufrn.imd.dominio.Noticia;
public class Controler {

	public static ArrayList<NoticiaSimilaridade> ControleGeral(String webNoticia, int limiarConfianca,int tamanhoCorte,String caminho) throws NoSuchAlgorithmException 
	{
		Noticia web = new Noticia();
		web.setTextoProcessado(webNoticia);
		web.setTextoOriginal(webNoticia);
		web.ProcessarMensagem(tamanhoCorte);
		HashMap<String,Noticia> banco = new HashMap<String,Noticia>();
		try 
		{
			banco = LeituraFileCSV.LerCSVGerarHashMap(caminho, tamanhoCorte);
		}
		catch(Exception e) 
		{
			System.out.println("Erro ao abrir arquivo");
		}
		ArrayList<NoticiaSimilaridade> a = CalculoSimilaridade.SimilaridadeBancoDados(web, banco, limiarConfianca);
		return a;
	}

}
