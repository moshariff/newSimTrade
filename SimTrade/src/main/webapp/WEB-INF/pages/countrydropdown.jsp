<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country page</title>
</head>
<body>
	<h1>Country page</h1>
	<p>This is Country page</p>
	<form:form method="POST" commandName="simdetails-entity"
		action="display-table">
		<table>
			<tr>
				<ul>
					<form:select path="country" items="${countriesMap}">
					</form:select>
				</ul>
			</tr>
			<tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
        <td></td>
        <td></td>
    </tr>
</table>  
</form:form>
<a href="/sim-drop-down/country">Submit another message</a>
</body>
</html>
	
