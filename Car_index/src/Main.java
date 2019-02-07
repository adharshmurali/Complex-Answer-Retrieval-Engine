// Writing my java application to extract the data from the wikipedia paragraphs and 
//Indexing those paragraph using the lucene 
//import java.io.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory; 
import org.apache.lucene.analysis.Analyzer;
import edu.unh.cs.treccar_v2.Data;
import edu.unh.cs.treccar_v2.read_data.CborFileTypeException;
import edu.unh.cs.treccar_v2.read_data.CborRuntimeException;
import edu.unh.cs.treccar_v2.read_data.DeserializeData;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Iterator;
public class Main {
	
	public static void main(String [] args ) throws Exception{
	// The application revolves around extracting the paragraphs from the paragraph list
	
	/* The system takes the paragraph and pre-process the data and create an index for the analysis
	 considering every paragraph as an document.*/	
		
		// Lets write a single parameter constructor that takes in the index location
		// and creates a writer that can store and retrieve documents from the index.
		//private IndexWriter indwrite;
		
		
		int count=0;
		final FileInputStream fs=new FileInputStream(new File("F:/TREC CAR/benchmarkY1-test.v2.0.tar/benchmarkY1-test.v2.0/benchmarkY1/benchmarkY1-test/test.pages.cbor-paragraphs.cbor"));
		for (Data.Paragraph para : DeserializeData.iterableParagraphs(fs)) {
			count=count+1;
			
			
		}
System.out.print(count);
	}
}
