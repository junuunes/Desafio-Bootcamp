package br.edu.desafiobootcamp;

import br.edu.desafiobootcamp.dominio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Curso cursoJavaBasico = new Curso();
        cursoJavaBasico.setTitulo("Java Básico");
        cursoJavaBasico.setDescricao("Aprenda os conceitos básicos sobre Java.");
        cursoJavaBasico.setCargahoraria(8);

        Curso cursoDotNet = new Curso();
        cursoDotNet.setTitulo("Java .NET");
        cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre C#.");
        cursoDotNet.setCargahoraria(8);

        Curso cursoJavaAvancado = new Curso();
        cursoJavaAvancado.setTitulo("Java Avançado");
        cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados sobre Java.");
        cursoJavaAvancado.setCargahoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprendendo orientação a objetos em Java.");
        mentoria.setDescricao("Imersão sobre os pilares d eorientação a objetos");
        mentoria.setData(LocalDateTime.now().plusDays(1));
        /*LocalDateTime É uma classe do pacote java.time (a API moderna de datas e horas do Java).
        LocalDateTime.now() Cria um objeto de data e hora atual do sistema.
        .plusDays(1) Esse método não altera o objeto original, mas cria um novo com 1 dia a mais.
        */

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("START JAVA");
        bootcamp.setInicio(LocalDate.now());
        bootcamp.setFim(bootcamp.getInicio().plusDays(45));
        /*bootcamp.getInicio() Aqui está lendo o valor armazenado no atributo inicio do objeto bootcamp.
        .plusDays(45) Esse método não altera o valor original, ele cria um novo objeto com 45 dias a mais.
        setFim() Ele recebe o resultado da expressão anterior (a nova data com +45 dias) e guarda no atributo fim.
        */
        List<ConteudoEducacional> conteudos = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
        /* É uma lista que só pode conter objetos da classe ConteudoEducacional (ou classes que herdem dela).
        Arrays.asList(...) método estático da classe Arrays. Ele serve para criar uma lista a partir de elementos já existentes.
        Nesse caso a lista de objetos.
        Tem tamanho fixo e não dá para adicionar e remover elementos depois
         */
        bootcamp.setConteudos(conteudos);
        //aqui ele está mandando a lista de conteúdos acima por parametro para guardar o valor
        // atraves do metodo set no atributo conteudos da classe Bootcamp


        Devs devCadastrado1 = new Devs();
        devCadastrado1.setNome("Juliana Nunes da Silva");
        devCadastrado1.setEmail("juliana@gmail.com");

        devCadastrado1.inscrever(cursoDotNet);
        devCadastrado1.inscrever(bootcamp);
        devCadastrado1.progredir();
        devCadastrado1.progredir();

        Devs devCadastrado2 = new Devs();
        devCadastrado2.setNome("Igor Cardoso de Jesus");
        devCadastrado2.setEmail("igor@gmail.com");
        //devCadastrado2.inscrever(cursoDotNet);
        devCadastrado2.inscrever(bootcamp);
        devCadastrado2.progredir();
        devCadastrado2.progredir();
        devCadastrado2.progredir();

        System.out.println(String.format("XP JULIANA: %.2f", devCadastrado1.calcularXP()));
        System.out.println(String.format("XP IGOR: %.2f", devCadastrado2.calcularXP()));

        List<Devs> ranking = Arrays.asList(devCadastrado1, devCadastrado2).stream().sorted((dev2, dev1) -> Double.compare(dev1.calcularXP(), dev2.calcularXP())).collect(Collectors.toList());
        for (Devs dev : ranking){
            System.out.println(dev.getNome());
        }
    }
}
