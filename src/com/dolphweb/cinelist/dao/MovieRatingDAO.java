package com.dolphweb.cinelist.dao;

import java.util.List;

import com.dolphweb.cinelist.entity.Movie;
import com.dolphweb.cinelist.entity.MovieRating;

public interface MovieRatingDAO {

	public List<MovieRating> getRatings();
	
	public void saveMovie(MovieRating theMovieRating);
}
