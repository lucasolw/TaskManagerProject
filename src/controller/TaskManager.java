/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import model.Tarefa;
import model.TarefaPrioritaria;
/**
 *
 * @author Lucas Oliveira
 */
public class TaskManager{
    private final ArrayList<Tarefa> lista = new ArrayList<>();
    private final Scanner sc;
    
    public TaskManager(Scanner sc){
        this.sc = sc;
        
    }
    
    public static void clearConsole() { //Só funciona .jar executado no CMD
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } 
            else {
                new ProcessBuilder("clear")
                    .inheritIO()
                    .start()
                    .waitFor();
            }
        } 
        catch (IOException | InterruptedException e) {
            System.out.println("Não foi possível limpar o console.");
        }
    }
    
    public void listarTarefas(){
        clearConsole();
        
        OUTER:
        while (true) {
            System.out.println("\n1. Listar tarefas");
            System.out.println("2. Sair");
            try {
                int opcao = sc.nextInt();
                
                switch (opcao) {
                    case 1:
                        if(lista.isEmpty()){
                            System.out.println("Lista vazia!!");
                            continue;
                        }
                        System.out.println("\nSelecione uma das tarefa:");
                        
                        for(int i = 0; i < lista.size(); i++){
                            System.out.println((i + 1) + " - " + lista.get(i).getTitulo());

                        }
                        int index = sc.nextInt();
                        
                        if(index < 1 || index > lista.size()){
                            System.out.println("\nIndice invalido!!");
                            return;
                        }
                        
                        int indice = index - 1;
                        clearConsole();
                        
                        Tarefa tarefa = lista.get(indice);
                        System.out.println("\n===== INFORMACOES DA TAREFA =====");
                        System.out.println(tarefa.toString());
                        break;
                    case 2:
                        clearConsole();
                        break OUTER;
                    default:
                        System.out.println("\nOpcao invalida!");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("*Digite somente numeros*");
                sc.nextLine();
            }
        }
    }

    public void removerTarefa(){
        clearConsole();
        while(true){
            System.out.println("\n1. Remover tarefa");
            System.out.println("2. Sair");
            
            try{
                int opcao = sc.nextInt();

                if(opcao == 1){
                    if(!lista.isEmpty()){
                        
                        System.out.println("\nSelecione uma tarefa que deseja remover: ");

                        for(int i = 0; i < lista.size(); i++){
                            System.out.println((i + 1) + " - " + lista.get(i).getTitulo());

                        }
                        int index = sc.nextInt();

                        if(index < 1 || index > lista.size()){
                            System.out.println("Indice invalido!");
                            continue;

                        } 
                        lista.remove(index - 1);
                        clearConsole();
                        System.out.println("\nTarefa removida com sucesso!!");

                    }
                    else{
                        clearConsole();
                        System.out.println("\nLista vazia!!");
                        break;
                    }
                }
                else if(opcao == 2){
                    clearConsole();
                    break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("*Digite somente numeros*");
                sc.nextLine();
            }
        }
    }
    
    public void adicionarTarefa(){
        clearConsole();
        while(true){
            System.out.println("\n1. Criar tarefa");
            System.out.println("2. Sair");
            try{
                int opcao = sc.nextInt();
                sc.nextLine();
                
                if(opcao == 1){
                    try{
                        TarefaPrioritaria tarefa = new TarefaPrioritaria();

                        System.out.print("Titulo: ");
                        tarefa.setTitulo(sc.nextLine());

                        System.out.print("Descricao: ");
                        tarefa.setDescricao(sc.nextLine());

                        System.out.print("Prioridade: ");
                        tarefa.setPrioridade(sc.nextLine());

                        lista.add(tarefa);
                        clearConsole();
                        System.out.println("\nTarefa adicionada com sucesso!!");

                    }
                    catch(Exception e){
                        System.out.println("Erro: "+e.getMessage());
                    }

                }
                else if(opcao == 2){
                    clearConsole();
                    break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("*Digite somente numeros*");
                sc.nextLine();
            }
        }
    }
    public void concluirTarefa(){
        ArrayList<Tarefa> pendentes = new ArrayList<>();
        
        if(lista.isEmpty()){
            clearConsole();
            System.out.println("Lista vazia!!");
            return;
        }
        clearConsole();
        System.out.println("\n===== Tarefas nao concluidas =====");
        
        for(int i = 0; i < lista.size(); i++){
            if(!lista.get(i).getConcluida()){
                pendentes.add(lista.get(i));
                
                System.out.println(
                    pendentes.size() + " - "+
                    lista.get(i).getTitulo()
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
            clearConsole();
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
