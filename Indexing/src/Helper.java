// The helper class is a public class in which the function for search and the index is to written.

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory; 
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.queryparser.classic.*;

public class Helper   {

	public  Helper() throws Exception{
		// The new File is the index directory where the data will be indexed for the application.
		//Path p=Paths.get("F:/new_File");
		//File f =new File("F:/new_file");
		
		}
	
	// The function is used to create the Index for the webpage with the paraId and the 
	//Paragraph
	public boolean find(){
		File f =new File ("F:/new_file");
		if (f.exists()){
			return (false);
			
		}
		else{
			return (true);
		}
	}
	public void Indexer(String paraID, String Paragraph) throws Exception{
		// Creating a index writer to write the index
		StandardAnalyzer wh=new StandardAnalyzer();
		Directory dir=FSDirectory.open((Paths.get("F:/new_file")));
		
		IndexWriterConfig indexWriterConf = new IndexWriterConfig( wh);
        indexWriterConf.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        IndexWriter indexWriter = new IndexWriter(dir, indexWriterConf);
        Document doc = new Document();
        doc.add(new StoredField("id", paraID ));
        doc.add(new TextField("text", Paragraph,Field.Store.YES));
        indexWriter.addDocument(doc);
        indexWriter.close();
	}
	
	// Implementing the function for reproducing the search function.
	/**
	 * The steps to create a search function includes:
	 * First open the Lucene index 
	 * Next create a query_parser object to query the index
	 * Next get the top hits for the given query
	 * Now display the top docs for the given query
	 */
	
	public void searcher(String query)throws Exception{
		// Opening the index using the FSdirectory object
		Directory idx=FSDirectory.open(Paths.get("F:/new_file") );
		IndexReader idr=DirectoryReader.open(idx);
		IndexSearcher is=new IndexSearcher(idr);
		//Now setting the similarity to BM25 search similarity.
		is.setSimilarity(new BM25Similarity());
		// Now opening the query parser for the application
		QueryParser qp=new QueryParser("text",new StandardAnalyzer());
		Query q=qp.parse(query);
		long start = System.currentTimeMillis();
		TopDocs hits = is.search(q, 10);
		long end = System.currentTimeMillis();
		System.err.println("Found " + hits.totalHits +
		" document(s) (in " + (end - start) +
		" milliseconds) that matched query '" +
		q + "':");
		for(ScoreDoc scoreDoc : hits.scoreDocs) {
		Document doc = is.doc(scoreDoc.doc);
		System.out.println(doc.get("text"));
		}
		idx.close();
	}
	
	
}
