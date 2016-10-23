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
                <Select name = "sexo" value="${sexo}">
                    <option value="1" >Masculino</option>
                    <option value="2">Feminino</option>
                </Select><br/>
            Telefone: <input type="text" name="telefone" value="${telefone}"/><br />

            <input type="submit" value="Gravar"/>
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>
    </body>
</html>
