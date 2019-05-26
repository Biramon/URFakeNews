package br.ufrn.imd.dominio;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.text.Normalizer;
import java.util.regex.Pattern;
public class Noticia implements ProcessamentoMensagem {
	protected String textoOriginal;
	protected String textoProcessado;
	protected Date dataHoraAcesso;
	protected String url;
	public Noticia(String textoOriginal){
		this.textoOriginal = textoOriginal;
		this.textoProcessado = this.textoOriginal;
	}
	//Ao invés de se fazer um mapeamento para cada caso, achamos esse método na internet e resolvemos,
	//implementá-lo para simplificar o problema.
	public static String deAccent(String str){
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	@Override
	public void tamanhoCorte(int valor) {
		String[] aux = this.textoProcessado.split(" ");
		String b="";
		for(String a: aux) 
		{
			if(a.length()>valor)
			{
				b = b +" "+ a;
			}
		}
		b = b.trim();
		this.textoProcessado = b;
	}

	@Override
	public void removerPontuacao() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add(".");
		aux.add(",");
		aux.add(";");
		aux.add(":");
		aux.add("\"");
		aux.add("'");
		aux.add("!");
		aux.add("?");
		aux.add("/");
		aux.add("\\");
		aux.add("-");
		aux.add("(");
		aux.add(")");
		aux.add("%");
		aux.add("$");
		aux.add("@");
		aux.add("|");
		aux.add("*");
		aux.add("#");
		aux.add(".");
		aux.add("=");
		aux.add("+");
		aux.add("<");
		aux.add(">");
		aux.add("{");
		aux.add("}");
		aux.add("[");
		aux.add("]");
		for(String a : aux){
			this.textoProcessado = this.textoProcessado.replace(a,"");
		}
	}
	@Override
	public void removerAcentuacao() {
		this.textoProcessado = deAccent(this.textoProcessado);
	}

	@Override
	public void transformarLowerCase() {
		this.textoProcessado = this.textoProcessado.toLowerCase();		
	}

	@Override
	public void removerRepeticao() {
		HashSet<String> aux = new HashSet<String>();
		String[] auxB = this.textoProcessado.split(" ");
		for(String a : auxB) 
		{
			aux.add(a);
		}
		String retorno = "";
		for(String a : aux) 
		{
			retorno = retorno + " " + a;
		}
		retorno = retorno.trim();
		this.textoProcessado = retorno;
	}

	@Override
	public void ordenar() {
		String[] auxB = this.textoProcessado.split(" ");
		List<String> list = Arrays.asList(auxB);
		Collections.sort(list);
		String aux = "";
		for(String a : list) 
		{
			aux = aux + " " + a;
		}
		aux = aux.trim();
		this.textoProcessado = aux;
	}

	@Override
	public void ProcessarMensagem(int valor) {
		this.removerPontuacao();
		this.tamanhoCorte(valor);
		this.removerAcentuacao();
		this.transformarLowerCase();
		this.removerRepeticao();
		this.ordenar();
	}
	public String getTextoOriginal() {
		return textoOriginal;
	}
	public void setTextoOriginal(String textoOriginal) {
		this.textoOriginal = textoOriginal;
	}
	public String getTextoProcessado() {
		return textoProcessado;
	}
	public void setTextoProcessado(String textoProcessado) {
		this.textoProcessado = textoProcessado;
	}
	public Date getDataHoraAcesso() {
		return dataHoraAcesso;
	}
	public void setDataHoraAcesso(Date dataHoraAcesso) {
		this.dataHoraAcesso = dataHoraAcesso;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	//fonte remover pontuação
	//https://pt.stackoverflow.com/questions/42/como-remover-acentos-e-outros-sinais-gr%C3%A1ficos-de-uma-string-em-java

}
