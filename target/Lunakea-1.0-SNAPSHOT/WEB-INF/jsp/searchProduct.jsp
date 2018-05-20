<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>
<%@page import="com.mycompany.lunakea.common.ViewConst"%>
<%@include file="includes/header.jsp" %>

<c:set var="minKeywordsLength" value="3" />

<%--Haut de page--%>
<div class="header">
    <img src="<c:url value="/images/logo-lunakea.png" />" alt="" />
    <h2>EFFECTUER UNE RECHERCHE</h2>
</div>
<div class="row">
    <%--Colonne de gauche : liste de tous les produits récupérés par le webService--%>
    <div class="column side" style="background-color: #ccc;">
        <c:forEach items="${rProducts}" var="product">
            <div class="rconers2">
                ${product.name}
            </div>           
        </c:forEach>
    </div>
    <%--Colonne de droite : espace recherche et résultat--%>
    <div class="column middle" style="background-color:#bbb;">

        <%--Fonction Javascript de vérification de la saisie utilisateur--%>
        <script>
            function validateSearchInputLength() {
                //récupération du champs
                var keywordsInput = $("#keywords");
                //récupération de sa valeur
                var keywordsValue = $.trim(keywordsInput.val());
                //test de sa valeur
                if (keywordsValue.length >= ${minKeywordsLength}) {
                    dialogUtils.showWaiting("Recherche en cours", {modal: true});
                    return true;
                }
                dialogUtil.showInformation("Recherche invalide", "Le nombre de caractères est insuffisant pour effectuer la recherche", true);
                return false;
            }
        </script>

        <%--Espace de recherche--%>
        <form onsubmit="javascript: return validateSearchInputLength();" method="GET" action="<c:url value="<%= (ViewConst.SEARCH_PRODUCT)%>"/>">
            <div>Entrez le texte de recherche :</div>
            <input type="text" id="keywords" name="keywords" value="${keywords}" style="width: 400px;"/>
            <select name="attributeSearch" id="attributeSearch" style="width: 300px;">
                <option value="texte" <c:if test="${attributeSearch == 'nom ou description'}">Selected</c:if>>nom ou description</option>
                <option value="ean" <c:if test="${attributeSearch == 'numéro ean'}">Selected</c:if>>numéro ean</option>
                <option value="id" <c:if test="${attributeSearch == 'numéro id'}">Selected</c:if>>numéro id</option>
                </select>
                (${minKeywordsLength} caractères minimum)
            <input id="searchProduct" type="submit" class="buttonP"  style="background-color: #ffe718; width:77%;" value="RECHERCHER" />
        </form>
        <c:choose>
            <c:when test="${search}">
                <form method="GET" action="<c:url value="<%= (ViewConst.SEARCH_PRODUCT)%>"/>">
                    <p>Triez votre recherche</p>                   
                    <div>
                        <input type="radio" id="triChoice1"
                               name="choice" value="price">
                        <label for="triChoice1">Prix décroissant</label>

                        <input type="radio" id="triChoice2"
                               name="choice" value="assembled">
                        <label for="contactChoice2">Assemblé</label>
                    </div><BR>
                    <div>
                        <button class="buttonP" type="submit">ENVOYER</button>
                    </div><BR><BR>
                </form>
                <c:choose>
                    <c:when test="${not empty error}">
                        <div class="rcorners1">
                            <span>${error}</span>                                                           
                        </div>                            
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${fn:length(products) == 0}">
                                <div class="rcorners1">
                                    <span>${errorMessage}</span><br> 
                                    <span>Aucun produit trouvé. Merci d'effectuer une nouvelle recherche</span>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <h2>Résultats de recherche
                                    <c:if test="${fn:length(products) <= maxResult}">
                                        (${fn:length(products)})
                                    </c:if>
                                </h2>
                                <c:if test="${fn:length(users) > maxResult}">
                                    <span>Seuls les ${maxResult} premiers résultats sont affichés.</span>
                                </c:if>

                                <div class="rcorners1">
                                    <table class="tableResult">

                                        <tr>
                                            <th class="tableResult th">EAN</th>
                                            <th class="tableResult th">NOM</th>
                                            <th class="tableResult th">DESCRIPTION</th>
                                            <th class="tableResult th">PRIX</th>
                                        </tr>
                                        <c:forEach begin="0" end="${maxResult}" items="${products}" var="product">
                                            <tr>
                                                <td class="tableResult td">${product.ean}</td>
                                                <td class="tableResult td">${product.name}</td>
                                                <td class="tableResult td">${product.description}</td>
                                                <td class="tableResult td">${product.price}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>    
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>

            </c:when>
        </c:choose>    
    </div>
</div>
<div class="footer">
    <p>Ici : la jsp permet d'effectuer une recherche de produit en fonction d'un critère aux choix, en tapant un ou plusieurs mots-clés.
        Le résultat apparait dans un tableau.</p>
</div>




</body>
