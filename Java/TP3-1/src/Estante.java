import java.util.ArrayList;

public class Estante {

	private String nome;
	private Categoria categoria;
	private ArrayList<Livro> livro;
	
	public Estante(String nome, Categoria categoria) {
		this.nome=nome;
		this.categoria=categoria;
		this.livro = new ArrayList<Livro>();
	}
	
	public String getNomeEstante() {
		return nome;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void addLivro(Livro l) {
		if (l != null)
			livro.add(l);
	}
	
	public void removerLivro(Livro l) {
		if (livro.remove(l))
			System.out.println(l.getNomeLivro() + " removido");
		else
			System.out.println("Livro não encontrado");
	}
	
	public void listarTodosLivros() {
		for(Livro l : livro) {
			l.mostraLivro();
		}
	}
		
}
