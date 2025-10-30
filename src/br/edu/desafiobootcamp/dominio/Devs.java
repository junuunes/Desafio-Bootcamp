package br.edu.desafiobootcamp.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Devs {
    private String nome;
    private String email;
    private List<ConteudoEducacional> conteudosInscritos = new ArrayList<ConteudoEducacional>();
    //instancia uma lista vazia sempre que um dev for criado, facilitando a implementação do métod0 inscrever.
    private List<ConteudoEducacional> conteudosConcluidos = new ArrayList<ConteudoEducacional>();

    public double calcularXP(){
        return conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXP()).sum();
    }
    public void progredir(){
        Optional<ConteudoEducacional> conteudo = conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()){
            conteudosConcluidos.add(conteudo.get());
            conteudosInscritos.remove(conteudo.get());
        } else{
            System.err.println("Você não está mais inscrito em nenhum conteúdo.");
        }
        /*ele “pega” o primeiro conteúdo da lista de conteúdos inscritos e:
            1. Move esse conteúdo para a lista de concluídos,
            2.Remove ele da lista de inscritos,
            3. Se não houver mais nada para progredir, mostra uma mensagem de aviso
         */
    }

    public void inscrever (ConteudoEducacional conteudos){
        if (conteudosInscritos.contains(conteudos)) {
            System.err.println("Você já se inscreveu nesse conteúdo!");
        } else {
            conteudosInscritos.add(conteudos);
        }
    }

    public void inscrever (Bootcamp bootcamp){
        for (ConteudoEducacional conteudo : bootcamp.getConteudos()){
            inscrever(conteudo);
        }
        //bootcamp.getConteudos().stream().forEach(this::inscrever); == bootcamp.getConteudos().stream().forEach(conteudo -> inscrever(conteudo));
        //Pegue todos os conteúdos do bootcamp, crie um fluxo (stream) deles,
        //e para cada conteúdo, chame o métod0 inscrever() do dev atual.

        bootcamp.getDevs().add(this);
        //
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
