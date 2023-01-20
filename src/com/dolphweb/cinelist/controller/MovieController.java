package com.dolphweb.cinelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolphweb.cinelist.dao.MovieDAO;
import com.dolphweb.cinelist.entity.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieDAO movieDAO;

	@RequestMapping("/list")
	public String listMovies(Model theModel) {
		
		List<Movie> movies=movieDAO.getMovies();
		
		theModel.addAttribute("movies", movies);
		
		return "list-movies";
	}
}
