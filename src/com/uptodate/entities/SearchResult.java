package com.uptodate.entities;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
	String key;
	List<String> values = new ArrayList<String>();
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String[] getValues() {
		return(values.toArray(new String[values.size()]));
	}
	
	public void addValue(String value) {
		values.add(value);
	}
	
	public String toString() {
		// overkill for just 2 attributes, assumes additional attributes
		StringBuilder sb = new StringBuilder();
		//System.out.println("Outputs: " );
		sb.append("Search term: " + getKey());
		sb.append(" Found in: " + getValues());
		return(sb.toString());
	}

}
