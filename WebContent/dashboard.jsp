<%@page import="Beans.Citation"%>
<%@page import="Beans.Passage"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="Beans.Site"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BrightCite</title>
</head>
<body>

<% Site site = (Site)request.getAttribute("siteinfo"); %>

<h1><font size="10">Dashboard</font></h1>
<div id="title" align="center" >
<h2> Site URL: <%= site.getURL() %></h2>
<h3><i>Site Rating: <b><%=site.getSiteRating()%></b></i></h3>
</div>

<table border="1" width="100%" height="100%" cellpadding="10">
<tr><td width="50%">

<div id="passages" align="left">
<%for(Passage passage:site.getPassanges()){%>
<hr>
<%if(passage.getPassageRating()>0){%>
<font size="5" color="Green">
<%}else{ %>
<font size="5" color="990000">
<%}%>
<li><b>"<%= passage.getText()%>"</b></font>
<ul type="circle">

<li>Passage Rating: <%=passage.getPassageRating() %></li>

<%for(Citation citation:passage.getCitations()){ %>
<li><%=citation.getSource() %></li>
<%}%></ul></li>
<%}%>
</div>
</td>
<td>
<iframe sandbox="allow-forms allow-scripts" src="<%= site.getURL() %>" width="100%" height="800px">
  <p>Your browser does not support iframes.</p>
</iframe>
</td>
</tr>
<tr>

<td>
<div class='control_group'>
      <div class='label'>
        <label>which passage are you supporting or correcting?</label>
      </div>
      <div class='input'>
        <select>
        <%for(Passage passage:site.getPassanges()){%>
          <option>
         "<%=passage.getText().substring(0, 30).concat("...") %>"
          </option>
          <%} %>
        </select>
      </div>
    </div>

<div id="input">
<label for="citeBox">Enter Cites Here</label><br>
<input id="citeBox" type="text">
<hr>
</div>
 <div class='input'>
 		<label>How accurate was this article?</label>
        <div class='control'>
          <input id='radio_01' name='radio_vertical' type='radio'>
          <label for='radio_01'>Accurate</label>
        </div>
        <div class='control'>
          <input id='radio_02' name='radio_vertical' type='radio'>
          <label for='radio_02'>Neutral</label>
        </div>
        <div class='control'>
          <input id='radio_03' name='radio_vertical' type='radio'>
          <label for='radio_03'>Inaccurate</label>
        </div>
 </div>
<hr>
</td>

<td>
<%String encoded = URLEncoder.encode(site.getURL(), "UTF-8");%>
<iframe sandbox="allow-forms allow-scripts" src="http://www.snopes.com/search/?q=<%= encoded %>" width="100%" height="800px">
  <p>Your browser does not support iframes.</p>
</iframe>
</td>
</tr>
</table>




</body>
</html>