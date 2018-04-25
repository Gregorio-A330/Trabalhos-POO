import java.util.ArrayList;

public class Estante {

	private String nome;
	private Categoria categoria;
	private ArrayList<Livro> livros;

	public Estante(String nome, Categoria categoria) {
		this.nome = nome;
		this.categoria = categoria;
		this.livros = new ArrayList<Livro>();
	}

	public String getNome() {
		return nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void inserirLivro(Livro l) {
		livros.add(l);
	}

	public void removerLivro(Livro l) {
		livros.remove(l);
	}
	
	public boolean removerLivroNome (String nomeLivro) {
		for(Livro l : livros) {
			if(l.getNome().equalsIgnoreCase(nomeLivro)) {
				livros.remove(l);
				return true;
			}
		}
		return false;
	}
	
	public void mostrarEstante() {
		System.out.println("Estante: " + getNome());
		System.out.println("Categoria: " + getCategoria());
	}

	public void listarLivros() {
		for (Livro l : livros) {
			l.mostrarInfoLivro();
		}
	}

	public void listarAutores() {
		for (Livro l : livros)
			l.getAutor();
	}

	public int getQtde() {
		return livros.size();
	}

	public boolean isVazia() {
		return livros.size() == 0;
	}

	public boolean pesquisarLivro(String nomeLivro) {
		for (Livro l : livros) {
			if (l.getNome().equalsIgnoreCase(nomeLivro)) {
				return true;
			}
		}
		return false;
	}
	
}
