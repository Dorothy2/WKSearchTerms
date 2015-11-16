package com.uptodate.bus;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.uptodate.entities.SynonymCollection;

public class SynonymCollectionBuilder {
	

	public static SynonymCollection build() {
		return SynonymCollectionBuilder.getSynonyms();
	}
	
	public static SynonymCollection getSynonyms() {
		SynonymCollection collection = new SynonymCollection();
		HashMap<String, List<String>> inputs = ReadInputSynonymList();
 
		Iterator<String> cacheValues = inputs.keySet().iterator();
		
		while(cacheValues.hasNext()) {
			String key = cacheValues.next();
			List<String> inputList = inputs.get(key);
			collection.add(inputList);
		}
		return(collection);
	}
	
	public static HashMap<String, List<String>> ReadInputSynonymList() {
		HashMap<String, List<String>> cache = new HashMap<String, List<String>>();
		// You can read the properties files as ResourceBundles if they are part of the class path
		ResourceBundle synonymsBundle = ResourceBundle.getBundle("synonyms");
		Enumeration<String> bundleKeys = synonymsBundle.getKeys();

		while (bundleKeys.hasMoreElements()) {
		    String key = (String)bundleKeys.nextElement();
		    String valueStr = synonymsBundle.getString(key);
		    String[] values = valueStr.split(",");
		    List<String> valueList = Arrays.asList(values);
		    cache.put(key, valueList);
		}

		return(cache);
	}
}
