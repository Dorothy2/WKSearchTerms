package com.uptodate.bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.uptodate.entities.SearchResult;

public class QuotesProcessor {
	public final static Logger logger = LoggerFactory.getLogger(QuotesProcessor.class);
	
	Set<String> matchingSynonyms;

	public QuotesProcessor(Set<String> matchingSynonyms) {
		this.matchingSynonyms = matchingSynonyms;
	}

	public SearchResult[] processQuotes() {
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		ResourceBundle quotes = ResourceBundle.getBundle("quotes");
		Enumeration<String> quotesKeys = quotes.getKeys();
		
		while(quotesKeys.hasMoreElements()) {
			String key = (String) quotesKeys.nextElement();
			String valueStr = quotes.getString(key);
			String[] splited = valueStr.split("\\b+"); //split on word boundaries
			Set<String> mySet = new HashSet<String>(Arrays.asList(splited));
			Set<String> intersectingStrings = Sets.intersection(matchingSynonyms, mySet);

			
			if(intersectingStrings.size() > 0) {
				SearchResult result = new SearchResult();
				
				result.setMatchingWord(Joiner.on(",").join(intersectingStrings));
				result.setQuoteId(key);
				searchResults.add(result);
			}
			
		}
		SearchResult[] array = searchResults.toArray(new SearchResult[searchResults.size()]);
		return(array);
	}
	
	public static List<String> ReadInputQuotes() {
		List<String> quoteCollection = new ArrayList<String>();
		ResourceBundle quotes = ResourceBundle.getBundle("quotes");
		logger.debug("Quotes " + quotes.keySet());
		Enumeration<String> quotesKeys = quotes.getKeys();
		
		while(quotesKeys.hasMoreElements()) {
			String key = (String) quotesKeys.nextElement();
			String valueStr = quotes.getString(key);
			quoteCollection.add(valueStr);
		}
		
		return(quoteCollection);
	}
}
