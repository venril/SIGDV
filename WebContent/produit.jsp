<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:url var="listeproduit" value="/menuAccueil?action=produit" />
<c:url var="retouraccueilURL" value="/menuAccueil.jsp" />
<c:url var="retourlisteProduits" value="/listeProduits.jsp" />
<c:url var="urlcss1" value="/_css/normalize.css" />
<c:url var="urlcss2" value="/_css/produit.css" />
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
<title>Produits</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>Application depot/vente</h1>
			<h2>PRODUIT</h2>

		</header>
		<div class="main">

			<form action="${accueilURL}" method="post">
				<p>
					Nom :<input name="nomProduit" required type="text"
						value="${param.nomProduit}" />${erreurs["nomProduit"]}</p>
				<p>
					Fournisseur :<input name="fournisseur" required type="text"
						value="${param.fournisseur}" />${erreurs["fournisseur"]}</p>
				<p>
					<label>Prix unitaire : </label> <input name="prixUnitaire" required
						type="text" value="${param.prixUnitaire}" />${erreurs["prixUnitaire"]}</p>
				<br>
				<p>
					<label>Quantité : </label> <input name="quantite" required
						type="text" value="${param.quantite}" />${erreurs["quantite"]}</p>
				<br>
				<label>Lot</label> oui :<input type="radio" name="lot" value="true"
					title="oui" id="radiobouton"> non :<input type="radio"
					title="non" name="lot" value="false" id="radiobouton"><br>${erreurs["lot"]}
				<br>
				<p>

					<input type="submit" class="btn btn-lg btn-success"
						value="enregistrerproduit" name="action" />
			</form>

			<a href="${retourlisteProduits}">retour</a>
			<div class="footer">
				<p>&copy; G2L2 Corp 2014</p>
			</div>
		</div>
	</div>

</body>
</html>
