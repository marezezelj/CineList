package com.dolphweb.cinelist.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dolphweb.cinelist.entity.Movie;
import com.dolphweb.cinelist.entity.MovieRating;

//repository za komunikaciju sa bazom ocena

@Repository
public class MovieRatingDAOImpl implements MovieRatingDAO {
	
	@Autowired
	private SessionFactory theSessionFactory;

	@Override
	public List<MovieRating> getRatings() {
		Session session = theSessionFactory.getCurrentSession();
		
		String query = "from MovieRating order by Title";
		
		Query<MovieRating> theQuery = session.createQuery(query, MovieRating.class);
		
		List<MovieRating> lista = theQuery.getResultList();
		
		return lista;
	}

	@Override
	public void saveMovie(MovieRating theMovie) {
		Session session = theSessionFactory.getCurrentSession();
		session.save(theMovie);
	}

}
