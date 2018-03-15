package ru.yan0kom.ssrs.back.dis;

/** The device information settings for the CSV rendering extension allow delimiters and qualifiers to be changed and line break handling to be specified. The extension of the file can also be submitted, as well as the encoding and inclusion of header rows in the output. Because delimiters are likely to be special characters, you should encode them in a CDATA section, if the settings are written as XML. */
public class CsvDis extends DeviceInformationSettings {
	private String encoding;
	private Boolean excelMode;
	private String fieldDelimiter;
	private String fileExtension;
	private Boolean noHeader;
	private String qualifier;
	private String recordDelimiter;
	private Boolean suppressLineBreaks;
	private Boolean useFormattedValues;

	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "Encoding", encoding);
		addParameter(sb, "ExcelMode", excelMode);
		addParameter(sb, "FieldDelimiter", fieldDelimiter, "xml:space=\"preserve\"");
		addParameter(sb, "FileExtension", fileExtension);
		addParameter(sb, "NoHeader", noHeader);
		addParameter(sb, "Qualifier", qualifier, "xml:space=\"preserve\"");
		addParameter(sb, "RecordDelimiter", recordDelimiter, "xml:space=\"preserve\"");
		addParameter(sb, "SuppressLineBreaks", suppressLineBreaks);
		addParameter(sb, "UseFormattedValues", useFormattedValues);
	}

	public String getEncoding() {
		return encoding;
	}

	/** The Internet Assigned Numbers Authority (IANA) name of a character encoding that is supported by the .NET Framework. The default value is UTF-8. Examples of other values include ASCII, UTF-7, and UTF-16. */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Boolean getExcelMode() {
		return excelMode;
	}

	/** Specifies that the target output is for Excel. The default value is true. */
	public void setExcelMode(Boolean excelMode) {
		this.excelMode = excelMode;
	}

	public String getFieldDelimiter() {
		return fieldDelimiter;
	}

	/** The delimiter string to put in the result. The default value is a comma (,). You should URL encode the value of this device information when passing it on a URL. For example, a tab character as a delimiter should be "%09".
	 * <p>You can change the default field delimiter to any character that you want, including TAB, by changing the device information settings in the configuration file. For example, to use TAB, update the FieldDelimiter setting to <FieldDelimiter xml:space="preserve">[TAB]</FieldDelimiter>
	 * <p>In the example [TAB] is an actual tab character, which means that whitespace appears in the configuration file. The "xml:space" attribute tells parsers to preserve whitespace. 
	 */
	public void setFieldDelimiter(String fieldDelimiter) {
		this.fieldDelimiter = fieldDelimiter;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	/** The file extension to put on the result. The default value is .CSV. If both FileExtension and Extension are specified then FileExtension will take precedence. */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Boolean getNoHeader() {
		return noHeader;
	}

	/** Indicates whether the header row is excluded from the output. The default value is false. */
	public void setNoHeader(Boolean noHeader) {
		this.noHeader = noHeader;
	}

	public String getQualifier() {
		return qualifier;
	}

	/** The qualifier string to put around results that contain the field delimiter or record delimiter. If the results contain the qualifier, the qualifier is repeated. The Qualifier setting must be different from the FieldDelimiter and RecordDelimiter settings. The default value is a quotation mark ("). */
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public String getRecordDelimiter() {
		return recordDelimiter;
	}

	/** The record delimiter to put at the end of each record. The default value is <cr><lf>. */
	public void setRecordDelimiter(String recordDelimiter) {
		this.recordDelimiter = recordDelimiter;
	}

	public Boolean getSuppressLineBreaks() {
		return suppressLineBreaks;
	}

	/** Indicates whether line breaks are removed from the data included in the output. The default value is false. If the value is true, the FieldDelimiter, RecordDelimiter, and Qualifier settings cannot be a space character. */
	public void setSuppressLineBreaks(Boolean suppressLineBreaks) {
		this.suppressLineBreaks = suppressLineBreaks;
	}

	public Boolean getUseFormattedValues() {
		return useFormattedValues;
	}

	/** Indicates whether formatted strings are put into the CSV output. The default value is true when ExcelMode is true; otherwise it is false. */
	public void setUseFormattedValues(Boolean useFormattedValues) {
		this.useFormattedValues = useFormattedValues;
	}

}
