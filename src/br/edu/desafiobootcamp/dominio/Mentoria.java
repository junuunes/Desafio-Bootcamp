package br.edu.desafiobootcamp.dominio;

import java.time.LocalDateTime;

public class Mentoria extends ConteudoEducacional {
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    private LocalDateTime data;

    @Override
    public double calcularXP() {
        return XP_PADRAO;
    }
}
