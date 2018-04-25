import java.util.ArrayList;

public class Biblioteca {

	private String nome;
	private ArrayList<Estante> estante;

	public Biblioteca(String nome) {
		this.nome = nome;
		this.estante = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Estante> getEstante() {
		return estante;
	}

	public void inserirEstante(Estante e) {
		estante.add(e);
	}

	public ArrayList<Livro> listarFilosofia() {
		ArrayList<Livro> livroFilo = new ArrayList<>();
		for (Estante e : estante) {
			if (e.getCategoria() == Categoria.FILOSOFIA) {
				for (int i = 0; i < estante.size(); i++) {
					if (estante.get(i).getLivros() != null)
						livroFilo.addAll(estante.get(i).getLivros());
				}
			} else
				System.out.println("Categoria vazia...");
		}
		return livroFilo;
	}

	public ArrayList<Livro> listarCiencia() {
		ArrayList<Livro> livroCiencia = new ArrayList<>();
		for (Estante e : estante) {
			if (e.getCategoria() == Categoria.CIENCIA) {
				for (int i = 0; i < estante.size(); i++) {
					if (estante.get(i).getLivros() != null)
						livroCiencia.addAll(estante.get(i).getLivros());
				}
			} else
				System.out.println("Categoria vazia...");
		}
		return livroCiencia;
	}

	public ArrayList<Livro> listarLiteratura() {
		ArrayList<Livro> livroLiteratura = new ArrayList<>();
		for (Estante e : estante) {
			if (e.getCategoria() == Categoria.LITERATURA) {
				for (int i = 0; i < estante.size(); i++) {
					if (estante.get(i).getLivros() != null) {
						livroLiteratura.addAll(estante.get(i).getLivros());
					}
				}
			} else
				System.out.println("Categoria vazia...");
		}
		return livroLiteratura;
	}

	public ArrayList<String> listarAutores(Categoria cat) {
		ArrayList<String> autores = new ArrayList<>();
		ArrayList<Livro> livroAux = new ArrayList<>();
		for (Estante e : estante) {
			for (int i = 0; i < estante.size(); i++) {
				autores.add(livroAux.get(i).getAutor());
			}
		}
		return autores;
	}

	public int qtdeLivros() {
		int qtdLivros = 0;
		for (Estante e : estante) {
			for (int i = 0; i < estante.size(); i++)
				qtdLivros++;
		}
		return qtdLivros;
	}

	public void listarEstante() {
		for (Estante e : estante) {
			e.mostrarEstante();
		}
	}

	public boolean pesquisarEstante(String nomeEstante) {
		for (Estante e : estante) {
			if (e.getNome().equalsIgnoreCase(nomeEstante)) {
				return true;
			}
		}
		return false;
	}

	public void listarTodos() {
		for (Estante e : estante) {
			e.listarLivros();
		}
	}

	public int getQtde() {
		return estante.size();
	}

	public boolean removerEstante(String nomeEstante) {
		for (Estante e : estante) {
			if (e.getNome().equalsIgnoreCase(nomeEstante) && e.isVazia()) {
				estante.remove(e);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Estante> pesquisarEstanteIndice(String nomeEstante) {
		for (int i = 0; i <= estante.size(); i++) {
			if (estante.get(i).getNome() == nomeEstante)
				return estante;
		}
		return null;
	}

	public void removeEstante(Estante e) {
		for (int i = 0; i <= estante.size(); i++) {
			if (estante.get(i) == e) {
				estante.remove(i);
				System.out.println("Estante removida...");
			} else
				System.out.println("Estante não encontrada...");
		}
	}

}
