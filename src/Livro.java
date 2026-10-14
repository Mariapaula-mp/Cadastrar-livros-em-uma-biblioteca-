public class Livro {

    private int codigo;
    private String titulo;
    private String autor;

    public Livro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Autor: " + autor;
    }
}