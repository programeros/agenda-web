package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;

public class JDBCContatoDAO implements ContatoDAO{
    
    Connection conexao;
    
    public JDBCContatoDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public void inserir(Contato contato) {
        String sql = "INSERT INTO TB_CONTATO "
            + "(NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, VL_SEXO,"
            + " DT_CADASTRO) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setString(1, contato.getNome());
            p.setDate(2, new java.sql.Date(contato.getDtNascimento().getTime()));
            p.setString(3, contato.getTelefone());
            p.setString(4, contato.getEmail());
            p.setString(5, contato.getSexo());
            p.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public List<Contato> listarTodos() {
        return null;
    }
    
}
