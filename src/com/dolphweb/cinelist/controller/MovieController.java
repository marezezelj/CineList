package com.dolphweb.cinelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dolphweb.cinelist.dao.MovieDAO;
import com.dolphweb.cinelist.entity.Movie;
import com.dolphweb.cinelist.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/list")
	public String listMovies(Model theModel) {
		
		List<Movie> movies=movieService.getMovies();
		
		theModel.addAttribute("movies", movies);
		
		return "list-movies";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Movie theMovie= new Movie();
		
		theModel.addAttribute("movie",theMovie);
		
		return "movie-form";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie theMovie) {
		
		movieService.saveMovie(theMovie);
		
		return "redirect:/movie/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("movieId") int theId, Model theModel) {
		
		Movie theMovie= movieService.getMovie(theId);
		
		theModel.addAttribute("movie",theMovie);
	
		return "movie-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("movieId") int theId) {
		
		movieService.markAsRead(theId);
		
		return "redirect:/movie/list";
	}
	
	@GetMapping("/search")
	public String searchMovies(@RequestParam("searchedMovie") String theSearch, Model theModel) {
		
		List<Movie> listaFilmova = movieService.search(theSearch);
		
		theModel.addAttribute("movies",listaFilmova);
		
		return "list-movies";
	}
}
