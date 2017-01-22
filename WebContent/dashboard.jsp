<%@page import="java.net.URLEncoder"%>
<%@page import="Beans.Site"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Site site = (Site)request.getAttribute("siteinfo"); %>

<h1> Dashboard </h1>

<h2> Site Url: <%= site.getURL() %></h2>

<p> <%= site.getJsonSring() %>

<%
	String encoded = URLEncoder.encode(site.getURL(), "UTF-8");
	
%>



<iframe sandbox="allow-forms allow-scripts" src="http://www.snopes.com/search/?q=<%= encoded %>">
  <p>Your browser does not support iframes.</p>
</iframe>

</body>
</html>