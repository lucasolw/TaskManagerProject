/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lucas Oliveira
 */
public class TarefaPrioritaria extends Tarefa{
    private String prioridade;

    public TarefaPrioritaria(){
        
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "\nPrioridade: "+prioridade;
    }
}
