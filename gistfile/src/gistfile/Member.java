package gistfile;

import gistfile.CodeSearchEngine.Type;


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
