package com.uptodate.bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.uptodate.Main;
import com.uptodate.entities.SearchResult;
import com.uptodate.entities.SynonymCollection;
import com.uptodate.exceptions.SynonymNotFoundException;

public class SearchEngine {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchEngine.class);
	
	public void search(String searchTerm) {
		
		String[] results = null;
		SynonymCollection synonymsCache = SynonymCollectionBuilder.build();
		if(logger.isDebugEnabled())
			synonymsCache.printSynonyms();
		
		try {
			Set<String> matchingSynonyms = synonymsCache.getSynonyms(searchTerm);
			if(logger.isDebugEnabled())
				logger.debug("Found: " + Joiner.on(",").join(matchingSynonyms));
			
			// Process the quotes
			
			QuotesProcessor processor = new QuotesProcessor(matchingSynonyms);
			SearchResult[] searchResults = processor.processQuotes();
			Arrays.sort(searchResults);
			
			results = formatSearchResults(searchResults);
			for(String s : results) {
				System.out.println(s);
			}
			

		}catch(SynonymNotFoundException ex) {
			if(logger.isDebugEnabled())
				logger.debug("Exception: " + ex.getMessage());
			System.out.println(ex.getMessage());
		}

	}
	
    public static String[] formatSearchResults(SearchResult[] searchResults) {
    	ArrayList<String> results = new ArrayList<String>();
    	for(SearchResult searchResult : searchResults) {
    		String result = searchResult.getQuoteId() + "   " + searchResult.getMatchingWord();
    		if(logger.isDebugEnabled()) {
    			logger.debug(result);
    		}
    		results.add(result);
    	}
    	return (results.toArray(new String[results.size()]));
    }
	

}
