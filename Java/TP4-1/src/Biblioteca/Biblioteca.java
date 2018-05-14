package Biblioteca;
import java.util.ArrayList;

public class Biblioteca {

    private String nome;
    private ArrayList<Estante> estantes;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.estantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Estante> getEstantes() {
        return estantes;
    }

    public void inserirEstante(Estante estante) {
        estantes.add(estante);
    }

    public Livro[] listarFilosofia() {
        Livro[] livros;
        int quantidadeTotal = 0;
        int quantidadeControle = 0;
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.FILOSOFIA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        quantidadeTotal++;
                    }
                }
            }
        }
        livros = new Livro[quantidadeTotal];
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.FILOSOFIA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        livros[quantidadeControle] = estante.getLivros()[i];
                        quantidadeControle++;
                    }
                }
            }
        }
        return livros;
    }

    public Livro[] listarLiteratura() {
        Livro[] livros;
        int quantidadeTotal = 0;
        int quantidadeControle = 0;
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.LITERATURA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        quantidadeTotal++;
                    }
                }
            }
        }
        livros = new Livro[quantidadeTotal];
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.LITERATURA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        livros[quantidadeControle] = estante.getLivros()[i];
                        quantidadeControle++;
                    }
                }
            }
        }
        return livros;
    }
    
    public Livro[] listarCiencia() {
        Livro[] livros;
        int quantidadeTotal = 0;
        int quantidadeControle = 0;
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.CIENCIA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        quantidadeTotal++;
                    }
                }
            }
        }
        livros = new Livro[quantidadeTotal];
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.CIENCIA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        livros[quantidadeControle] = estante.getLivros()[i];
                        quantidadeControle++;
                    }
                }
            }
        }
        return livros;
    }
    
    public int contarCiencia() {
        int quantidadeTotal = 0;
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.CIENCIA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        quantidadeTotal++;
                    }
                }
            }
        }
        return quantidadeTotal;
    }
    
    public int contarFilosofia() {
        int quantidadeTotal = 0;
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.FILOSOFIA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        quantidadeTotal++;
                    }
                }
            }
        }
        return quantidadeTotal;
    }
    
    public int contarLiteratura() {
        int quantidadeTotal = 0;
        for (Estante estante : estantes) {
            if (estante.getCategoria() == Categoria.LITERATURA) {
                for (int i = 0; i < estante.getLivros().length; i++) {
                    if (estante.getLivros()[i] != null) {
                        quantidadeTotal++;
                    }
                }
            }
        }
        return quantidadeTotal;
    }
    
     public int contarLivros() {
        int quantidadeTotal = 0;
        for (Estante estante : estantes) {
            for (int i = 0; i < estante.getLivros().length; i++) {
                if (estante.getLivros()[i] != null) {
                    quantidadeTotal++;
                    }
                }
            }
        return quantidadeTotal;
    }

    public void listarTudo() {
        for (Estante estante : estantes) {
            for (int i = 0; i < estante.getLivros().length; i++) {
                if (estante.getLivros()[i] != null) {
                    System.out.println("==== LIVRO Nº" + i+1 + "====");
                    System.out.println(estante.getLivros()[i]);
                }
            }

        }
    }
    
    public ArrayList<String> listarAutores(Categoria cat){
        ArrayList<String> autores = new ArrayList<>();
        for(Estante estante : estantes){
            if(estante.getCategoria() == cat){
                for(int i = 0; i < estante.getLivros().length; i ++){
                    if(estante.getLivros()[i] != null){
                        autores.add(estante.getLivros()[i].getAutor());
                    }
                }
            }
        }
        return autores;        
    }
    
    public boolean pesquisarEstante(String nomeEstante) {
	for(Estante estante : estantes) {
            if (estante.getNome().equalsIgnoreCase(nomeEstante))
		return true;
	}
	return false;
    }
    
    public boolean removerEstante(String nomeEstante) {
	for (Estante estante : estantes) {
            if (estante.getNome().equalsIgnoreCase(nomeEstante) && estante.isVazia()) {
		estantes.remove(estante);
		return true;
            }
	}
	return false;
    }
}
