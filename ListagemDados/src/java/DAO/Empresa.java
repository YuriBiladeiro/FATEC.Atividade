package DAO;

import Connection.Conexao;
import VO.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Empresa {   
    public ArrayList<Produto> buscarProdutos() {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "select id, nome, valor from produtos";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ArrayList<Produto> lista = new ArrayList<>();
                while (rs.next()) {
                    //setar os valores dentro de um objeto (Produto)
                    //adicionar este objeto a uma list
                    Produto p = new Produto();      
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setValor(rs.getDouble("valor"));
                    lista.add(p);
                }
                con.close();
                return lista;
            }else{
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados: " + erro.getMessage());
            return null;
        }
    }
    
    public boolean excluir(int id){
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "delete from produtos where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);          
                if(ps.executeUpdate()!=0){
                    con.close();
                    return true;
                }else{
                    return false;
                }               
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public Produto localizarRegistro(int id) {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "select id, nome, valor from produtos where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                rs.next();
                //setar os valores dentro de um objeto (Produto)
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                con.close();
                return p;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados para alteração: " + erro.getMessage());
            return null;
        }
    }

    public boolean alterar(Produto p) {
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "update produtos set nome=?, valor=? where id=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getNome());
                ps.setDouble(2, p.getValor());
                ps.setInt(3, p.getId());
                if (ps.executeUpdate() != 0) {
                    con.close();
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }
}