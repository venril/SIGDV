<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:url var="accueilURL" value="/depotvente/" />
<c:url var="retouraccueilURL" value="/menuAccueil.jsp" />
<c:url var="retourfournisseurURL" value="/menuAccueil.jsp" />
<c:url var="listefournisseur" value="/menuAccueil?action=fournisseur" />
<c:url var="urlcss1" value="/_css/normalize.css" />
<c:url var="urlcss2" value="/_css/fournisseur.css" />
<link rel="stylesheet" href="${urlcss1}" type="text/css" media="screen" />
<link rel="stylesheet" href="${urlcss2}" type="text/css" media="screen" />

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<title>Fournisseur</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>Application depot/vente</h1>
			<h2>PAGE FOURNISSEURS</h2>
			<ul class="nav nav-pills pull-right">

				<li class="active"><a href="#">Home</a></li>

			</ul>

		</header>
		<div class="main">

			<form action="${accueilURL}" method="post">
				<p>
					Nom :<input name="nomFournisseur" type="text"
						value="${param.nomFournisseur}" />${erreurs["nomFournisseur"]}</p>
				<p>
					Prenom :<input name="prenomfournisseur" type="text"
						value="${param.prenomfournisseur}" />${erreurs["prenomfournisseur"]}</p>
				<p>
					<label>Adresse : </label> <input name="adrfourni" type="text"
						value="${param.adrfourni}" />${erreurs["adrfourni"]}</p>
				<br>
				<p>
					<label>Telephone : </label> <input name="telfourni" type="text"
						value="${param.telfourni}" />${erreurs["telfourni"]}</p>
				<br>
				<p>
					<label>Email : </label> <input name="emailfourni" type="text"
						value="${param.emailfourni}" />${erreurs["emailfourni"]}</p>
				<br>
				<input type="submit" class="btn btn-lg btn-success"
					value="enregistrerfournisseur" name="action" />
			</form>
		</div>
		<a href="${retourfournisseurURL}">Retour liste fournisseur</a>
		<div class="footer">
			<p>&copy; G2L2 Corp 2014</p>
		</div>
	</div>

</body>
</html>
