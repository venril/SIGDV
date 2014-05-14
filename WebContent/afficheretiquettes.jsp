<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url var="urlcss1" value="css/etiquettes.css" />
<title>Depôt Vente: Liste des Etiquettes</title>
</head>
<body>
	<p><h1>Les etiquettes des produits en vente:</h1></p>
	
	<c:forEach items="${listeEtiquettes}" var="etiquette">
		<table border="3">
			<p class="prixEtiquette"><h1>${etiquette.idProduit} &#8364</h1></p>
			<p><span class="marge"><h3>${etiquette.prixProduit}</h3></span></p>
		</table>
	</c:forEach>
	<a href="index.jsp">Retour page Accueil</a>	
</body>
</html>