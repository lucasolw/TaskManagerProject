package database;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args){
        try {
            Connection conexao = ConexaoDB.conectar();
            System.out.println("Conexao realizada com sucesso!!");
            conexao.close();
        }
        catch (SQLException e){
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
