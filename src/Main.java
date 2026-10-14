public class Main {

    public static void main(String[] args) {

        Livro livro1 = new Livro(1, "Dom Casmurro", "Machado de Assis");
        Livro livro2 = new Livro(2, "O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        Livro livro3 = new Livro(3, "Capitães da Areia", "Jorge Amado");

        // Lista simplesmente encadeada
        System.out.println("=== LISTA ENCADEADA ===");

        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirInicio(livro1);
        lista.inserirFim(livro2);
        lista.inserirPosicao(livro3, 1);

        lista.listarTodos();

        System.out.println("Posição do livro 2: "
                + lista.verificarPosicao(2));

        System.out.println("Livro pesquisado: "
                + lista.pesquisar(3));

        System.out.println("Removido: "
                + lista.removerInicio());

        // Lista duplamente encadeada
        System.out.println("\n=== LISTA DUPLAMENTE ENCADEADA ===");

        ListaDuplamenteEncadeada listaDupla =
                new ListaDuplamenteEncadeada();

        listaDupla.inserirInicio(livro1);
        listaDupla.inserirFim(livro2);
        listaDupla.inserirPosicao(livro3, 1);

        listaDupla.listarTodos();

        System.out.println("Removido: "
                + listaDupla.removerPosicao(1));

        // Pilha
        System.out.println("\n=== PILHA ===");

        Pilha pilha = new Pilha();

        pilha.empilhar(livro1);
        pilha.empilhar(livro2);
        pilha.empilhar(livro3);

        pilha.listarTodos();

        System.out.println("Topo: " + pilha.consultarTopo());
        System.out.println("Desempilhado: " + pilha.desempilhar());

        // Fila
        System.out.println("\n=== FILA ===");

        FilaLivros fila = new FilaLivros();

        fila.enfileirar(livro1);
        fila.enfileirar(livro2);
        fila.enfileirar(livro3);

        fila.listarTodos();

        System.out.println("Primeiro da fila: "
                + fila.consultarInicio());

        System.out.println("Desenfileirado: "
                + fila.desenfileirar());
    }
}