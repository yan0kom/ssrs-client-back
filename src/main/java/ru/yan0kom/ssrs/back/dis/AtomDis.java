package ru.yan0kom.ssrs.back.dis;

/** The device information settings for the Atom rendering extension support submittal of the name of an Atom feed and character encoding to use. */
public class AtomDis extends DeviceInformationSettings {
	private String dataFeed;
	private String encoding;

	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "DataFeed", dataFeed);
		addParameter(sb, "Encoding", encoding);
	}

	public String getDataFeed() {
		return dataFeed;
	}

	/** If specified, renders the Atom feed corresponding to the feed name provided in this setting. If not, renders the Atom service document for the report. The unique auto-generated identifier of the data feed. This value is used internally and you should not change it. */	
	public void setDataFeed(String dataFeed) {
		this.dataFeed = dataFeed;
	}

	public String getEncoding() {
		return encoding;
	}

	/** The Internet Assigned Numbers Authority (IANA) name of a character encoding that is supported by the .NET Framework. The default value is UTF-8. Examples of other values include ASCII, UTF-7, and UTF-16. */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

}
