package gistfile;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;

public class Main {
	public static void main(final String[] args) throws JDOMException,
			IOException {
		final CodeSearcher searcher = new CodeSearcher();
		System.out.println(searcher.findType("getJavaLangAccess", new File(
				"src/resource/java.xml")));
		System.out.println(searcher.findMethodsOf("LineReader", new File(
				"src/resource/java.xml")));
	}
}
