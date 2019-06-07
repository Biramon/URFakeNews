package br.ufrn.imd.dominio;

public class NoticiaSimilaridade extends Noticia
{
	double similaridadeCosine;
	double similaridadeLevenshtein;
	public NoticiaSimilaridade() {}
	public double getSimilaridadeCosine() {
		return similaridadeCosine;
	}
	public void setSimilaridadeCosine(double similaridadeCosine) {
		this.similaridadeCosine = similaridadeCosine;
	}
	public double getSimilaridadeLevenshtein() {
		return similaridadeLevenshtein;
	}
	public void setSimilaridadeLevenshtein(double similaridadeLevenshtein) {
		this.similaridadeLevenshtein = similaridadeLevenshtein;
	}
	

}
