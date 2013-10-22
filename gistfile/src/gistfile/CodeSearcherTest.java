package gistfile;

import static org.junit.Assert.assertEquals;
import gistfile.CodeSearchEngine.Method;
import gistfile.CodeSearchEngine.Type;
import gistfile.CodeSearchEngine.TypeKind;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.junit.Test;

public class CodeSearcherTest {

	@Test
	public void testFindSubTypeOf() throws JDOMException, IOException {
		final CodeSearcher test = new CodeSearcher();
		final List<Type> t = test.findSubTypesOf("RuntimeException", new File(
				"src/resource/org.apache.commons.collections-3.1.xml"));
		System.out.println(t);
		assertEquals(2, t.size());
		assertEquals("FunctorException", t.get(0).getName());
		assertEquals("BufferOverflowException", t.get(1).getName());
	}

	@Test
	public void testFindType() throws JDOMException, IOException {
		final CodeSearcher test = new CodeSearcher();
		final TypeImp t = (TypeImp) test.findType("AVLNode", new File(
				"src/resource/org.apache.commons.collections-3.1.xml"));
		assertEquals("AVLNode", t.getName());
		// assertEquals("",t.getFullyQualifiedPackageName());
		assertEquals(TypeKind.CLASS, t.getKind());
		// assertEquals("",t.getDeclaration());
		System.out.println("findTYpe" + t);
	}

	@Test
	public void testFindMethodsOf() throws JDOMException, IOException {
		final CodeSearcher test = new CodeSearcher();
		final List<Method> t = test.findMethodsOf("CollectionUtils", new File(
				"src/resource/org.apache.commons.collections-3.1.xml"));
		assertEquals(47, t.size());
		Method tester = t.get(0);
		assertEquals("union", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		assertEquals(TypeKind.CLASS, tester.getType().getKind());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(1);
		assertEquals("intersection", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(2);
		assertEquals("disjunction", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(3);
		assertEquals("subtract", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(4);
		assertEquals("containsAny", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		assertEquals(TypeKind.PRIMITIVE, tester.getType().getKind());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(5);
		assertEquals("getCardinalityMap", tester.getName());
		assertEquals("Map", tester.getType().getName());
		assertEquals(TypeKind.CLASS, tester.getType().getKind());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		tester = t.get(6);
		assertEquals("isSubCollection", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(7);
		assertEquals("isProperSubCollection", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(8);
		assertEquals("isEqualCollection", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(9);
		assertEquals("cardinality", tester.getName());
		assertEquals("int", tester.getType().getName());
		assertEquals(TypeKind.PRIMITIVE, tester.getType().getKind());
		assertEquals("Object", tester.getParamaters().get(0).getName());
		assertEquals("Collection", tester.getParamaters().get(1).getName());
		tester = t.get(10);
		assertEquals("find", tester.getName());
		assertEquals("Object", tester.getType().getName());
		assertEquals(TypeKind.CLASS, tester.getType().getKind());
		assertEquals("Collection", tester.getParamaters().get(0).getName());
		assertEquals("Predicate", tester.getParamaters().get(1).getName());
		tester = t.get(11);
		assertEquals("forAllDo", tester.getName());
		assertEquals("void", tester.getType().getName());
		assertEquals(TypeKind.PRIMITIVE, tester.getType().getKind());
		tester = t.get(12);
		assertEquals("filter", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(13);
		assertEquals("transform", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(14);
		assertEquals("countMatches", tester.getName());
		assertEquals("int", tester.getType().getName());
		tester = t.get(15);
		assertEquals("exists", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		tester = t.get(16);
		assertEquals("select", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(17);
		assertEquals("select", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(18);
		assertEquals("selectRejected", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(19);
		assertEquals("selectRejected", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(20);
		assertEquals("collect", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(21);
		assertEquals("collect", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(22);
		assertEquals("collect", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(23);
		assertEquals("collect", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(24);
		assertEquals("addIgnoreNull", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		tester = t.get(25);
		assertEquals("addAll", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(26);
		assertEquals("addAll", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(27);
		assertEquals("addAll", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(28);
		assertEquals("index", tester.getName());
		assertEquals("Object", tester.getType().getName());
		tester = t.get(29);
		assertEquals("index", tester.getName());
		assertEquals("Object", tester.getType().getName());
		tester = t.get(30);
		assertEquals("index", tester.getName());
		assertEquals("Object", tester.getType().getName());
		tester = t.get(31);
		assertEquals("get", tester.getName());
		assertEquals("Object", tester.getType().getName());
		tester = t.get(32);
		assertEquals("size", tester.getName());
		assertEquals("int", tester.getType().getName());
		tester = t.get(33);
		assertEquals("sizeIsEmpty", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		tester = t.get(34);
		assertEquals("isEmpty", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		tester = t.get(35);
		assertEquals("isNotEmpty", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		tester = t.get(36);
		assertEquals("reverseArray", tester.getName());
		assertEquals("void", tester.getType().getName());
		tester = t.get(37);
		assertEquals("getFreq", tester.getName());
		assertEquals("int", tester.getType().getName());
		tester = t.get(38);
		assertEquals("isFull", tester.getName());
		assertEquals("boolean", tester.getType().getName());
		tester = t.get(39);
		assertEquals("maxSize", tester.getName());
		assertEquals("int", tester.getType().getName());
		tester = t.get(40);
		assertEquals("retainAll", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(41);
		assertEquals("removeAll", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(42);
		assertEquals("synchronizedCollection", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(43);
		assertEquals("unmodifiableCollection", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(44);
		assertEquals("predicatedCollection", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(45);
		assertEquals("typedCollection", tester.getName());
		assertEquals("Collection", tester.getType().getName());
		tester = t.get(46);
		assertEquals("transformedCollection", tester.getName());
		assertEquals("Collection", tester.getType().getName());

	}
}
