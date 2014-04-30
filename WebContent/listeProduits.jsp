<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:url var="accueilURL" value="/depotvente/" />
<c:url var="retouraccueilURL" value="/menuAccueil.jsp" />
<c:url var="urlcss1" value="/_css/normalize.css" />
<c:url var="urlcss2" value="/_css/produit.css" />
<link rel="stylesheet" href="${urlcss1}" type="text/css" media="screen" />
<link rel="stylesheet" href="${urlcss2}" type="text/css" media="screen" />
<title>Produits</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>Application depot/vente</h1>
			<h2>PAGE PRODUITS</h2>
			<ul class="nav nav-pills pull-right">

				<li class="active"><a href="#">Home</a></li>

			</ul>

		</header>
		<div class="main">
			<FORM action="${accueilURL}" method="post">

				Liste des produits :
				<ul>
					<c:forEach items="${listeProduit}" var="produit">
						<li>${produit.id}:${produit.nom} : $(produit.fournisseur} :
							${produit.prix} : ${produit.quantite}</li>
					</c:forEach>
				</ul>
				<p>
					<input type="submit" class="btn btn-lg btn-success"
						value="creaproduit" name="action" />
				</p>
				<p>
					<input type="submit" class="btn btn-lg btn-success"
						value="modifproduit" name="action" />
				</p>
				<p>
					<input type="submit" class="btn btn-lg btn-success"
						value="supproduit" name="action" />
				</p>
				<p>
					<input type="submit" class="btn btn-lg btn-success"
						value="chargproduit" name="action" />
				</p>
			</form>
		</div>
	</div>
	<a href="${retouraccueilURL}">Retour Accueil</a>
</body>
</html>
