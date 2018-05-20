<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.mycompany.lunakea.common.ViewConst"%>
<%@include file="includes/header.jsp" %>

<div class="header">
    <img src="<c:url value="/images/logo-lunakea.png" />" alt="" />
    <h2>BIENVENUE !</h2>
    Let's practice
</div>
<div class="row">
    <div class="column full" style="background-color:#bbb;">
        <p align="center">
        <a class="button" style="color:#000000" title="LANCER UNE RECHERCHE" href="<c:url value="<%=(ViewConst.SEARCH_PRODUCT)%>" />">COMMENCER</a>
        </p>
    </div>
</div>
<div class="footer">
    <p>Ceci est un exercice effectué par Laurie Coquillat pour le processus de recrutement de Lunatech France basé à Chessy (77)</p>
</div>

</body>