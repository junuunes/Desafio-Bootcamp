package br.edu.desafiobootcamp.dominio;

public class Curso extends ConteudoEducacional {
    private int cargahoraria;

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO * cargahoraria;
    }
}
