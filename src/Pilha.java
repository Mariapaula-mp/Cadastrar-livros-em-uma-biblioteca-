public class Pilha {

    private class No {
        Livro livro;
        No proximo;

        No(Livro livro) {
            this.livro = livro;
        }
    }

    private No topo;
    private int tamanho;

    public Pilha() {
        topo = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void empilhar(Livro livro) {
        No novo = new No(livro);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    public Livro desempilhar() {
        if (estaVazia()) {
            return null;
        }

        Livro livro = topo.livro;
        topo = topo.proximo;
        tamanho--;

        return livro;
    }

    public Livro consultarTopo() {
        if (estaVazia()) {
            return null;
        }

        return topo.livro;
    }

    public Livro pesquisar(int codigo) {
        No atual = topo;

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
            System.out.println("Pilha vazia.");
            return;
        }

        No atual = topo;

        while (atual != null) {
            System.out.println(atual.livro);
            atual = atual.proximo;
        }
    }
}