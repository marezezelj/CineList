package com.dolphweb.cinelist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphweb.cinelist.dao.MovieDAO;
import com.dolphweb.cinelist.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDAO movieDAO;

	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public void saveMovie(Movie theMovie) {
		movieDAO.saveMovie(theMovie);
		
	}

	@Override
	@Transactional
	public Movie getMovie(int theId) {
		return movieDAO.getMovie(theId);
	}

	@Override
	@Transactional
	public void markAsRead(int theId) {
		movieDAO.markAsWatch(theId);
		
	}

}
