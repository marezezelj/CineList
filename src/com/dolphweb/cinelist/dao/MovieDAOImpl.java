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
	public List<Movie> getMovies() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Movie> theQuery = currentSession.createQuery("from Movie order by title", Movie.class);
		
		List<Movie> movies = theQuery.getResultList();
		
		return movies;
	}

	@Override
	public void saveMovie(Movie theMovie) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theMovie);
		
		
	}

	@Override
	public Movie getMovie(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Movie theMovie=currentSession.get(Movie.class, theId);
		
		return theMovie;
	}

}
