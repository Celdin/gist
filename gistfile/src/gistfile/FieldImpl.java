package gistfile;

import gistfile.CodeSearchEngine.Field;
import gistfile.CodeSearchEngine.Type;


public class FieldImpl implements Field {
Type t;
String name;
	@Override
	public Type getType() {
		return t;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name	;
	}
}
