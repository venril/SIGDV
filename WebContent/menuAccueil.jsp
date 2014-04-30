<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:url var="accueilURL" value="/depotvente/" />
<c:url var="urlcss1" value="/_css/normalize.css" />
<c:url var="urlcss2" value="/_css/menuAccueil.css" />
<c:url var="urlid" value="/depotvente/" />
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
<title>Accueil Depot/vente</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Application depotvente</h1>

			<ul class="nav nav-pills pull-right">

				<li class="active"><a href="#">Menu</a></li>

			</ul>



		</div>
		<div class="main">

			<FORM Method="post" action="${accueilURL}">
				<div>
					<INPUT class="btn btn-lg btn-success" width=13px height=15px
						role="button" name="action" value="produit" id="produit"
						type="submit" />
				</div>
				<div>
					<INPUT class="btn btn-lg btn-success" name="action"
						value="fournisseur" id="fournisseur" type="submit" />
				</div>
				<div>
					<INPUT class="btn btn-lg btn-success" name="action" value="vente"
						id="vente" type="submit" />
				</div>
			</FORM>
		</div>
		<div class="footer">
			<p>&copy; G2L2 Corp 2014</p>
		</div>
</body>
</html>
</xml>