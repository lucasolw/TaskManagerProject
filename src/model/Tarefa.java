package model;

import exception.ExceptionValidation;

/**
 *
 * @author Lucas Oliveira
 */
public class Tarefa extends BaseTarefa{
    
    public Tarefa(){}
    
    public Tarefa(String titulo, String descricao) throws ExceptionValidation{
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        
    }

    
}
