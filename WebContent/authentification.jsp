<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Authentification</title>
<link rel="stylesheet" href="${urlcss1}" type="text/css" media="screen" />
<link rel="stylesheet" href="${urlcss2}" type="text/css" media="screen" />
<c:url var="urladd" value="/DVD/add" />
<c:url var="urllist" value="/menuAccueil" />
<c:url var="urlcss1" value="/_css/normalize.css" />
<c:url var="urlcss2" value="/_css/authentif.css" />
<c:url var="urlid" value="/menuAccueil" />
<link rel="stylesheet" href="${urlcss1}" type="text/css" media="screen" />
<link rel="stylesheet" href="${urlcss2}" type="text/css" media="screen" />
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
	<div id="container">
		<form action="${urlid}" method="post" class="form-signin" role="form">

			<p>
				Login * : <input name="login" type="text"
					placeholder="saisir le n° de login" required="required"
					class="form-control" value="${param.login}" />${erreurs["login"]}<br />
			</p>
			<p>
				mot de passe * : <input name="motdepasse" class="form-control"
					type="password" placeholder="saisir le n° de mot de passe"
					required="required" value="${param.motdepasse}" />${erreurs["motdepasse"]}<br />
			</p>
			<p>
				<input value="valider" class="btn btn-lg btn-primary btn-block"
					type="submit" name="valider" />
			</p>
			<p>${messageerror}</p>
		</form>
	</div>
</body>
</html>