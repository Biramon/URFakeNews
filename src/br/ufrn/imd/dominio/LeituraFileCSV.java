package br.ufrn.imd.dominio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class LeituraFileCSV {

	public static void main(String[] args) 
	{
		String boatosCSV = "C:\\Users\\Yan\\Downloads\\boatos.csv";
		BufferedReader conteudoCSV = null;
		String linha = "";
		//String separador = "\"";
		Noticia b;
		ArrayList<Noticia> a = new ArrayList<Noticia>();
		try 
		{
			boolean cabecalho = false;
			conteudoCSV = new BufferedReader(new FileReader(boatosCSV));
			while((linha =conteudoCSV.readLine())!= null)
			{
				if(cabecalho) {
					b = new Noticia(linha);
					//String[] linhaConteudo = linha.split(separador);
					a.add(b);
				}
				else
				{
					cabecalho = true;
				}
			}
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("Arquivo não encontrado: \n"+e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("IndexOutOfBounds: \n"+e.getMessage());
		}
		catch(IOException e) 
		{
			System.out.println("Io erro: \n"+e.getMessage());
		}
		finally 
		{
			if(conteudoCSV != null) 
			{
				try 
				{
					conteudoCSV.close();
				}
				catch(IOException e) 
				{
					System.out.println("IO erro: \n"+e.getMessage());
				}
			}
		}
		String[] noticiaFiltrada;
		System.out.println(a.get(0).getTextoOriginal());
		int contadorDeError = 0;
		for(Noticia c : a) 
		{	
			noticiaFiltrada = c.getTextoOriginal().split("\"");
			if(noticiaFiltrada.length>1) {
				c.setTextoProcessado(noticiaFiltrada[1]);
			}
			else 
			{
				contadorDeError++;
			}
		}
		System.out.println(contadorDeError);
		System.out.println(a.get(5).getTextoProcessado());
	}

}
