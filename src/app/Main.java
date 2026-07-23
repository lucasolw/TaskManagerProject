/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;
import java.util.Scanner;
import java.util.InputMismatchException;
import controller.TaskManager;
/**
 *
 * @author Lucas Oliveira
 */

public class Main{
    public static void selectionScreen(){
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager(sc);
        
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
                        tm.adicionarTarefa();
                        break;
                    case 2: 
                        tm.listarTarefas();
                        break;
                    case 3:
                        tm.concluirTarefa();
                        break;
                    case 4:
                        tm.removerTarefa();
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
    
    
    public static void main(String[] args) {
        selectionScreen();
        
    }
}
