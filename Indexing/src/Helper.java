// The helper class is a public class in which the function for search and the index is to written.

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriterConfig;
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

public class Helper   {

	public Helper() throws Exception{
		// The new File is the index directory where the data will be indexed for the application.
		//Path p=Paths.get("F:/new_File");
	}
	
	// The function is used to create the Index for the webpage with the paraId and the 
	//Paragraph
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
	
}
