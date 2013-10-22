package gistfile;

import gistfile.CodeSearchEngine.Field;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;

public class Main {
	public static void main(final String[] args) throws JDOMException,
			IOException {
		CodeSearcher test=new CodeSearcher (new File("src/resource/lucene.xml"));
		FieldImpl f = new FieldImpl();
		f.name = "boost";
		System.out.println(test.findAllReadAccessesOf(f, new File("src/resource/lucene.xml")));
		//final CodeSearcher searcher = new CodeSearcher();
		//System.out.println(searcher.findMethodsOf("AbstractAction", new File(
		//		"src/resource/jface.xml")));
		//System.out.println(searcher.findSubTypesOf("Exception",  new File("src/resource/lucene.xml")));
		//System.out.println(searcher.findType("SortedMapBackedCache", new File("src/resource/lucene.xml")));
	}
}
