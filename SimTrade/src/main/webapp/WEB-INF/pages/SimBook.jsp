<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sim Details Page</title>
</head>
<script>
	function validateForm() {
		var x = document.forms["user-entity"]["name"].value;
		var y = document.forms["user-entity"]["empId"].value;
		var z = document.forms["user-entity"]["practice"].value;
		if (x == null || x == "") {
			alert("Name must be filled out");

			return false;
		}

		else if (y == null || y == "") {
			alert("owner id must be filled out");
			return false;
		} else if (z == null || z == "") {
			alert("Practice must be filled out");
			return false;
		}
	}
</script>
<body>
	<h1>Enter user details</h1>
	<p>user information</p>
	<form:form commandName="user-entity" action="user-country"
		onsubmit="return validateForm()" method="POST">
		<TABLE cellpadding="15" border="1">

			<tr>
				<td><form:label path="empId">EmployeeId*:</form:label></td>
				<td><form:input type="text" path="empId" /></td>
			</tr>
			<tr>

				<td><form:label path="practice">practice*:</form:label></td>
				<td><form:input type="text" path="practice" /></td>
			</tr>

			<tr>

				<td><form:label path="name">EmployeeName*:</form:label></td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="empPhoneNumber">Employee phoneNumber:</form:label></td>
				<td><form:input type="text" path="empPhoneNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Employee Email Id:</form:label></td>
				<td><form:input type="text" path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfJoining">Date of Joining:</form:label></td>
				<td><form:input type="text" path="dateOfJoining" /></td>
			</tr>

			<tr>
				<td><form:label path="timestamp">timestamp:</form:label></td>
				<td><form:input type="text" path="timestamp" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
				
			</tr>
		</table>
	</form:form>
</body>
</html>