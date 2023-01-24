package com.dolphweb.cinelist.dao;

import java.util.List;

import com.dolphweb.cinelist.entity.Movie;

public interface MovieDAO {
	
	public List<Movie> getMovies(String sort);

	public void saveMovie(Movie theMovie);

	public Movie getMovie(int theId);

	public void markAsWatch(int theId);

	public List<Movie> search(String theSearch);

	public List<Movie> searchWithFilter(String theSearch, String type);
}
