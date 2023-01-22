<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Your Watchlist</title>
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>


<body>

	<div id = "wrapper">
		<div id ="header">
			<h2>Watchlist</h2>
		</div>
	</div>

	<div id="container">
		<div id = "content">
		
			<input type="button" value="Add Movie/TV"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
			/>
		
			<table>
				<tr>
					<th>Title</th>
					<th>Director</th>
					<th>Genre</th>
					<th>Type</th>	
					<th>Actions</th>
				</tr>
				
				<c:forEach var="tempMovie" items="${movies}">
				
					<c:url var="updateLink" value="/movie/showFormForUpdate">
						<c:param name="movieId" value="${tempMovie.id}"/>
					</c:url>
				
					<tr>
						<td>${tempMovie.title}</td>
						<td>${tempMovie.director}</td>
						<td>${tempMovie.genre}</td>
						<td>${tempMovie.type}</td>
						<td>
							<a href="${updateLink}">Update</a>
						</td>
					</tr>
				
				</c:forEach>
			
			</table>
		</div>
	</div>

</body>

</html>