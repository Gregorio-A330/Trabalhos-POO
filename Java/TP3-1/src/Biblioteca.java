import java.util.ArrayList;

public class Biblioteca {

	private String nome;
	private ArrayList<Estante> estante;

	public Biblioteca(String nome) {
		this.nome = nome;
		this.estante = new ArrayList<Estante>();
	}

	public String getNomeBiblioteca() {
		return nome;
	}

	public void addEstante(Estante e) {
		if (e != null)
			estante.add(e);
	}

	public void removerEstante(Estante e) {
		if (estante.remove(e))
			System.out.println(e.getNomeEstante() + " removido");
		else
			System.out.println("Estante não encontrada");
	}

	public ArrayList<Estante> mostrarEstantes() {
		return estante;
	}

	public void listarTodasEstantes() {
		ArrayList<Livro> l;
		int cont = 0;
		for (Estante e : estante) {
			l = e.mostraLivro();
			for (int i = 0; i < e.size(); i++) {
				if (l.get(i) != null)
					System.out.println("Nome: " + l.getNomeLivro() + " Autor: " + l.getAutor());
			}
		}
	}

	public int contarLivroCiencia() {
		int cont = 0;
		for (Estante e : estante) {
			if (e.getCategoria() == Categoria.CIENCIA) {
				for (int i = 0; i < estante.size(); i++) {
					cont++;
				}
			}
		}
		return cont;
	}

	public ArrayList<Livro> listarLivroFilosofia() {
		ArrayList<Livro> livroFilosofia;
		for (Estante e : estante) {
			if (e.getCategoria() == Categoria.FILOSOFIA) {
				for (int i = 0; i < estante.size(); i++) {
					if (e.listarTodosLivros() != null) {
						livroFilosofia.get(i) = e.listarTodosLivros();
					}
				}
			}

		}
		return livroFilosofia;
	}

	public ArrayList<String> listarAutor(Categoria cat) {
		ArrayList<String> autor = new ArrayList<String>();
		ArrayList<Livro> l;
		for (Estante e : estante) {
			if (es.getCatEstante() == cat) {
				l = e.mostrarLivros();
				for (int i = 0; i < e.size(); i++) {
					autor.add(l.get(i));
				}
			}
		}
		return autor;
	}

}
