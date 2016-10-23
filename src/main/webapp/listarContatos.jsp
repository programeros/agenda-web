<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<%@page import="model.Contato"%>
<%@page import="java.util.List"%>
<%@page import="dao.JDBCContatoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.ConexaoBD"%>
<html>
    <head>
        <title>Agenda de Contatos</title>
    </head>
    <body>
        <h1>Lista de Contatos</h1>
        <hr />
        
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();
            
            JDBCContatoDAO dao = new JDBCContatoDAO(conexao);
            
            List<Contato> contatos = dao.listarContatos();
            
            conn.fecharConexao();

        %>
        
        <table id="tblContatos" border="2" cellPadding ="10">         
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Sexo</th>
                <th>DT. Nascimento</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>DT. Cadastro</th>                                    
            </tr>
            
            <% for(Contato c:contatos){
                String stData = new SimpleDateFormat("dd/MM/yyyy").format(c.getDtNascimento());
                String stCadastro = new SimpleDateFormat("dd/MM/yyyy").format(c.getDtCadastro());
            %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getNome() %></td>
                <td><%= c.getSexo() %></td>
                <td><%= stData %></td>
                <td><%= c.getEmail() %></td>
                <td><%= c.getTelefone() %></td>
                <td><%= stCadastro %></td>                                  
            </tr>              
            <%} %>

        </table>     
    </body>
</html>
