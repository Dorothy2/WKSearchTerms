package com.uptodate.entities;

public class SearchResult implements Comparable<SearchResult> {
	private String quoteId;
	private int quoteIdIndex;
	private String matchingWord;
	
	public String getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(String quoteId) {
		
		this.quoteId = quoteId;
		String[] parts = quoteId.split("\\.");
		 
		try {
			this.quoteIdIndex = Integer.parseInt(parts[1]);
		}catch(NumberFormatException ex) {
		    // affects correct sort in output but does not stop processing
			quoteIdIndex = 0;
		}
	}
	
	public int getQuoteIdIndex() {
		return quoteIdIndex;
	}
	public String getMatchingWord() {
		return matchingWord;
	}
	public void setMatchingWord(String matchingWord) {
		this.matchingWord = matchingWord;
	}
	
	@Override
	public int compareTo(SearchResult o) {
		if (this.getQuoteIdIndex() > o.getQuoteIdIndex())
			return 1;
		else if (this.getQuoteIdIndex() < o.getQuoteIdIndex())
			return -1;
		else
			return 0;
	}
	
}
