<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function submitForm() {
    document.getElementById("envselection").submit();
    var x =  document.getElementById("envselection").value;
    var y = document.getElementById("ppp").value;
    alert (x);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sim Details</title>
</head>
<body>
 <h1>Sim Details</h1>



 -->
<form id="envselection" action="result" method="post" onsubmit="submitForm()">
 <table border="2">

  <tr>
   <td>Sim ID</td>
   <td>User Name</td>
   <td>Country</td>
   <td>Expiry Date</td>
   <td>Sim Type</td>
   <td>phone Number</td>
   <td>plan</td>
   <td>currentStatus</td>
   <td>ownerId</td>
   <td>expectedDateChange</td>
   <td>rechargeDetails</td>
   <td>currentUser</td>
   <td>timestamp</td>


  </tr>
 



  <c:forEach items="${simDetails}" var="entry" varStatus="count">

   <tr>
   <td>${entry.simId}</td>
    <td>${entry.userName}</td>
    <td>${entry.country}</td>
    <td>${entry.expiryDate}</td>
    <td>${entry.simType}</td>
    <td>${entry.phoneNumber}</td>
    <td>${entry.plan}</td>
    <td>${entry.currentStatus}</td>
    <td>${entry.ownerId}</td>
    <td>${entry.expectedDateChange}</td>
    <td>${entry.rechargeDetails}</td>
    <td>${entry.currentUser}</td>
    <td>${entry.timestamp}</td>
    <c:choose>
    <c:when test="${entry.currentStatus=='passive'}">
        <td><input type="radio" name="env" id="radioSelection" value="${fn:join(${entry.userName},${entry.country})}" disabled="disabled"></td>
        
    </c:when>    
    <c:otherwise>
         
        <td><input type="radio" name="env" id="radioSelection" value="${entry.userName}" ></td>
        
    </c:otherwise>
</c:choose>
 
   </tr>
 
  </c:forEach>



 </table>
 <br>
<input id="ppp" type="hidden" value="10"/>
 <input type="submit" name="confirmButton" value="Confirm" style="height:50px; width:100px" ></input>
   </form>

 
 </body>
</html>