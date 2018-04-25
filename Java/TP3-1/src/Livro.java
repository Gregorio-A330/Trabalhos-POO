
public class Livro {

	private String nome, autor;
	private int anoPublicacao;

	public Livro(String nome, String autor, int anoPublicacao) {
		this.nome = nome;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
	}

	public String getNome() {
		return nome;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void mostrarInfoLivro() {
		System.out.println("Livro: " + getNome());
		System.out.println("Autor: " + getAutor());
		System.out.println("Ano de Publicação: " + getAnoPublicacao());
	}
	
	@Override
	public String toString() {
		return "\nLivro: " + getNome() + "\nAutor: " + getAutor() + "\nAno de publicacao: " + getAnoPublicacao();
	}

	
}
