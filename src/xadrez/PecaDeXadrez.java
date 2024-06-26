package xadrez;

import jogodetabuleiro.Peca;
import jogodetabuleiro.Tabuleiro;

public class PecaDeXadrez extends Peca {
    private Cor cor;

    public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

}
