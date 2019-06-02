package br.ufrn.imd.visao;

import br.ufrn.imd.dominio.Noticia;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Set;

import br.ufrn.imd.dominio.LeituraFileCSV;
public class teste {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String caminho = "C:\\Users\\Yan\\Downloads\\boatos.csv";
		HashMap<String, Noticia> a = LeituraFileCSV.LerCSVGerarHashMap(caminho, 4);
		Set<String> chaves = a.keySet();
		for (String iterator : chaves)
		{
			System.out.println(a.get(iterator).getTextoProcessado());
		}
		
	}

}
