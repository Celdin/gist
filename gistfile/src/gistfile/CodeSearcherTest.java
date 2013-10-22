package gistfile;

import static org.junit.Assert.*;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

import org.jdom2.JDOMException;
import org.junit.Test;


public class CodeSearcherTest {

	@Test
	public void testFindType() throws JDOMException, IOException {
		CodeSearcher test = new CodeSearcher();
		TypeImp t =  (TypeImp) test.findType("SortedMapBackedCache", new File("src/resource/lucene.xml"));
		assertEquals("SortedMapBackedCache",t.getName());
	}
	@Test
	public void testFindSubType() throws JDOMException, IOException {
		CodeSearcher test = new CodeSearcher();
		java.util.List<gistfile.CodeSearchEngine.Type> t =   (java.util.List<gistfile.CodeSearchEngine.Type>) test.findSubTypesOf("Exception",  new File("src/resource/lucene.xml"));
		assertEquals("SolrServerException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(0).getName());
		assertEquals("FieldMappingException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(1).getName());
		assertEquals("HyphenationException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(2).getName());
		assertEquals("ParseException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(3).getName());
		assertEquals("NoMoreDataException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(4).getName());
		assertEquals("InconsistentTaxonomyException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(5).getName());
		assertEquals("ParserException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(6).getName());
		assertEquals("ParseException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(7).getName());
		assertEquals("ParseException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(10).getName());
		assertEquals("QueryNodeException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(8).getName());
		assertEquals("QueryNodeParseException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(9).getName());
		assertEquals("ParseException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(11).getName());
		assertEquals("InvalidTokenOffsetsException",((java.util.List<gistfile.CodeSearchEngine.Type>) t).get(12).getName());

	}
}
