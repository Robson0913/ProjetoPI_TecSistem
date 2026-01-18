package model;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection con = Conexao.getConnection();
            if (con != null) {
                System.out.println("Conexão com o banco tecsistem feita com sucesso!");
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
