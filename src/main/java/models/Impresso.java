package models;

import exception.EstoqueInsuficienteException;

public class Impresso extends Livro {

    private Float frete;
    private Integer estoque;

    public Impresso(String titulo, String autores, String editora, float preco, float frete, int estoque) {
        super(titulo, autores, editora, preco);
        this.frete = frete;
        this.estoque = estoque;
    }

    public void atualizarEstoque() throws EstoqueInsuficienteException {
        if (estoque > 0) {
            estoque--;
        } else {
            throw new EstoqueInsuficienteException("Livros impressos esgotados.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tipo - Impresso\n" +
                "Valor frete: R$" + frete + "\n" +
                "Qtd Estoque: " + estoque;
    }
}
