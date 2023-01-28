<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="sortDirectorLink" value="/movie/list">
	<c:param name="sort" value="director"></c:param>
</c:url>

<c:url var="sortTitleLink" value="/movie/list">
	<c:param name="sort" value="title"></c:param>
</c:url>
<!DOCTYPE html>

<html>

<head>
	<title>CineList - Your Watchlist</title>
	
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
			
			<form:form action="search" method="GET">
				Search Titles: <input type="text" name="searchedMovie"/>
				<input type="submit" value="Search" class="add-button">
				
				<input type="radio" id="All" name="filter" value="All" checked> <label for="All">All Types</label>
				<input type="radio" id="Movies" name="filter" value="Movie" > <label for="Movies">Movies</label>
				<input type="radio" id="TV" name="filter" value="TV Show" > <label for="TV">TV Shows</label>
			</form:form>
		
			<table>
				<tr>
					<th><a href="${sortTitleLink}">Title</a></th>
					<th><a href="${sortDirectorLink}">Director</a></th>
					<th>Genre</th>
					<th>Type</th>	
					<th>Actions</th>
				</tr>
				
				<c:forEach var="tempMovie" items="${movies}">
				
					<c:url var="updateLink" value="/movie/showFormForUpdate">
						<c:param name="movieId" value="${tempMovie.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/movie/delete">
						<c:param name="movieId" value="${tempMovie.id}"/>
					</c:url>
					
					<c:url var="moreLink" value="/movie/info">
						<c:param name="tmdbID" value="${tempMovie.tmdbId}"/>
						<c:param name="type" value="${tempMovie.type}"/>
					</c:url>
				
					<tr>
						<td>${tempMovie.title}</td>
						<td>${tempMovie.director}</td>
						<td>${tempMovie.genre}</td>
						<td>${tempMovie.type}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to mark this as watched?'))) return false">Mark as Watched</a>
							|
							<a href="${moreLink}">More</a>
						</td>
					</tr>
				
				</c:forEach>
			
			</table>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}">Back to Homepage</a>
			</p>
			
		</div>
	</div>

</body>

</html>