/**
 *
 * @author Lucas Oliveira
 */

package view;

import java.util.Scanner;
import java.util.InputMismatchException;
import controller.TaskManager;
import exception.ExceptionValidation;
import model.BaseTarefa;
import java.util.List;
import util.Console;
/**
 *
 * @author lucas
 */
public class TaskView{
    private final Scanner sc;
    private final TaskManager manager;
    
    public TaskView(TaskManager manager, Scanner sc){
        this.manager = manager;
        this.sc = sc;
    }
    
    public void adicionarTarefa(){
        OUTER:
        while(true){
            System.out.println("\n1. Criar tarefa");
            System.out.println("2. Sair");
            try{
                int opcao = sc.nextInt();
                sc.nextLine();
                
                switch(opcao){
                    case 1:
                        System.out.print("Titulo: ");
                        String titulo = sc.nextLine();

                        System.out.print("Descricao: ");
                        String descricao = sc.nextLine();

                        System.out.print("Prioridade: ");
                        String prioridade = sc.nextLine();
                        try{
                            manager.adicionarTarefa(
                                titulo,
                                descricao,
                                prioridade
                            );
                        }
                        catch(ExceptionValidation e){
                            System.out.println(e.getMessage());
                        }
                        
                        System.out.println("Tarefa adicionada com sucesso!");
                    case 2:
                        Console.clear();
                        break OUTER;
                    default:
                        System.out.println("Erro ao criar a tarefa");
                        break;
                }
            }
            catch(IllegalArgumentException | InputMismatchException e){
                System.out.println(
                        """
                        *Nao e permitido uma tarefa somente com numeros! *
                        letras e numeros sao permitidas"""
                );
                
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
                
                switch (opcao){
                    case 1:
                        List<BaseTarefa> lista = manager.listarTarefas();
                        
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
                        Console.clear();
                        
                        BaseTarefa tarefa = lista.get(indice);
                        System.out.println("\n===== INFORMACOES DA TAREFA =====");
                        System.out.println(tarefa.toString());
                        break;
                    case 2:
                        Console.clear();
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
    
        while(true){
            System.out.println("\n1. Remover tarefa");
            System.out.println("2. Sair");
            
            try{
                int opcao = sc.nextInt();

                if(opcao == 1){
                    List<BaseTarefa> lista = manager.listarTarefas();
                    if(!lista.isEmpty()){
                        
                        System.out.println("\nSelecione uma tarefa que deseja remover: ");
                        
                        for(int i = 0; i < lista.size(); i++){
                            System.out.println((i + 1) + " - " + lista.get(i).getTitulo());

                        }
                        
                        int indice = sc.nextInt();
                        if(indice < 1 || indice > lista.size()){
                            return;
                        } 
                        
                        
                        boolean removeu = manager.removerTarefa(indice - 1);
                        
                        if(removeu){
                            System.out.println("Tarefa removida!");
                        }
                        else{
                            System.out.println("Indice invalido!");
                        }
                        return;

                    }
                    else{
                        Console.clear();
                        System.out.println("\nLista vazia!!");
                        break;
                    }
                }
                else if(opcao == 2){
                    Console.clear();
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
        List<BaseTarefa> lista = manager.listarTarefas();
        
        if(lista.isEmpty()){
            Console.clear();
            System.out.println("Lista vazia!!");
            return;
        }
        Console.clear();
        
        try{
            List<BaseTarefa> pendentes = manager.listarPendentes();
            if(!pendentes.isEmpty()){
                System.out.println("\n===== Tarefas nao concluidas =====");

                for(int i = 0; i < pendentes.size(); i++){
                    System.out.println(
                            (i + 1) + " - "+
                            pendentes.get(i).getTitulo()
                        );
                }
            }
            else{
                System.out.println("Nenhuma tarefa pendente");
                return;
            }
            
            System.out.println("Escolha uma tarefa para ser concluida: ");
            int indice = sc.nextInt();
            sc.nextLine();
            
            if(indice < 1 || indice > pendentes.size()){
                System.out.println("Indice invalido!!");
                return;
            }

            boolean concluiu = manager.concluirTarefa(indice - 1);
            
        
            Console.clear();
            if(concluiu){
                System.out.println("Tarefa concluida com sucesso!");
            }    
        
        }
        catch(InputMismatchException e){
            System.out.println("*Digite somente numeros*");
            sc.nextLine();
            
        }
    }
    
    
    
    public void iniciar(){
        while(true){
            
            System.out.println("===== TASK MANAGER =====");
            System.out.println("1. Criar tarefas");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluida");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");

            try{
                int select = sc.nextInt();
                
                switch(select){
                    case 1:
                        adicionarTarefa();
                        break;
                    case 2: 
                        listarTarefas();
                        break;
                    case 3:
                        concluirTarefa();
                        break;
                    case 4:
                        removerTarefa();
                        break;
                    case 5:
                        System.out.println("Encerrando...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opcao invalida!!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Digite somente numeros.");
                sc.nextLine();

            }
        }
    }
}
