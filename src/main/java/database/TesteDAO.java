package database;

import DAO.TarefaDAO;
import model.Tarefa;
import model.TarefaPrioritaria;

public class TesteDAO {
    public static void main(String[] args){
        TarefaDAO dao = new TarefaDAO();

        Tarefa tarefa = new Tarefa(
            "Estudar",
            "Aprender algebra linear"
        );
        dao.inserirTarefaDB(tarefa);

        TarefaPrioritaria tarefaPrioritaria = new TarefaPrioritaria(
                "Trabalho da facul",
                "implementar grafo complementar",
                false,
                "Alta"

        );

        dao.inserirTarefaDB(tarefaPrioritaria);
        dao.listarTarefaDB("Estudar");
    }
}
