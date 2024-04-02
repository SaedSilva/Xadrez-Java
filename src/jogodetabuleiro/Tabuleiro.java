package jogodetabuleiro;

public class Tabuleiro {
    private int linhas;
    private int colunas;

    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new ExcessaoDeTabuleiro("Erro criando tabuleiro: É necessário que tenha pelo menos 1 linha e coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }


    public int getColunas() {
        return colunas;
    }


    public Peca peca(int linha, int coluna) {
        if (!existenciaDePosicao(linha, coluna)) {
            throw new ExcessaoDeTabuleiro("Erro de posição: Essa posição não existe");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!existenciaDePosicao(posicao)) {
            throw new ExcessaoDeTabuleiro("Erro de posição: Essa posição não existe");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (haUmaPeca(posicao)) {
            throw new ExcessaoDeTabuleiro("Há uma peça nessa posição" + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    private boolean existenciaDePosicao(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public boolean existenciaDePosicao(Posicao posicao) {
        return existenciaDePosicao(posicao.getLinha(), posicao.getColuna());
    }

    public boolean haUmaPeca(Posicao posicao) {
        if (!existenciaDePosicao(posicao)) {
            throw new ExcessaoDeTabuleiro("Erro de posição: Essa posição não existe");
        }
        return peca(posicao) != null;
    }

}
