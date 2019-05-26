package br.ufrn.imd.dominio;

public interface ProcessamentoMensagem
{
	void tamanhoCorte(int valor);
	void removerPontuacao();
	void removerAcentuacao();
	void transformarLowerCase();
	void removerRepeticao();
	void ordenar();
	void ProcessarMensagem(int valor);
}
