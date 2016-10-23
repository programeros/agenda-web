<!DOCTYPE html>
<%@page import="model.Contato"%>
<%@page import="java.util.List"%>
<%@page import="dao.JDBCContatoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.ConexaoBD"%>
<%@page import="java.text.SimpleDateFormat"%>

<html>
    <head>
        <title>Agenda de Contatos</title>
    </head>
    <body>
        <h1>Alterar Contato</h1>
        <hr />
        
        <form action ="AlterarContato" method="post">
            ID:  <input type="text" name="id" value="${id}" readonly="true"/><br />           
            Nome: <input type="text" name="nome" value="${nome}"/><br />
            Data Nascimento: <input type="text" name="nascimento" value="${nascimento}"/><br /> 
            E-mail: <input type="text" name="email" value="${email}"<br />
            Sexo:         
                <Select name="sexo" id="sexo" value="${sexo}".attr("selected",true)>
                    <option value="Masculino" >Masculino</option>
                    <option value="Feminino">Feminino</option>
                </Select> 
            
                <script type="text/javascript">
                    $(document).ready(function() {
                      // valor que desejo localizar
                      var value = trim("${sexo}");

                      // Usa-se o método $.find para buscar a
                      // opção pelo atributo value e o seleciona
                      $('#sexo').find('[value="' + value + '"]').attr('selected', true);
                </script>
                <br/>
                
            Telefone: <input type="text" name="telefone" value="${telefone}"/><br />

            <input type="submit" value="Gravar"/>
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </body>
</html>
