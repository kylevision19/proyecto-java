<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>PRODUCTOS</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>lista de productos</h1>
                <p>
                    <a href="<c:url value="add.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>precio</th>
                            <th>nombre</th>
                            <th>descripcion</th>
                            <th>acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.cod_producto}" /></td>
                                <td><c:out value="${dato.precio}" /></td>
                                <td><c:out value="${dato.nombre}" /></td>
                                <td><c:out value="${dato.descripcion}" /></td>
                                <td>
                                    <a href="<c:url value="edit.htm?cod_producto=${dato.cod_producto}" />" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="delete.htm?cod_producto=${dato.cod_producto}" />" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
