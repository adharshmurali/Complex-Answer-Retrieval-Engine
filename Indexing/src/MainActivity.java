/* The class is the main class that takes the text from the paragraph and sends to the 
 * helper class where the function to create the index is written.
 * The class is the initializer of the action and the helper class is the performer of the a
 * action.
 */
import edu.unh.cs.treccar_v2.Data;
import edu.unh.cs.treccar_v2.read_data.CborFileTypeException;
import edu.unh.cs.treccar_v2.read_data.CborRuntimeException;
import edu.unh.cs.treccar_v2.read_data.DeserializeData;

import java.io.FileInputStream;
import java.io.File;
public class MainActivity {

	// The main function is directly called as there is no need for the Constructor in the class.
	public static void main( String [] args) throws Exception{
		// The file is read using the inputstream and the data from the input stream is to desearlized for the analysis
		//Data.Page g = null;
		FileInputStream fs =new FileInputStream(new File("F:/TREC CAR/benchmarkY1-test.v2.0.tar/benchmarkY1-test.v2.0/benchmarkY1/benchmarkY1-test/test.pages.cbor-paragraphs.cbor"));
		// Now deserializing the data from the stream
		Helper h=new Helper();
		if (h.find()){
		for (Data.Paragraph p: DeserializeData.iterableParagraphs(fs)){
			
		//For every paragraph send the paragraph Id and the paragraph text to which
			// THe index is to be created.
			
			h.Indexer(p.getParaId(), p.getTextOnly());
			
	}
		
		//System.out.print(g.);
	}
	//Search for the term candy
		h.searcher("making");
	}
	
}
