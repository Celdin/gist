package gistfile;

public class LocationImp implements CodeSearchEngine.Location {

	private final String filePath;
	private final int lineNumber=0;

	public LocationImp(final String filePath) {
		super();
		this.filePath = filePath;
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