package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/taskmanager";
    private static final String USUARIO = "root";
    //SUBSTITUA EM "MINHA_SENHA" A SENHA USADA PARA ACESSAR O BANCO DE DADOS:
    private static final String SENHA = "MINHA_SENHA";



    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
        );
    }



}
