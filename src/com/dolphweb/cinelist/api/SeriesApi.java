package com.dolphweb.cinelist.api;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

public class SeriesApi {

	private String id;
	private Map map;
	private String firstURL = "https://api.themoviedb.org/3/tv/";
	private String secondURL = "?api_key=9e9b3f0c30898de3dec31a24f6d7112e";

	public SeriesApi(String id) {

		this.id = id;
		try {
			URI uri = new URI(firstURL + id + secondURL);
			URL url = uri.toURL();

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int response = conn.getResponseCode();

			if (response != 200) {
				throw new RuntimeException("HttpResponseCode: " + response);
			} else {
				StringBuilder sb = new StringBuilder();
				Scanner scan = new Scanner(url.openStream());

				while (scan.hasNext()) {
					sb.append(scan.nextLine());
				}

				scan.close();

				String json = sb.toString();

				Gson gson = new Gson();
				map = gson.fromJson(json, Map.class);
			}
		} catch (Exception e) {
			System.out.println("GRESKA");
		}

	}
	
	public String getTitle() {
		String title = (String) map.get("original_name");
		String date = (String) map.get("first_air_date");
		String endDate = (String) map.get("last_air_date");

		String[] niz = date.split("-");
		String startYear = " (" + niz[0] + "-";
		
		String[] niz2 = endDate.split("-");
		String endYear = niz2[0] + ")";

		return title + startYear + endYear;
	}
	
	public String getPoster() {
		String url = "https://image.tmdb.org/t/p/w185/";
		String endUrl = (String) map.get("poster_path");

		String site = url + endUrl;
		return site;
	}
	
	public String getSite() {
		String site = (String) map.get("homepage");
		return site;
	}
	
	public String getDescription() {
		String desc = (String) map.get("overview");
		return desc;
	}
	
	public String getRatings() {
		Double rate = (Double) map.get("vote_average");
		Double finalrate = Math.round(rate * 100.0) / 100.0;
		return "Rating: " + finalrate + "/10";
	}
	
	public String getRuntime() {
		int ses=(int) Math.round((Double) map.get("number_of_seasons"));
		int epi = (int) Math.round((Double) map.get("number_of_episodes"));
		String seasons = Integer.toString(ses);
		String episodes = Integer.toString(epi);
		return "Seasons: " + seasons + " Total episodes: " + episodes;
	}
}
