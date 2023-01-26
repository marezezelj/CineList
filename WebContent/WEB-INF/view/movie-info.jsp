<!DOCTYPE html>

<html>

<head>
	<title>CineList - Info Page</title>
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id = "wrapper">
		<div id ="header">
			<h2>${title}</h2>
		</div>
	</div>
	
	<br><br>
	
	<img alt="poster" src="${poster}">
	
	<h3>${runtime}</h3>
	<h3>${rating}</h3>
	
	<p>${desc}</p>
	<a href="${imdb}" target="_blank">IMDb</a>
	
	<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/movie/list">Back to Watchlist</a>
			</p>
	
</body>

</html>