package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
    
    public void alterar(Contato contato) {
        
        try {
            String sql = "UPDATE TB_CONTATO "
                + " SET NM_CONTATO = ?, DT_NASCIMENTO = ?, VL_TELEFONE = ?, "
                + " VL_EMAIL = ?, VL_SEXO = ? WHERE ID_CONTATO = ?";

            PreparedStatement p;            
            p = this.conexao.prepareStatement(sql);
            p.setString(1, contato.getNome());
            p.setDate(2, new java.sql.Date(contato.getDtNascimento().getTime()));
            p.setString(3, contato.getTelefone());
            p.setString(4, contato.getEmail());
            p.setString(5, contato.getSexo());
            p.setString(6, Long.toString(contato.getId()));
            
            p.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    @Override
    public List<Contato> listarContatos() {

        List<Contato> contatos = new ArrayList<Contato>();
        
        String sql = "SELECT * FROM TB_CONTATO";
        
        try{
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Contato contato = new Contato();
                
                Long id = rs.getLong("ID_CONTATO");
                String nome = rs.getString("NM_CONTATO");
                Date nascimento = rs.getDate("DT_NASCIMENTO");
                String email = rs.getString("VL_EMAIL");
                String telefone = rs.getString("VL_TELEFONE");
                String sexo = rs.getString("VL_SEXO");
                Date cadastro = rs.getDate("DT_CADASTRO");
                
                if(sexo.equals("1")){
                    sexo="Masculino";
                }else{
                    sexo="Feminino";
                }
                
                contato.setId(id);
                contato.setNome(nome);
                contato.setDtNascimento(nascimento);
                contato.setEmail(email);
                contato.setTelefone(telefone);
                contato.setSexo(sexo);
                contato.setDtCadastro(cadastro);
                
                contatos.add(contato);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return contatos;
    }
    
   public Contato selecionar(Long id){
       
        Contato contato = new Contato();
        ConexaoBD conn = new ConexaoBD();
       
        String sql = "SELECT * FROM TB_CONTATO WHERE ID_CONTATO= "+id;
        
        try{
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
                contato.setId(id);
                contato.setNome(rs.getString("NM_CONTATO"));
                contato.setDtNascimento(rs.getDate("DT_NASCIMENTO"));
                contato.setEmail(rs.getString("VL_EMAIL"));
                contato.setTelefone(rs.getString("VL_TELEFONE"));
                contato.setSexo(rs.getString("VL_SEXO")); 
                contato.setDtCadastro(rs.getDate("DT_CADASTRO"));
        }catch(Exception e){
            e.printStackTrace();
        }

        return contato;

    }       
    
    public Contato Remove(Long id){

        String sql = "DELETE FROM TB_CONTATO WHERE ID_CONTATO=?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setLong(1,id);

            p.execute();

        } catch (SQLException e) {            
            e.printStackTrace();
        }
        return null;

    }   
}
