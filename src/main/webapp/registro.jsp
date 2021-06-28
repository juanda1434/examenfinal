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

                        <c:if test="${user != null}">
                            <form action="editar" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insertar" method="post">
                        </c:if>

                        <caption>
                            <h2>                            
                              
                                    Agregar nuevo usuario
                               
                            </h2>
                        </caption>

                       
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    

                        <fieldset class="form-group">
                            <label>Usuario</label> <input type="text" value="" class="form-control" name="usuario" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Contrasenia</label> <input type="text" value="" class="form-control" name="contrasenia">
                        </fieldset>

						 <fieldset class="form-group">
                            <select name="vacuna">
                                <%
                               	List<Rol> roles = (List<Rol>)request.getAttribute("roles");
                                if(roles==null){
                                	response.sendRedirect("/");
                                }
                                for(Rol rol : roles){
                                %>
                                <option value="<%=rol.getId()%>"><%=rol.getDescription() %></option>
                                <%
                                }
                                %>
                                </select>
                            
                            
                        </fieldset>
						
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
</html>