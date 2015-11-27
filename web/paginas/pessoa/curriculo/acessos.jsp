<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="height: 50px"></div>
<div class="row">
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Nome") || cookie.getName().equals("Data") ) {
                out.println("<b>" + cookie.getName() + "</b>:  " + cookie.getValue() + "<br/>");
            }

        }
    %>
</div>

