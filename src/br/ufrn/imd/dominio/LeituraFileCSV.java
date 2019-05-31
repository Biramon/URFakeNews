package br.ufrn.imd.dominio;

import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Set;

import com.opencsv.CSVReader;
public class LeituraFileCSV {


	public static void main(String[] args) throws NoSuchAlgorithmException 
	{
		HashMap<String,Noticia> hash = new HashMap<String,Noticia>();
		try 
		{
			CSVReader reader = new CSVReader(new FileReader("/home/yancarlos05/Downloads/boatos.csv"));;
			String[] nextLine;
			Noticia aux;
			String saux;
			boolean cabecalho = false;
			while((nextLine= reader.readNext())!= null) 
			{
				if(nextLine != null && cabecalho!= false) 
				{
					aux= new Noticia(nextLine[1]);
					aux.setTextoOriginal(nextLine[1]);
					aux.setUrl(nextLine[2]);
					aux.ProcessarMensagem(4);
					saux = GerarHash.Hash(aux.getTextoProcessado());
					hash.put(saux, aux);
				}
				else 
				{
					cabecalho = true;
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println("erro"+e.getMessage());
		}
		Set<String> chaves = hash.keySet();
		for (String iterator : chaves)
		{
			System.out.println(hash.get(iterator).getTextoProcessado());
		}
		System.out.println(hash.size());
		
	}

}
