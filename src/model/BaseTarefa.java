/**
 *
 * @author Lucas Oliveira
 */

package model;

import exception.ExceptionValidation;


public abstract class BaseTarefa {
    private String titulo;
    private String descricao;
    private boolean concluida;
    
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getConcluida() {
        return concluida;
    }

    public void setTitulo(String titulo) throws ExceptionValidation{
        
        if (titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException(
                "O título não pode estar vazio."
            );
        }

        if (titulo.matches("\\d+")){
            throw new IllegalArgumentException(
                "O titulo nao pode conter somente numeros."
            );
        }

        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    
    @Override
    public String toString(){
        return "Titulo: "+getTitulo()+
               "\nDescricao: "+getDescricao()+
               "\nConcluida: "+(getConcluida() ? "Sim" : "Nao");
    }
}
