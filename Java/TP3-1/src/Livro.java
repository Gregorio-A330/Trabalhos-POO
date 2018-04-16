
public class Livro {

	private String nome;
	private String autor;
	private int anoPublicacao;
	
	public Livro(String nome, String autor, int anoPublicacao) {
		this.nome=nome;
		this.autor=autor;
		this.anoPublicacao=anoPublicacao;
	}

	public String getNomeLivro() {
		return nome;
	}
	
	public String getAutor() {
		return autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public void mostraLivro() {
		System.out.println("Nome do livro: " + getNomeLivro());
		System.out.println("Autor: " + getAutor());
		System.out.println("Ano de publicação: " + getAnoPublicacao());
	}



}




