package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */



import Conexao.ConectBD;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import models.Produto;



public class Dao {
    
    
    private ConectBD nova_Conexao = new ConectBD();
    private Connection conn;
    
    String nome;
    int valor;
    String status;
    
    
    
    public boolean cadastra_Produto(Produto Produto) {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO cenaflix.produtos VALUES (?,?,?,?)";

        try {

            stmt = nova_Conexao.conectBD().prepareStatement(sql);

            stmt.setNull(1, 0);
            stmt.setString(2, nome = Produto.getNome());
            stmt.setInt(3, valor = Produto.getValor());
            stmt.setString(4, status = Produto.getStatus());
            
            stmt.execute();

            return true;

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Dados!\n"
                    + "Por favor, verificar os dados da sua ideia e tentar Novamente.");
            System.out.println(sqle.getMessage());

            return false;
        } finally {
            System.out.println(stmt);
            nova_Conexao.desconectBD();
        }
    }
    
    
}  


