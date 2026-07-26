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
