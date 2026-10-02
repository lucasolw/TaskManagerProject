package DAO;

import database.ConexaoDB;
import model.TarefaPrioritaria;
import model.Tarefa;

import java.sql.*;


public class TarefaDAO {
    public void inserirTarefaDB(Tarefa tarefa){
        String sql = "INSERT INTO tarefas (titulo, descricao, concluida, prioridade)" +
                "VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoDB.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)
        ){
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setBoolean(3, tarefa.getConcluida());

            if(tarefa instanceof TarefaPrioritaria){
                TarefaPrioritaria tarefaPrioritaria = (TarefaPrioritaria) tarefa;
                stmt.setString(4, tarefaPrioritaria.getPrioridade());

            }
            else {
                stmt.setNull(4, Types.VARCHAR);

            }
            stmt.executeUpdate();

            System.out.println("Tarefa salva no Banco com sucesso!");
        }
        catch (SQLException e){
            System.out.println("Erro ao inserir a tarefa no banco: " + e.getMessage()   );
        }
    }


    public void listarTarefaDB(String titulo){
        //Busca todas as colunas para achar titulo
        String sql = "SELECT id, titulo FROM tarefas WHERE titulo = ?";


        try(Connection conexao = ConexaoDB.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)
        ){
            //Define parametro usando 'titulo' recebido
            stmt.setString(1, titulo);

            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("titulo");

                    System.out.println("ID: " + id +
                            ", Titulo: " + nome

                    );
                }
            }

        }
        catch (SQLException e){
            System.out.println("Erro ao listar tarefa no banco de dados: " + e.getMessage());
        }
    }
}
