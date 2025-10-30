package br.edu.desafiobootcamp.dominio;

//ninguém instancia.
public abstract class ConteudoEducacional {
    protected static final double XP_PADRAO = 10.00;

    private String titulo;
    private String descricao;
    private Instrutor instrutor;
    //private Devs devInscrito;

    public abstract double calcularXP();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
}
