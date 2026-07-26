/**
 *
 * @author Lucas Oliveira
 */

package controller;
import exception.ExceptionValidation;
import java.util.ArrayList;
import java.util.List;
import model.BaseTarefa;
import model.TarefaPrioritaria;

public class TaskManager{
    private final ArrayList<BaseTarefa> lista = new ArrayList<>();
    
    public TaskManager(){}
    
    public void adicionarTarefa(
            String titulo,
            String descricao,
            String prioridade) throws ExceptionValidation{
        
        if(titulo.matches("\\d+")){
            throw new IllegalArgumentException(
                    "O titulo nao pode conter somente numeros"
            );
        }
        
        
        TarefaPrioritaria tarefa = new TarefaPrioritaria();
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setPrioridade(prioridade);

        lista.add(tarefa);
    }
    
    public List<BaseTarefa> listarTarefas(){
        return lista;
        
    }
    
    public BaseTarefa buscarTarefa(int indice){
        if(indice < 0 || indice >= lista.size()){
            return null;
            
        }
        
        return lista.get(indice);
    }
    
    public List<BaseTarefa> listarPendentes(){
        
        List<BaseTarefa> pendentes = new ArrayList<>();
        
        
        for(BaseTarefa tarefa : lista){
            if(!tarefa.getConcluida()){
                pendentes.add(tarefa);
            }
        }
        
        return pendentes;
    }
    
    public boolean concluirTarefa(int indice){
        List<BaseTarefa> pendentes = listarPendentes();
        
        if(indice < 0 || indice >= pendentes.size()){
            return false;
            
        }
        pendentes.get(indice).setConcluida(true);
        
        return true;
    }
    
    public boolean removerTarefa(int indice){
        if(indice < 0 || indice >= lista.size()){
            return false;
            
        }
        lista.remove(indice);

        return true;
        
    }
}
