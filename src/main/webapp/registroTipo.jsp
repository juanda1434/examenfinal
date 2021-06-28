<%@page import="java.util.List"%>
<%@page import="com.edu.ufps.examenfinal.dto.Rol"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Registro usuarios </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listar" class="nav-link">Users</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                   
                            <form action="<%=request.getContextPath()%>/registroTipo/enviar" method="post">
                       
                       

                        <caption>
                            <h2>                            
                              
                                    Agregar nuevo usuario
                               
                            </h2>
                        </caption>

                       
                    

                        <fieldset class="form-group">
                            <label>id</label> <input type="text" value="" class="form-control" name="id" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>descripcion</label> <input type="text" value="" class="form-control" name="descripcion">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>driver</label> <input type="text" value="" class="form-control" name="driver">
                        </fieldset>

						<fieldset class="form-group">
                            <label>adicional</label> <input type="text" value="" class="form-control" name="adicional">
                        </fieldset>
                        <button type="submit" class="btn btn-success">registrar</button>
                        </form>
                       <%if(request.getParameter("registro")!=null){
                    	   
                    	   out.append("<h2>"+request.getParameter("registro")+"</h2>");
                       }

%>
                    </div>
                </div>
            </div>
        </body>
</html>