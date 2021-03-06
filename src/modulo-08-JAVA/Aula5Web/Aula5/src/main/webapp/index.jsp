<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form id="pessoa-form">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input id="input-nome" name="nome" class="form-control" placeholder="Nome">
                </div>
                <div class="form-group">
                    <label for="idade">Idade</label>
                    <input id="input-idade" name="idade" class="form-control" placeholder="Idade">
                </div>
                <div class="form-group">
                    <label for="nome">Sexo:</label>
                    <input class="input-sexo" type="radio" name="sexo" value="masculino" checked> Masculino
                    <input class="input-sexo" type="radio" name="sexo" value="feminino"> Feminino
                    <input class="input-sexo" type="radio" name="sexo" value="outro"> Outros
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>

            <div id="tabela-pessoas">
            </div>
        </div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                $('#pessoa-form').submit(function ()
                {
                    $.ajax({
                        type: "post",
                        url: "/pessoa",
                        data: { nome: $('#input-nome').val(), sexo: $('.input-sexo').val(), idade: $('#input-idade').val() },
                        success: function (res) {
                            $.ajax({
                                type: "get",
                                url: "/pessoa",
                                success: function (res){
                                    var tabela = $('#tabela-pessoas');
                                    tabela.empty();
                                    tabela.append(response);
                                }
                            });
                        }
                    });
                });
            });
        </script>
    </body>
</html>
