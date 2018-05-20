<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Total!</h1>
    
            <table cellspacing="0" cellpadding="0" border="1" bgcolor="green" bordercolor="blue" width="80%" align="center">
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                    </tr>
                </c:forEach>        
            </table>

    </body>
</html>
