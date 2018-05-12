<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>agregar productos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/producto.htm" />">Listado de productos</a></li>
                <li class="active"> Editar </li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar</div>
                
                    
                    <form:form method="post" commandName="productos">
                        <h1>rellene el formulario</h1>
                            
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        
                        <p>
                            <form:label path="precio">Precio</form:label>
                            <form:input path="precio" cssClass="form-control" />
                        </p>
                        
                        <p>
                            <form:label path="nombre">Nombre</form:label>
                            <form:input path="nombre" cssClass="form-control" />
                        </p>
                       
                        <p>
                            <form:label path="descripcion">Descripcion</form:label>
                            <form:input path="descripcion" cssClass="form-control" />
                        </p>
                        <hr />
                        <input type="submit" value="Enviar" class="btn btn-danger" />
                    </form:form>
                    
                
            </div>    
        </div>
    </body>
</html>