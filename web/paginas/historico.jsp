<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <%@ page session="true" %>
    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <%@ include file="../../includes/heard.jsp" %>
        <title>Histórico de trabalhos</title>
        <script>
            function Listar() {
                var tamanho = localStorage.length;
                var chave = '';
                var valor = '';

                if (document.getElementById("tableResults").rows.length > 1) {
                    for (var t = document.getElementById("tableResults").rows.length; t > 1; t--) {
                        document.getElementById("tableResults").deleteRow(1);
                    }
                }

                var numOfCols = document.getElementById("tableResults").rows[document.getElementById("tableResults").rows.length - 1].cells.length;
                for (var c = 0; c < tamanho; c++) {
                    chave = localStorage.key(c);
                    valor = localStorage.getItem(chave);

                    var newRow = document.getElementById("tableResults").insertRow(document.getElementById("tableResults").rows.length);
                    for (var j = 0; j < numOfCols; j++) {
                        newCell = newRow.insertCell(j);
                        if (j === 0) {
                            newCell.innerHTML = chave.toUpperCase();
                        } else if (j === 1) {
                            newCell.innerHTML = valor;
                        }
                    }
                }

            }
            ;
        </script>
    </head>
    <body onload="Listar()">
        <%@ include file="../../includes/topo.jsp" %>
        <div class="container theme-showcase" style="padding-top: 70px" role="main">
            <div>
                <table id="tableResults" class="table table-striped table-hover">
                    <tr>
                        <td>
                            ID
                        </td>
                        <td>
                            Valores
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <style>
            table#tableResults tr:last-child{display: none}
            table#tableResults tr td{padding: 5px;border-bottom: 1px solid #ccc;}
        </style>
        <%@ include file="../../includes/footer.jsp" %>
    </body>
</html>
