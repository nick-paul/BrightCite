<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html height="100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorldJSP</title>
</head>
<body height="100%">

<% final String CP = request.getContextPath(); %>


<style>
/*
* Pseudo-Material
*/

.material {
	border-radius: 3px;
	border-style: solid;
	border-width: 1px;
	border-color: #CCC;
	-webkit-box-shadow: 0px 2px 2px 0px rgba(0,0,0,0.2);
	-moz-box-shadow: 0px 2px 2px 0px rgba(0,0,0,0.2);
	box-shadow: 0px 2px 2px 0px rgba(0,0,0,0.2);
}

form {
  width:60%;
  margin:0 auto;
}

.boxbox {
  height:50px;
}

.search, .submit {
  font-size:18px;
  padding:0 15px;
  height: 100%;
  border:none;
}

.search {
  highlight-color: #58639a;
}


textarea:focus, input:focus {
   color:#58639a;
   outline:none;
}

.submit {
  font-weight:600;
  background:#58639a;
  color:#fff;
  height:100%;
  width:30%;
  float:right;
  transition: all 100ms ease-in-out;
}


.submit:hover {
  background: #4774aa;
}

.search {
    margin: auto;
}


</style>

<br>
<br>
<br>
<br>
<br>

<center>
<img width="60%" src="<%= CP %>/img/BrightCite.png" />
</center>

<form action="<%= CP %>/hello?command=getsite" method="POST">
	<div class="boxbox material">
	 	<input class="search" type="text" placeholder="Enter a URL"/>
	  	<input class="submit" type="submit" value="GO"/>
  	</div>
</form>


<br />
<br />
<br />
<br />
<br />
<br />
<br />



</body>
</html>