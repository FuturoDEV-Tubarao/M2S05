package br.senai.sc.todolist.view;

import java.util.List;
import java.util.Scanner;

import br.senai.sc.todolist.model.Operacao;
import br.senai.sc.todolist.model.Tarefa;
import br.senai.sc.todolist.model.TipoMensagem;

public class TarefaCLI {
    
    public void exibirMenu() {
        System.out.println();
        System.out.println(ConsoleColors.BLUE_BOLD + " === Lista de Tarefas - MENU === " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "1 - Incluir Tarefa" );
        System.out.println("2 - Excluir Tarefa");
        System.out.println("3 - Listar Tarefa");
        System.out.println("4 - Listar Tarefa pelo id");
        System.out.println("5 - Marcar tarefa como concluída");
        System.out.println("6 - Exportar tarefas para arquivo");
        System.out.println("7 - SAIR" + ConsoleColors.RESET);
        System.out.println();
    }

    public Operacao obterOperacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print ("Informe a operação desejada: ");
        int codigoOperacao = scanner.nextInt();
        System.out.println();
        Operacao[] operacoes = Operacao.values();
        Operacao operacao = operacoes[codigoOperacao-1];
        return operacao;
    }

    public void exibirMensagem(String mensagem, TipoMensagem tipo) {
        System.out.println();
        String nomeCor = null;
        switch (tipo) {
            case SUCESSO:
                nomeCor = ConsoleColors.GREEN_BOLD;
                break;
            case AVISO:
                nomeCor = ConsoleColors.YELLOW_BOLD;
                break;
            case ERRO:
                nomeCor = ConsoleColors.RED_BOLD;
                break;
        }
        System.out.println(nomeCor + mensagem + ConsoleColors.RESET);
        System.out.println();
    }

    public Tarefa obterDadosTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o texto da tarefa: ");
        String texto = scanner.nextLine();
        Tarefa tarefa = new Tarefa(texto);
        return tarefa;
    }

    public void exibirListagem(List<Tarefa> lista) {
        System.out.println();
        System.out.println("Tarefas cadastradas:");
        for(Tarefa tarefa : lista) {
            System.out.println("- " + tarefa);
        }
        System.out.println();
    }

    public void exibir(Tarefa tarefa) {
        System.out.println();
        System.out.println("- " + tarefa);
        System.out.println();
    }

    public void aguardar() {
        System.out.println(ConsoleColors.BLUE_BACKGROUND + 
            "Pressione qualquer tecla para continuar... " + ConsoleColors.RESET);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }

    public int obterIdDaTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o id da tarefa: ");
        int id = scanner.nextInt();
        return id;        
    }

}
