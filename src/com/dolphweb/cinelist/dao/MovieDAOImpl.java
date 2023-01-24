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

	@Override
	public void markAsWatch(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from Movie where id=:kljuc");
		query.setParameter("kljuc", theId);
		query.executeUpdate();
	}

	@Override
	public List<Movie> search(String theSearch) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery=null;
		
		if(theSearch!=null && theSearch.trim().length()>0) {
			theQuery = currentSession.createQuery("from Movie where lower(title) like :naziv");
			theQuery.setParameter("naziv", "%" + theSearch.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from Movie");
		}
		
		List<Movie> lista=theQuery.getResultList();
		
		return lista;
	}

}
