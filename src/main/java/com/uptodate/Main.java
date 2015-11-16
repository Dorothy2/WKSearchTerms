package com.uptodate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uptodate.bus.SearchEngine;
import com.uptodate.exceptions.InputArgumentNotFoundException;

public class Main {
	
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws InputArgumentNotFoundException {
		// You can read the search term just from the program arguments
		if(args.length == 0) {
			System.out.println("Input argument was not passed.");
			System.exit(-1);
		}
		String searchTerm = args[0];
		logger.debug("Search term: " + searchTerm);
		
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.search(searchTerm);
	}
}