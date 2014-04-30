<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des DVDs</title>
</head>
<body>
	<p>Vous êtes la ${compteur.valeur} personne(s) connecté(e)s</p>
	<br>
	<c:url var="listeDVDURL" value="/CRUDDVDController?action=liste" />
	<c:url var="saisieDVDURL" value="/CRUDDVDController" />
	<ul>
		<c:forEach items="${listeDVD}" var="dvd">
			<li>${dvd.id}:${dvd.titre} : ${dvd.auteur} : ${dvd.type} :
				${dvd.description} : ${dvd.prop.pseudo}</li>
		</c:forEach>
	</ul>
	<a href="saisieDVD.jsp">Saisie d'un DVD</a>
</body>
</html>