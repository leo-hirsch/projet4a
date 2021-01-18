<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>demoJEE Léo</title>
</head>
<body>
<%@ include file = "menu.jsp"%>
<p>
Bonjour je suis dans la vue
</p>

<p>
<%
String variable = (String)request.getAttribute("mes");
out.println("Contenu de la variable envoyé par la servlet : " + variable);
%>
</p>

<p>
<%
String moment = (String)request.getAttribute("moment");
if(moment=="jour") {
	out.println("Bonjour");
}else if(moment=="nuit"){
	out.println("Bonne nuit");
}else{
	out.println("erreur");
}
%>
</p>
</body>
</html>