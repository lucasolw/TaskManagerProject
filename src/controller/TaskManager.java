/**
 *
 * @author Lucas Oliveira
 */

package controller;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import model.Tarefa;
import model.TarefaPrioritaria;
import repository.RepositorioGenerics;

public class TaskManager{
    private final RepositorioGenerics<Tarefa> lista;
    private final Scanner sc;

    public TaskManager(Scanner sc){
        this.sc = sc;
        this.lista = new RepositorioGenerics<>();
    }




    public void adicionarTarefa(){

        while(true){
            System.out.println("\n1. Criar tarefa");
            System.out.println("\n2. Criar Tarefa(com Prioridade)");
            System.out.println("\n3. Sair");

            try{
                int opcao = sc.nextInt();
                sc.nextLine();

                if(opcao == 3){
                    break;
                }
                if(opcao != 1 && opcao != 2){
                    System.out.println("Opcao invalida!");
                    continue;
                }

                System.out.print("Titulo: ");
                String titulo = sc.nextLine();

                System.out.print("Descricao: ");
                String descricao = sc.nextLine();

                Tarefa tarefa;
                if(opcao == 1) {
                    tarefa = new Tarefa(
                            titulo,
                            descricao
                    );

                }
                else{
                    System.out.println("Prioridade: ");
                    String prioridade = sc.nextLine();

                    tarefa = new TarefaPrioritaria(
                            titulo,
                            descricao,
                            prioridade,
                            false
                    );



                }
                lista.adicionarElemento(tarefa);
                System.out.println("\nTarefa adicionada com sucesso!!");

            }
            catch(InputMismatchException e){
                System.out.println("*Digite somente numeros*");
                sc.nextLine();
            }
        }
    }

    public void listarTarefas(){

        OUTER:
        while (true) {
            System.out.println("\n1. Listar tarefas");
            System.out.println("2. Sair");
            try {
                int opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        List<Tarefa> tarefas = lista.listarElementos();
                        if(tarefas.isEmpty()){
                            System.out.println("Lista vazia!!");
                            continue;
                        }

                        System.out.println("\nSelecione uma das tarefa:");

                        for(int i = 0; i < tarefas.size(); i++){
                            System.out.println((i + 1) + " - " + tarefas.get(i).getTitulo());
                        }

                        int index = sc.nextInt();
                        
                        if(index < 1 || index > tarefas.size()){
                            System.out.println("\nIndice invalido!!");
                            continue;
                        }
                        

                        Tarefa tarefa = tarefas.get(index - 1);

                        System.out.println("\n===== INFORMACOES DA TAREFA =====");
                        System.out.println(tarefa);
                        break;
                    case 2:
                        break OUTER;
                    default:
                        System.out.println("\nOpcao invalida!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("**Digite somente numeros**");
                sc.nextLine();
            }
        }
    }

    public void removerTarefa(){

        while(true){
            System.out.println("\n1. Remover tarefa");
            System.out.println("2. Sair");

            try{
                int opcao = sc.nextInt();

                if(opcao == 1){
                    List<Tarefa> tarefas = lista.listarElementos();

                    if(tarefas.isEmpty()) {
                        System.out.println("\nLista vazia!!");
                        break;
                    }
                    System.out.println("\nSelecione uma tarefa que deseja remover: ");

                    for(int i = 0; i < tarefas.size(); i++){
                        System.out.println(
                                (i + 1) + " - " +
                                tarefas.get(i).getTitulo()
                        );
                    }

                    int index = sc.nextInt();

                    if(index < 1 || index > tarefas.size()){
                        System.out.println("Indice invalido!");
                        continue;
                    }

                    Tarefa tarefa = tarefas.get(index - 1);
                    lista.removerElemento(tarefa);

                    System.out.println("\nTarefa removida com sucesso!!");

                }
                else if(opcao == 2){
                    break;
                }
                else {
                    System.out.println("Opcao invalida!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("*Digite somente numeros*");
                sc.nextLine();
            }
        }
    }
    

    public void concluirTarefa(){
        List<Tarefa> tarefas = lista.listarElementos();
        ArrayList<Tarefa> pendentes = new ArrayList<>();
        
        if(tarefas.isEmpty()){
            System.out.println("Lista vazia!!");
            return;
        }

        System.out.println("\n===== Tarefas nao concluidas =====");

        //Compara cada indice da lista para saber se foi concluida
        for(Tarefa tarefa : tarefas){
            if(!tarefa.getConcluida()){
                //Joga a tarefa na lista de Pendentes
                pendentes.add(tarefa);
                
                System.out.println(
                    pendentes.size() + " - "+
                    tarefa.getTitulo()
                );
            }
        }
        if(pendentes.isEmpty()){
            System.out.println("Nenhuma tarefa pendente");
            return;
        }


        try{
            System.out.println("Escolha uma tarefa para ser concluida: ");

            int index = sc.nextInt();
            sc.nextLine();
            
            if(index < 1 || index > pendentes.size()){
                System.out.println("Indice invalido!!");
                return;
            }

            Tarefa tarefa = pendentes.get(index - 1);
            tarefa.setConcluida(true);

            System.out.println(
                "A "+tarefa.getTitulo()+
                " foi concluida com sucesso!"
            );
        }
        catch(InputMismatchException e){
            System.out.println("*Digite somente numeros*");
            sc.nextLine();
            
        }    
    }
}
