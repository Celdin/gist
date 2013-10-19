package gistfile;

import gistfile.CodeSearchEngine.Method;
import gistfile.CodeSearchEngine.Type;

import java.util.List;

public class MethodImp implements Method {

	private final Type type;

	@Override
	public String toString() {
		return "MethodImp [type=" + type + ", name=" + name + ", paramaters="
				+ paramaters + "]";
	}

	private final String name;
	private final List<Type> paramaters;

	public MethodImp(final Type type, final String name,
			final List<Type> paramaters) {
		super();
		this.type = type;
		this.name = name;
		this.paramaters = paramaters;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Type> getParamaters() {
		return paramaters;
	}

}
