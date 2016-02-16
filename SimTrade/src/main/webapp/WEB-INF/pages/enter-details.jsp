<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sim Details Page</title>
</head>
<script>
	function validateForm() {
		var x = document.forms["sim-entity"]["userName"].value;
		var y = document.forms["sim-entity"]["expiryDate"].value;
		if (x == null || x == "") {
			alert("Name must be filled out");

			return false;
		}

		else if (y == null || y == "") {
			alert("Expiry Date must be filled out");
			return false;
		}

	}
</script>
<body>
	<h1>Sim Entry Page</h1>
	<p>This is Sim Details page</p>
	<form:form commandName="sim-entity" action="display-sim-details"
		onsubmit="return validateForm()" method="POST">
		<table>

			<tr>
				<td><form:label path="userName">userName*:</form:label></td>
				<td><form:input type="text" path="userName" /></td>
			</tr>

			<tr>

				<td><form:label path="country">country*:</form:label></td>
				<td><form:select path="country" items="${countriesMap}">
					</form:select></td>

			</tr>
			<tr>
				<td><form:label path="expiryDate">expiryDate(dd/mm/yyyy)*:</form:label></td>
				<td><form:input type="text" path="expiryDate" /></td>
			</tr>
			<tr>
				<td><form:label path="simType">simType:</form:label></td>
				<td><form:input type="text" path="simType" /></td>
			</tr>
			<tr>
				<td><form:label path="phoneNumber">phoneNumber:</form:label></td>
				<td><form:input type="text" path="phoneNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="plan">plan:</form:label></td>
				<td><form:input type="text" path="plan" /></td>
			</tr>
			<tr>
				<td><form:label path="currentStatus">currentStatus:</form:label></td>
				<td><form:input type="text" path="currentStatus" /></td>
			</tr>
			<tr>
				<td><form:label path="ownerId">ownerId:</form:label></td>
				<td><form:input type="text" path="ownerId" /></td>
			</tr>
			<tr>
				<td><form:label path="expectedDateChange">expectedDateChange:</form:label></td>
				<td><form:input type="text" path="expectedDateChange" /></td>
			</tr>
			<tr>
				<td><form:label path="rechargeDetails">rechargeDetails:</form:label></td>
				<td><form:input type="text" path="rechargeDetails" /></td>
			</tr>
			<tr>
				<td><form:label path="currentUser">currentUser:</form:label></td>
				<td><form:input type="text" path="currentUser" /></td>
			</tr>
			<tr>
				<td><form:label path="timestamp">timestamp:</form:label></td>
				<td><form:input type="text" path="timestamp" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>