package Biblioteca;
import java.util.ArrayList;

public class Estante {

    private String nome;
    private Categoria categoria;
    private Livro[] livros;

    public Estante(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.livros = new Livro[10];
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void inserirLivro(Livro livro) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livros[i] = livro;
                break;
            }
        }
    }

    public void removerLivro(Livro livro) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && livros[i].getNome().equals(livro.getNome())) {
                livros[i] = null;
            }
        }
    }

    public boolean isVazia() {
        return livros.length == 0;
    }
    
    public void removerLivroNome(String nomeLivro) {
	for(int i = 0; i < livros.length; i++) {
            if (livros[i] != null && livros[i].getNome().equalsIgnoreCase(nomeLivro))
                livros[i] = null;
        }
    }
    
    public boolean pesquisarLivro(String nomeLivro) {
	for(int i = 0; i < livros.length; i++) {
            if (livros[i].getNome().equalsIgnoreCase(nomeLivro))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Estante [" + "NOME:" + nome + ", CATEGORIA:" + categoria + "]";
    }
    
    
}
