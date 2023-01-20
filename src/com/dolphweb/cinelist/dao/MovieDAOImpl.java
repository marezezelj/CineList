package com.dolphweb.cinelist.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dolphweb.cinelist.entity.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Movie> getMovies() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Movie> theQuery = currentSession.createQuery("from Movie", Movie.class);
		
		List<Movie> movies = theQuery.getResultList();
		
		return movies;
	}

}
