package action;

import dao.ConexaoBD;
import dao.JDBCContatoDAO;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;

public class AdicionarContato extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Teste");

        String nome = request.getParameter("nome");
        String nascimento = request.getParameter("nascimento");
        String email = request.getParameter("email");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");

        Date date=null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
            
        Contato novoContato = new Contato();
        novoContato.setNome(nome);
        novoContato.setDtNascimento(date);
        novoContato.setEmail(email);
        novoContato.setSexo(sexo);
        novoContato.setTelefone(telefone);

        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        JDBCContatoDAO dao = new JDBCContatoDAO(conexao);
        dao.inserir(novoContato);
        
        conn.fecharConexao();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
