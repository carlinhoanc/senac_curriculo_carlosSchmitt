
<%-- 
    Document   : calculadora
    Created on : 04/11/2015, 08:40:35
    Author     : CarlosRoberto
--%>

<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <script src="${pageContext.request.contextPath}/resource/js/jquery.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/paginas/testes/calc.js"></script>
        
        <title>JSP Calculadora</title>
    </head>
    <body>

        <div>

            <br><br>
            <input id="inputResult" disabled=""></input>

            <br><br>
            <button class="btnNumber" value="1">1</button>
            <button class="btnNumber" value="2">2</button>
            <button class="btnNumber" value="3">3</button>
            <button class="btnNumber" value="4">4</button>
            <button class="btnNumber" value="5">5</button>

            <br/><br/>
            <button class="btnNumber" value="6">6</button>
            <button class="btnNumber" value="7">7</button>
            <button class="btnNumber" value="8">8</button>
            <button class="btnNumber" value="9">9</button>
            <button class="btnNumber" value="0">0</button>

            <br/><br/>
            <button class="btnOperacao" value="+">+</button>
            <button class="btnOperacao" value="-"> - </button>
            <button class="btnOperacao" value="*"> * </button>
            <button class="btnOperacao" value="/"> / </button>
            <button class="btnOperacao" value="(">(</button>

            <br/><br/>
            <button class="btnOperacao" value=")">)</button>
            <button class="btnResult" value="=">=</button>
            <button id="btnLimpar" class="btnOperacao" value="LIMPAR">LIMPAR</button>

            <br><br>
            <button class="btnSalvar" value="SALVAR">SALVAR</button>
            <button class="btnListar" value="LISTAR">LISTAR VALORES</button>
            <button class="btnApagar" value="APAGAR">APAGAR VALORES</button>

            <br><br><br>

            <table id="tableResults" class="tabela" border="0">
                <tr>
                    <td>
                        Chave
                    </td>
                    <td>
                        Valor
                    </td>
                </tr>
            </table>

        </div>

        <style>
            button{font-size: 23px;padding: 11px 17px;width: auto;line-height: 1em;}
            .btnListar, .btnSalvar, .btnApagar {
                font-size: 15px;
                padding: 10px 9px;
                width: 160px;
            }
            #btnLimpar {
                font-size: 15px;
                padding: 15px 17px;
                position: relative;
                top: -4px;
                width: 120px;
            }
            #inputResult{text-align: center;padding: 10px; width: 400px;}
            table.tabela tbody tr:nth-child(odd){background-color: #E9E9E9;}
        </style>

    </body>
</html>
