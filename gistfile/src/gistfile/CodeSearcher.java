package gistfile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;

public class CodeSearcher implements CodeSearchEngineFile {

	public class Location implements CodeSearchEngine.Location {

		private final String filePath;
		private final int lineNumber;

		public Location(final String filePath, final int lineNumber) {
			super();
			this.filePath = filePath;
			this.lineNumber = lineNumber;
		}

		@Override
		public String getFilePath() {
			return filePath;
		}

		@Override
		public int getLineNumber() {
			return lineNumber;
		}

	}

	public class Type implements CodeSearchEngine.Type {

		private final String name;
		private final String fullyQualifiedPackageName;
		private final gistfile.CodeSearchEngine.TypeKind kind;
		private final Location declaration;

		public Type(final String name, final String fullyQualifiedPackageName,
				final gistfile.CodeSearchEngine.TypeKind kind,
				final Location declaration) {
			super();
			this.name = name;
			this.fullyQualifiedPackageName = fullyQualifiedPackageName;
			this.kind = kind;
			this.declaration = declaration;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getFullyQualifiedPackageName() {
			return fullyQualifiedPackageName;
		}

		@Override
		public gistfile.CodeSearchEngine.TypeKind getKind() {
			return kind;
		}

		@Override
		public Location getDeclaration() {
			return declaration;
		}

	}

	public class Member implements CodeSearchEngine.Member {

		private final Type type;
		private final String name;

		public Member(final Type type, final String name) {
			super();
			this.type = type;
			this.name = name;
		}

		@Override
		public Type getType() {
			return type;
		}

		@Override
		public String getName() {
			return name;
		}

	}

	public org.jdom2.Document init(final File f) throws JDOMException,
			IOException {
		final SAXBuilder sxb = new SAXBuilder();
		final org.jdom2.Document doc = sxb.build(f);
		return doc;
	}

	@SuppressWarnings("deprecation")
	@Override
	public gistfile.CodeSearchEngine.Type findType(final String className,
			final File data) {
		final Type type;
		try {
			final Element racine = init(data).getRootElement();
			final XPath xpa = XPath.newInstance("//type/[name=\"" + className
					+ "\"]");
			xpa.selectNodes(racine);

			// type = new Type(xpa., className, null, null);
		} catch (final JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<gistfile.CodeSearchEngine.Type> findSubTypesOf(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<gistfile.CodeSearchEngine.Method> findMethodsOf(
			final String className, final File data) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<gistfile.CodeSearchEngine.Type> findClassesAnnotatedWith(
			final String annotationName, final File data) {
		// TODO Auto-generated method stub
		return null;
	}

}
