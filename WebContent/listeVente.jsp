<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:url var="accueilURL" value="/depotvente/" />
<c:url var="retouraccueilURL" value="/menuAccueil.jsp" />
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
<title>Vente</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>Application depot/vente</h1>
			<h2>Liste des VENTE</h2>
			<ul class="nav nav-pills pull-right">

				<li class="active"><a href="#">Home</a></li>

			</ul>

		</header>
		<div class="main">
			<p>

				valider vente <input type="submit" class="btn btn-lg btn-success"
					value="validervente" name="action" />
		</div>
		<div class="footer">
			<p>&copy; G2L2 Corp 2014</p>

		</div>
	</div>
</body>
</html>
