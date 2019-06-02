package br.ufrn.imd.dominio;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import com.opencsv.CSVReader;
public class LeituraFileCSV {


	public static HashMap<String, Noticia> LerCSVGerarHashMap(String caminho, int tamanhoCorte) throws NoSuchAlgorithmException 
	{
		HashMap<String,Noticia> hash = new HashMap<String,Noticia>();
		try 
		{
			FileInputStream fis = new FileInputStream(caminho);
			InputStreamReader d = new InputStreamReader(fis,StandardCharsets.UTF_8);
			CSVReader reader = new CSVReader(d);
			String[] nextLine;
			Noticia aux;
			String saux;
			boolean cabecalho = false;
			while((nextLine= reader.readNext())!= null) 
			{
				if(nextLine != null && cabecalho!= false) 
				{
					aux = new Noticia();
					//System.out.println(nextLine[1]);
					aux.setTextoOriginal(nextLine[1]);
					aux.setTextoProcessado(nextLine[1]);
					aux.setUrl(nextLine[2]);
					aux.ProcessarMensagem(tamanhoCorte);
					saux = GerarHash.Hash(aux.getTextoProcessado());
					hash.put(saux, aux);
					nextLine = null;
				}
				else 
				{
					cabecalho = true;
				}
			}
			reader.close();
		}
		catch(Exception e) 
		{
			System.out.println("erro"+e.getMessage());
		}
		return hash;
		
	}

}
