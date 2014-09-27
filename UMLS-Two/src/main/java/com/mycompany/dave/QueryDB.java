package com.mycompany.dave;

import java.util.List;

public interface QueryDB {

	public String retreiveDefinition(String cui) throws Exception;
	public List<String> retreiveSynonyms(String cui) throws Exception;
	public List<String> retreiveSemanticType(String cui) throws Exception;
	
	
	
}
