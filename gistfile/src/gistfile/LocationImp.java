package gistfile;

public class LocationImp implements CodeSearchEngine.Location {

	private final String filePath;
	private final int lineNumber;

	public LocationImp(final String filePath, final int lineNumber) {
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