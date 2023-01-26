<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<title>CineList - Add Title</title>
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CineList - Add Movie Form</h2>
		</div>
		
		<div id="container">
			<h3>Save Movie</h3>
			
			<form:form action="saveMovie" modelAttribute="movie" method="POST">
			
			<form:hidden path="id"/>
			
				<table>
					<tbody>
						<tr>
							<td><label>Title:</label></td>
							<td><form:input path="title"/></td>
						</tr>
						<tr>
							<td><label>Director:</label></td>
							<td><form:input path="director"/></td>
						</tr>
						<tr>
							<td><label>Genre:</label></td>
							<td><form:input path="genre"/></td>
						</tr>
						<tr>
							<td><label>Movie ID:</label></td>
							<td><form:input path="tmdbId"/></td>
						</tr>
						<tr>
							<td><label>Type(Movie/TV Show):</label></td>
							<td><form:select path="type">
								<form:option value="Movie" label="Movie"/>  
        						<form:option value="TV Show" label="TV Show"/>
        					</form:select></td>  
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					
					
					</tbody>
				
				</table>
			
			</form:form>
			
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/movie/list">Back to Watchlist</a>
			</p>
			
		</div>
	
	
	</div>


</body>



</html>