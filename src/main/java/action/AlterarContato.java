
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

/**
 *
 * @author willian.carvalho
 */
public class AlterarContato extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String nascimento = request.getParameter("nascimento");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String sexo = request.getParameter("sexo");
		
            if(sexo.trim().equals("Masculino")){
                sexo = "1";
            }else{
                sexo = "2";
            }
            
            request.setAttribute("id", id);
            request.setAttribute("nome", nome);
            request.setAttribute("nascimento", nascimento);
            request.setAttribute("email", email);
            request.setAttribute("telefone", telefone);
            request.setAttribute("sexo", sexo);
            
            request.getRequestDispatcher("alterarContato.jsp").forward(request, response);       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String nascimento = request.getParameter("nascimento");
        String email = request.getParameter("email"); 
        String telefone =  request.getParameter("telefone");
        String sexo = request.getParameter("sexo");

        Date date=null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setDtNascimento(date);
        contato.setTelefone(telefone);
        contato.setEmail(email);
        contato.setSexo(sexo);
        
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();

        JDBCContatoDAO dao = new JDBCContatoDAO(conexao);
        dao.alterar(contato);
        
        conn.fecharConexao();
        
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
