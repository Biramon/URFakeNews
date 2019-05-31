package br.ufrn.imd.dominio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GerarHash {

	
	public static String Hash(String mensagem) throws NoSuchAlgorithmException 
	{
		try {
			final MessageDigest md = MessageDigest.getInstance("SHA-1");
			final byte[] hash = md.digest(mensagem.getBytes());
			String mensagemGerada = toHexFormat(hash);
			return mensagemGerada;
		}
		catch(NoSuchAlgorithmException e) 
		{
			e.getStackTrace();
		}
		return "";
	}

	private static String toHexFormat(final byte[] bytes) {
		final StringBuilder sb = new StringBuilder();
		for (byte b : bytes) 
		{
		   sb.append(String.format("%02x", b));
		 }
		 
		  return sb.toString();
		}
}
