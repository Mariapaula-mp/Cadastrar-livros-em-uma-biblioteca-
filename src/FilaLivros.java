public class FilaLivros {

    private class No {
        Livro livro;
        No proximo;

        No(Livro livro) {
            this.livro = livro;
        }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public FilaLivros() {
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

    public void enfileirar(Livro livro) {
        No novo = new No(livro);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }

        tamanho++;
    }

    public Livro desenfileirar() {
        if (estaVazia()) {
            return null;
        }

        Livro livro = inicio.livro;
        inicio = inicio.proximo;
        tamanho--;

        if (inicio == null) {
            fim = null;
        }

        return livro;
    }

    public Livro consultarInicio() {
        if (estaVazia()) {
            return null;
        }

        return inicio.livro;
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

    public void listarTodos() {
        if (estaVazia()) {
            System.out.println("Fila vazia.");
            return;
        }

        No atual = inicio;

        while (atual != null) {
            System.out.println(atual.livro);
            atual = atual.proximo;
        }
    }
}