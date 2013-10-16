package gistfile;

import gistfile.CodeSearchEngine.Location;


public class TypeImp implements CodeSearchEngine.Type {

	private final String name;
	private final String fullyQualifiedPackageName;
	private final gistfile.CodeSearchEngine.TypeKind kind;
	private final Location declaration;

	public TypeImp(final String name, final String fullyQualifiedPackageName,
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
