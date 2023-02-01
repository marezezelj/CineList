<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<html>

<head>
<title>CineList - Ratings</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Ratings</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Title</th>
					<th>Rating</th>
				</tr>

				<c:forEach var="tempRating" items="${ratings}">
					<tr>
						<td>${tempRating.title}</td>
						<td>${tempRating.rating}</td>
					</tr>
				</c:forEach>

			</table>
			<div style=""></div>
			<p>
				<a href="${pageContext.request.contextPath}">Back to Homepage</a>
			</p>
		</div>
	</div>


</body>



</html>