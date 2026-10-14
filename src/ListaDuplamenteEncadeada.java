public class ListaDuplamenteEncadeada {

    private class No {
        Livro livro;
        No anterior;
        No proximo;

        No(Livro livro) {
            this.livro = livro;
        }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        inicio = null;
        fim = null;
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

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }

        tamanho++;
    }

    public void inserirFim(Livro livro) {
        No novo = new No(livro);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
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

        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }

        No novo = new No(livro);

        novo.anterior = atual.anterior;
        novo.proximo = atual;
        atual.anterior.proximo = novo;
        atual.anterior = novo;

        tamanho++;
        return true;
    }

    public Livro removerInicio() {
        if (estaVazia()) {
            return null;
        }

        Livro livro = inicio.livro;

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }

        tamanho--;
        return livro;
    }

    public Livro removerFim() {
        if (estaVazia()) {
            return null;
        }

        Livro livro = fim.livro;

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }

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

        if (posicao == tamanho - 1) {
            return removerFim();
        }

        No atual = inicio;

        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }

        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;

        tamanho--;
        return atual.livro;
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
        if (estaVazia()) {
            System.out.println("Lista vazia.");
            return;
        }

        No atual = inicio;

        while (atual != null) {
            System.out.println(atual.livro);
            atual = atual.proximo;
        }
    }
}