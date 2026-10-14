public class ListaEncadeada {

    private class No {
        Livro livro;
        No proximo;

        No(Livro livro) {
            this.livro = livro;
        }
    }

    private No inicio;
    private int tamanho;

    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inserirInicio(Livro livro) {
        No novo = new No(livro);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    }

    public void inserirFim(Livro livro) {
        No novo = new No(livro);

        if (estaVazia()) {
            inicio = novo;
        } else {
            No atual = inicio;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novo;
        }

        tamanho++;
    }

    public boolean inserirPosicao(Livro livro, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            return false;
        }

        if (posicao == 0) {
            inserirInicio(livro);
            return true;
        }

        if (posicao == tamanho) {
            inserirFim(livro);
            return true;
        }

        No atual = inicio;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }

        No novo = new No(livro);
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        tamanho++;

        return true;
    }

    public Livro removerInicio() {
        if (estaVazia()) {
            return null;
        }

        Livro livro = inicio.livro;
        inicio = inicio.proximo;
        tamanho--;

        return livro;
    }

    public Livro removerFim() {
        if (estaVazia()) {
            return null;
        }

        if (tamanho == 1) {
            return removerInicio();
        }

        No atual = inicio;

        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        Livro livro = atual.proximo.livro;
        atual.proximo = null;
        tamanho--;

        return livro;
    }

    public Livro removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        }

        No atual = inicio;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }

        Livro livro = atual.proximo.livro;
        atual.proximo = atual.proximo.proximo;
        tamanho--;

        return livro;
    }

    public Livro pesquisar(int codigo) {
        No atual = inicio;

        while (atual != null) {
            if (atual.livro.getCodigo() == codigo) {
                return atual.livro;
            }

            atual = atual.proximo;
        }

        return null;
    }

    public int verificarPosicao(int codigo) {
        No atual = inicio;
        int posicao = 0;

        while (atual != null) {
            if (atual.livro.getCodigo() == codigo) {
                return posicao;
            }

            atual = atual.proximo;
            posicao++;
        }

        return -1;
    }

    public void listarTodos() {
        No atual = inicio;

        if (estaVazia()) {
            System.out.println("Lista vazia.");
            return;
        }

        while (atual != null) {
            System.out.println(atual.livro);
            atual = atual.proximo;
        }
    }
}