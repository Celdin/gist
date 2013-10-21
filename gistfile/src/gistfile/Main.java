package gistfile;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;

public class Main {
	public static void main(final String[] args) throws JDOMException,
			IOException {
		final CodeSearcher searcher = new CodeSearcher();
		//System.out.println(searcher.findMethodsOf("AbstractAction", new File(
		//		"src/resource/jface.xml")));
		System.out.println(searcher.findSubTypesOf("Exception",  new File("src/resource/lucene.xml")));
	}
}
