package com.lucene;

import java.io.IOException;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.TopDocs;

/**
 *
 * @author Josh0
 */
public class Main
{
	String indexDir = "C:\\Users\\Josh0\\Documents\\NetBeansProjects\\"
		   + "javadoc.fyi\\index";
	String dataDir = "C:\\Users\\Josh0\\Documents\\NetBeansProjects\\"
		   + "javadoc.fyi\\project docs";
	
	public static void main(String [] args) throws IOException, ParseException
	{
		Main main = new Main();
		
		main.createIndex();
		main.searchIndex();
	}
	
	private void createIndex() throws IOException
	{
		Indexer indexer = new Indexer(indexDir, dataDir);
	}
	
	private void searchIndex() throws IOException, ParseException
	{
		Searcher searcher = new Searcher(indexDir);
		TopDocs hits =	searcher.search("the");
		System.out.println(hits.totalHits + " documents found.");
	}
	
}
