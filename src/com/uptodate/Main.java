package com.uptodate;

import java.util.Arrays;
import java.util.ResourceBundle;

import com.uptodate.entities.SearchResult;
/**
 * 
 * @author drifai
 * 
 * Plan of attack
 * 
 * (1) code simple case
 * (2) code synonyms
 * (3) read in resource bundles
 * (4) edge cases
 * (5) build synonym cache
 *
 */

public class Main {

	public static void main(String[] args) {

		
		// You can read the search term just from the program arguments
		String searchTerm = args[0];
//		String[] quote = {"quote.53=Life is not measured by the number of breaths we take, but by the moments that take our breath away. ñMaya Angelou",
//				          "quote.6=You miss 100% of the shots you don't take. Wayne Gretzky"};
		String[] quote ={"quote.53=Life is not measured by the number of breaths we take, but by the moments that take our breath away. ñMaya Angelou"};
		
		
		System.out.println("Args: " + args[0]);
		
		SearchResult result = search(searchTerm, quote);
		
		ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", currentLocale);
		Enumeration bundleKeys = labels.getKeys();

		while (bundleKeys.hasMoreElements()) {
		    String key = (String)bundleKeys.nextElement();
		    String value = labels.getString(key);
		    System.out.println("key = " + key + ", " + "value = " + value);
		}
		
		
		// TODO use resource file
		// You can read the properties files as ResourceBundles if they are part of the class path
		//ResourceBundle synonymsBundle = ResourceBundle.getBundle("synonyms");
		//ResourceBundle quotesBundle = ResourceBundle.getBundle("quotes");
	}
	
	static SearchResult search(String searchTerm, String[] quoteInput) {
		System.out.println("Inputs: ");
		System.out.println("Search term: " + searchTerm);
		System.out.println("Quote part: " + Arrays.toString(quoteInput));
		
		SearchResult result = null;
		
		for(String s : quoteInput) {
		
			String[] quoteParts = s.split("=");
			String quote = quoteParts[1];
			System.out.println("Quote: " + quote);
			

			if(quote.indexOf(searchTerm) > -1) {
				if(result == null ) {
					result = new SearchResult();
					result.setKey(searchTerm);
				}
				result.addValue("quote.53");
			}
		}
		if(result == null) {
			System.out.println("Search term: " + searchTerm + " not found.");
		}
		return result;

		
	}
	

}