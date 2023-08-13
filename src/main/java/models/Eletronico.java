package models;

public class Eletronico extends Livro {

    private Integer tamanho;

    public Eletronico(String titulo, String autores, String editora, float preco, int tamanho) {
        super(titulo, autores, editora, preco);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tipo - Eletrônico\n" +
                "Tamanho: " + tamanho + " KB\n";
    }
}