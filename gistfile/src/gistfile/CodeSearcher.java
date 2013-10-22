package gistfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;

public class CodeSearcher implements CodeSearchEngineFile {
	String path;

	public org.jdom2.Document init(final File f) throws JDOMException,
			IOException {
		path = f.getAbsolutePath();
		final SAXBuilder sxb = new SAXBuilder();
		final org.jdom2.Document doc = sxb.build(f);
		return doc;
	}

	@SuppressWarnings("deprecation")
	@Override
	public gistfile.CodeSearchEngine.Type findType(final String className,
			final File data) throws JDOMException, IOException {
		final Type type;
		final Element racine = init(data).getRootElement();
		XPath xpa = XPath.newInstance("//*[name=\"" + className + "\"]/*");

		final List<?> res = xpa.selectNodes(racine);
		if (res.iterator().hasNext()) {
			final Element noeudCourant = (Element) res.iterator().next();

			/*
			 * xpa = XPath.newInstance("../type/name"); final String name =
			 * xpa.valueOf(noeudCourant);*
			 */
			final String name = className;
			xpa = XPath.newInstance("..");
			final TypeKind kind;
			if (noeudCourant.getNamespace().toString().contains("class")) {
				kind = TypeKind.CLASS;
			} else if (xpa.valueOf(noeudCourant).contains("interface")) {
				kind = TypeKind.INTERFACE;
			} else if (xpa.valueOf(noeudCourant).contains("enum")) {
				kind = TypeKind.ENUM;
			} else if (xpa.valueOf(noeudCourant).contains("exeption")) {
				kind = TypeKind.EXCEPTION;
			} else if (xpa.valueOf(noeudCourant).contains("annotation")) {
				kind = TypeKind.ANNOTATION;
			} else if (xpa.valueOf(noeudCourant).contains("primitive")) {
				kind = TypeKind.PRIMITIVE;
			} else {
				kind = null;
			}
			final LocationImp declaration = new LocationImp(path);

			type = new TypeImp(className, "", kind, null);

			return type;
		}
		return new TypeImp(className, "", null, null);
	}

	@Override
	// probleme avec la recursivité
	public List<gistfile.CodeSearchEngine.Type> findSubTypesOf(
			final String className, final File data) throws JDOMException,
			IOException {
		// TODO Auto-generated method stub
		final List<Type> listType = new ArrayList<CodeSearchEngine.Type>();
		final Element racine = init(data).getRootElement();
		XPath xpa = XPath.newInstance("//class[super//name=\"" + className
				+ "\"]");
		final List res = xpa.selectNodes(racine);
		final Iterator iter = res.iterator();

		Element noeudCourant = null;
		while (iter.hasNext()) {
			noeudCourant = (Element) iter.next();
			xpa = XPath.newInstance("./name");
			final String loc = xpa.valueOf(noeudCourant);

			final Type type = new TypeImp(loc, "", TypeKind.CLASS, null);

			listType.add(type);
			listType.addAll(findSubTypesOfRec(loc, racine));

		}

		return listType;
	}

	public List<gistfile.CodeSearchEngine.Type> findSubTypesOfRec(
			final String className, final Element racine) throws JDOMException,
			IOException {
		// TODO Auto-generated method stub
		final List<Type> listType = new ArrayList<CodeSearchEngine.Type>();
		XPath xpa = XPath.newInstance("//class[super//name=\"" + className
				+ "\"]");
		final List res = xpa.selectNodes(racine);
		final Iterator iter = res.iterator();

		Element noeudCourant = null;
		while (iter.hasNext()) {
			noeudCourant = (Element) iter.next();
			xpa = XPath.newInstance("./name");
			final String loc = xpa.valueOf(noeudCourant);

			final Type type = new TypeImp(loc, "", TypeKind.CLASS, null);

			listType.add(type);
			listType.addAll(findSubTypesOfRec(loc, racine));

		}

		return listType;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Field> findFieldsTypedWith(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Location> findAllReadAccessesOf(
			final gistfile.CodeSearchEngine.Field field, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Location> findAllWriteAccessesOf(
			final gistfile.CodeSearchEngine.Field field, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<gistfile.CodeSearchEngine.Method> findMethodsOf(
			final String className, final File data) throws JDOMException,
			IOException {
		final List<Method> list = new ArrayList<Method>();
		final Element racine = init(data).getRootElement();
		String name = "";
		String type = "";
		MethodImp method;
		XPath xpa = XPath.newInstance("//class[name=\"" + className
				+ "\"]/*/function");
		final List<?> res = (xpa.selectNodes(racine));
		Element noeudCourant;
		final Iterator<?> its = res.iterator();
		while (its.hasNext()) {
			noeudCourant = (Element) its.next();
			xpa = XPath.newInstance("type/name");
			type = xpa.valueOf(noeudCourant);
			xpa = XPath.newInstance("./name");
			name = xpa.valueOf(noeudCourant);

			xpa = XPath.newInstance("./parameter_list");
			if (xpa.valueOf(noeudCourant).contains("()")) {
				method = new MethodImp(new TypeImp((TypeImp) findType(type,
						data)), name, null);
			} else {
				xpa = XPath.newInstance("./*/param");
				final Iterator<?> its2 = xpa.selectNodes(noeudCourant)
						.iterator();
				final List<Type> types = new ArrayList<Type>();
				while (its2.hasNext()) {
					noeudCourant = (Element) its2.next();
					xpa = XPath.newInstance("./*/type/name");
					types.add(findType(xpa.valueOf(noeudCourant), data));
				}
				method = new MethodImp(new TypeImp((TypeImp) findType(type,
						data)), name, types);
			}
			list.add(method);
		}
		return list;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Method> findMethodsReturning(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Method> findMethodsTakingAsParameter(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Method> findMethodsCalled(
			final String methodName, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Method> findOverridingMethodsOf(
			final gistfile.CodeSearchEngine.Method method, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Location> findNewOf(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Location> findCastsTo(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Location> findInstanceOf(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Method> findMethodsThrowing(
			final String exceptionName, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Location> findCatchOf(
			final String exceptionName, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

}
