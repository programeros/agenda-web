<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="model.Contato"%>
<html>
    <head>
        <title>Agenda de Contatos</title>
    </head>
    <body>
        <h1>Adiciona Contato</h1>
        <hr />
        <form action ="InserirContato" method="post">
            Nome: <input type="text" name="nome" /><br />
            Data Nascimento: <input type="text" name="nascimento" /><br /> 
            E-mail: <input type="text" name="email" /><br />
            Sexo: 
                <Select name = "sexo">
                    <option value="1" selected>Masculino</option>
                    <option value="2">Feminino</option>
                </Select><br/>
            Telefone: <input type="text" name="telefone" /><br />

            <input type="submit" value="Gravar" />
        </form>
    </body>
</html>
