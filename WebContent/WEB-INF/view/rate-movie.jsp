<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>CineList - Add Rating</title>
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>

<body>

	<div id = "wrapper">
		<div id ="header">
			<h2>Rate Movie</h2>
		</div>
	</div>
	
	<div id="container">
		<h2>Tell us your opinion: </h2>
		
		<h2>${rateTitle}</h2>
		
		<form:form action="saveRating" modelAttribute="movieRating" method="POST">
		
		<table>
			<tbody>
				<tr>
					<td><label>Title:</label></td>
					<td><form:input path="title" value="${rateTitle}" readonly="true"/></td>
				</tr>
				<tr>
					<td><label>My rating:</label></td>
					<td><form:select path="rating">
							<form:option value="1" label="1"/>
							<form:option value="2" label="2"/>
							<form:option value="3" label="3"/>
							<form:option value="4" label="4"/>
							<form:option value="5" label="5"/>
							<form:option value="6" label="6"/>
							<form:option value="7" label="7"/>
							<form:option value="8" label="8"/>
							<form:option value="9" label="9"/>
							<form:option value="10" label="10"/>
						</form:select>
					</td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Rate Now" class="save"/></td>
				</tr>
			</tbody>
		
		
		</table>
		
		</form:form>
		
		<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/movie/list">Back to Watchlist</a>
			</p>
	
	</div>

</body>

</html>