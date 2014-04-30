<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="listeDVDURL" value="/CRUDDVDController?action=liste" />
	<c:url var="saisieDVDURL" value="/CRUDDVDController" />

	<form action="${saisieDVDURL}" method="post">
		<p>
			DVD Titre :<input name="titre" type="text" value="${param.titre}" />${erreurs["titre"]}</p>
		<p>
			DVD Auteur :<input name="auteur" type="text" value="${param.auteur}" />${erreurs["auteur"]}</p>
		<br>
		<p>
			<label>Genre / Type : </label><br> <select name="type">
				<option value="filmAction" ${filmAction}>Films Action</option>
				<option value="filmAventure" ${filmAventure}>Films Aventure</option>
				<option value="filmComedie" ${filmComedie}>Films Comedie</option>
				<option value="filmRomantique" ${filmRomantique}>Films
					Sentimental/Romantique</option>
				<option value="filmMusical" ${filmAction}>Films Music</option>
				<option value="filmGuerre" ${filmAction}>Films Guerre</option>
				<option value="filmHistorique" ${filmHistorique}>Films
					Historique</option>
				<option value="concert" ${filmAction}>Concert / Clips
					Videos</option>
				<option value="reportage" ${reportage}>Reportage</option>
			</select>
		</p>
		<br> <label>Date d'achat :</label><br> <input type="date"
			name="dateAchat" id="dateAchat"><br>${erreurs["dateAchat"]}
		<input type="submit" value="enregistrer" name="action" />
	</form>

	<a href="${listeDVDURL}">liste des DVD</a>

</body>
</html>