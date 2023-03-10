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
	public List<Movie> getMovies(String sort) {
		return movieDAO.getMovies(sort);
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

	@Override
	@Transactional
	public List<Movie> search(String theSearch) {
		return movieDAO.search(theSearch);
	}

	@Override
	@Transactional
	public List<Movie> searchWithFilter(String theSearch, String type) {
		return movieDAO.searchWithFilter(theSearch, type);
	}

}
