package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {
        // Criando cursos
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        // Criando mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        // Criando bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Criando Dev Camila
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);

        // Progresso da Camila
        devCamila.progredir();
        devCamila.progredir();

        // Criando Dev João
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);

        // Progresso do João
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        // Exibindo informações de todos os Devs
        exibirInfoDev(devCamila);
        System.out.println("-------");
        exibirInfoDev(devJoao);
    }

    // Método auxiliar para exibir informações de um Dev
    public static void exibirInfoDev(Dev dev) {
        System.out.println("Dev: " + dev.getNome());
        System.out.println("Nível: " + dev.calcularNivel());
        System.out.println("XP total: " + dev.calcularTotalXpComBonus());
        System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos().stream()
                .map(c -> c.getTitulo()).toList());
        System.out.println("Conteúdos Pendentes: " + dev.getConteudosInscritos().stream()
                .map(c -> c.getTitulo()).toList());
    }
}