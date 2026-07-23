/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Lucas Oliveira
 */
public class Tarefa extends BaseTarefa{
    
    public Tarefa(){}
    
    public Tarefa(String titulo, String descricao){
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        
    }

    @Override
    public String toString(){
        return "Titulo: "+getTitulo()+
               "\nDescricao: "+getDescricao()+
               "\nConcluida: "+(getConcluida() ? "Sim" : "Nao");
    }
}
