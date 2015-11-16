package com.uptodate.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uptodate.exceptions.SynonymNotFoundException;

public class SynonymCollection {
	private static final Logger logger = LoggerFactory.getLogger(SynonymCollection.class);
	
	private HashMap<String, Set<String>> synonyms = new HashMap<String, Set<String>>();
	
	public Set<String> getSynonyms(String lookupWord) throws SynonymNotFoundException {
		Set<String> matchingSynonyms = synonyms.get(lookupWord);
		if(matchingSynonyms == null)
			throw new SynonymNotFoundException("No synonym exists for: " + lookupWord);
		return synonyms.get(lookupWord);
	}
	
	public void add(List<String> relatedWords) {
		for(String s : relatedWords) {
			synonyms.put(s, new HashSet<String>(relatedWords));
		}
	}
	
	public void printSynonyms() {
		Iterator<String> iterator = synonyms.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			Set<String> values = synonyms.get(key);
			logger.debug("Key: " + key + " values: " + values);
		}
		
	}
}
