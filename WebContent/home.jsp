<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html height="100%">
<% final String CP = request.getContextPath(); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorldJSP</title>

</head>
<body height="100%">

<%
	final String MAIN_COLOR = "#58639a";
	%>


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


/************************
 POP UP
*************************/


/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
font-family: Arial, Helvetica, sans-serif;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    -webkit-animation-name: fadeIn; /* Fade in the background */
    -webkit-animation-duration: 0.4s;
    animation-name: fadeIn;
    animation-duration: 0.4s
}

/* Modal Content */
.modal-content {
    position: fixed;
    bottom: 0;
    background-color: #fefefe;
    width: 100%;
    -webkit-animation-name: slideIn;
    -webkit-animation-duration: 0.4s;
    animation-name: slideIn;
    animation-duration: 0.4s
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 10px;
    background-color: <%= MAIN_COLOR %>;
    color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: <%= MAIN_COLOR %>;
    color: white;
}

/* Add Animation */
@-webkit-keyframes slideIn {
    from {bottom: -300px; opacity: 0} 
    to {bottom: 0; opacity: 1}
}

@keyframes slideIn {
    from {bottom: -300px; opacity: 0}
    to {bottom: 0; opacity: 1}
}

@-webkit-keyframes fadeIn {
    from {opacity: 0} 
    to {opacity: 1}
}

@keyframes fadeIn {
    from {opacity: 0} 
    to {opacity: 1}
}



</style>

<br>
<br>
<br>
<br>
<br>

<center>
<img width="50%" src="<%= CP %>/img/BrightCite.png" />
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

<style>
.round-button {
    display:block;
    width:50px;
    height:50px;
    line-height:50px;
    border-radius: 50%;
    color:#f5f5f5;
    text-align:center;
    text-decoration:none;
    background: <%=MAIN_COLOR%>;
    font-size:20px;
    font-weight:bold;
    position:fixed;
right:15px;
bottom:15px;
}
.round-button:hover {
    background: #262626;
}

textarea, input {
    border: none;
    overflow: auto;
    outline: none;

    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: none;
}

</style>

<button id="myBtn" href="http://example.com" class="round-button material">+</button>




<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2>Add a Passage</h2>
    </div>
    <div class="modal-body">
    	<br />
      <form action="<%= CP %>/hello?command=newPassage" method="POST">
		<div class='control_group'>
	      	<div class='label'>
	        	<label for='passageIn'>Passage:</label>
	      	</div>
	      	<div class='material'>
	       		<textarea id='passageIn' name="passage" cols="120" rows="7"></textarea>
	      	</div>
   		</div>
   		<br />
   		<div class='control_group'>
	      	<div class='label'>
	        	<label for='urlIn'>URL:</label>
	      	</div>
	      	<div class='material'>
	       		<input id='urlIn' name="url" style="width:100%" />
	      	</div>
   		</div>
   		
   		<br />
   		
		<input type="submit" value="Submit" />
      </form>
      
      
      <br />
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>

</div>



<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>


</body>
</html>