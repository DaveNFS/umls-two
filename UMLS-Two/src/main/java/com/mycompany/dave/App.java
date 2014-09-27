package com.mycompany.dave;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        CUI c = new CUI();
        String cui = "C0032344";
        
        System.out.println(cui);
        System.out.println("----------");
        System.out.println("Definition: ");
        System.out.println(c.retreiveDefinition(cui));
        System.out.println("----------");
        
        System.out.println("Synonyms:");
        ArrayList<String> syn = (ArrayList<String>) c.retreiveSynonyms(cui);
        for(String x:syn)
        {
        	System.out.println(x);
        }
        
        System.out.println("----------");
        
        System.out.println("Semantic Types:");
        ArrayList<String> sty = (ArrayList<String>) c.retreiveSemanticType(cui);
        for(String x:sty)
        {
        	System.out.println(x);
        }
        
        
    }
}
