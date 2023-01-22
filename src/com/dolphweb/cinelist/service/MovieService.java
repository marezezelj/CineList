package com.dolphweb.cinelist.service;

import java.util.List;

import com.dolphweb.cinelist.entity.Movie;

public interface MovieService {

	public List<Movie> getMovies();

	public void saveMovie(Movie theMovie);

	public Movie getMovie(int theId);
}
