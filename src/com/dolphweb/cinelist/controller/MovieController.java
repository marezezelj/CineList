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

import com.dolphweb.cinelist.api.SeriesApi;
import com.dolphweb.cinelist.api.TmbdApi;
import com.dolphweb.cinelist.dao.MovieDAO;
import com.dolphweb.cinelist.entity.Movie;
import com.dolphweb.cinelist.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/list")
	public String listMovies(@RequestParam(required=false) String sort, Model theModel) {
		
		List<Movie> movies=null;
		
		if(sort!=null) {
			movies=movieService.getMovies(sort);
		} else {
			movies=movieService.getMovies("title");
		}
		
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
	public String searchMovies(@RequestParam("searchedMovie") String theSearch, @RequestParam("filter") String type, Model theModel) {
		
		if(type.equals("All")) {
			List<Movie> listaFilmova = movieService.search(theSearch);
			theModel.addAttribute("movies",listaFilmova);
		} else {
			List<Movie> listaFilmova = movieService.searchWithFilter(theSearch, type);
			theModel.addAttribute("movies",listaFilmova);
		}
		
		return "list-movies";
	}
	
	@GetMapping("/info")
	public String showInfo(@RequestParam("tmdbID") String tmdbId, @RequestParam("type") String type, Model theModel) {
		
		if(type.equals("Movie")) {
			TmbdApi tmdb = new TmbdApi(tmdbId);
			theModel.addAttribute("poster",tmdb.getPoster());
			theModel.addAttribute("title", tmdb.getTitle());
			theModel.addAttribute("desc", tmdb.getDescription());
			theModel.addAttribute("runtime", tmdb.getRuntime());
			theModel.addAttribute("rating", tmdb.getRatings());
			theModel.addAttribute("imdb", tmdb.getIMDB());
		} else {
			SeriesApi series = new SeriesApi(tmdbId);
			theModel.addAttribute("poster",series.getPoster());
			theModel.addAttribute("title", series.getTitle());
			theModel.addAttribute("desc", series.getDescription());
			theModel.addAttribute("runtime", series.getRuntime());
			theModel.addAttribute("rating", series.getRatings());
			theModel.addAttribute("imdb", series.getSite());
		}
		
		
		return "movie-info";
	}
}
