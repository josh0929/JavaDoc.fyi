package com.lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import static jdk.nashorn.internal.objects.NativeString.search;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author Josh0
 */
public class Searcher
{
	IndexReader reader;
	IndexSearcher searcher;
	QueryParser parser;
	Analyzer analyzer;
	BufferedReader in;
	Query query;
	
	public Searcher(String indexDirectoryPath) throws IOException
	{
		reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDirectoryPath)));
		searcher = new IndexSearcher(reader);
		analyzer = new StandardAnalyzer();
		in = null;
	}
	
	public TopDocs search(String queryString) throws ParseException, IOException
	{
		QueryParser parser = new QueryParser(queryString, analyzer);
		query = parser.parse(queryString);
		return searcher.search(query, Constants.MAX_SEARCH);
	}
	
//	public Document getDocument(ScoreDoc doc)
//	{
//		return searcher.doc(doc);
//	}
//	
	
}
