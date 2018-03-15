package ru.yan0kom.ssrs.back.dis;

/** XML Device Information Settings */
public class XmlDis extends DeviceInformationSettings {
	private String xslt;
	private String mimeType;
	private Boolean useFormattedValues;
	private Boolean indented;
	private Boolean omitNamespace;
	private Boolean omitSchema;
	private String encoding;
	private String fileExtension;
	private Boolean schema;

	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "XSLT", xslt);
		addParameter(sb, "MIMEType", mimeType);
		addParameter(sb, "UseFormattedValues", useFormattedValues);
		addParameter(sb, "Indented", indented);		
		addParameter(sb, "OmitNamespace", omitNamespace);
		addParameter(sb, "OmitSchema", omitSchema);
		addParameter(sb, "Encoding", encoding);
		addParameter(sb, "FileExtension", fileExtension);
		addParameter(sb, "Schema", schema);
	}

	public String getXslt() {
		return xslt;
	}

	/** The path in the report server namespace of an XSLT to apply to the XML file, for example /Transforms/myxslt.
	 * <p>The xsl file must be a published resource on the report server and you must access it through a report server item path. The value of this setting is applied after any XSLT that is specified in the report. If the XSLT setting is applied, the OmitSchema setting is ignored.
	 */
	public void setXslt(String xslt) {
		this.xslt = xslt;
	}

	public String getMimeType() {
		return mimeType;
	}

	/** The Multipurpose Internet Mail Extensions (MIME) type of the XML file. */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Boolean getUseFormattedValues() {
		return useFormattedValues;
	}

	/** Indicates whether to render the formatted value of a text box when generating the XML data. 
	 * <p>A value of false indicates that the underlying value of the text box is used.
	 */
	public void setUseFormattedValues(Boolean useFormattedValues) {
		this.useFormattedValues = useFormattedValues;
	}

	public Boolean getIndented() {
		return indented;
	}

	/** Indicates whether to generate indented XML. The default value of false generates non-indented, compressed XML. */
	public void setIndented(Boolean indented) {
		this.indented = indented;
	}

	public Boolean getOmitNamespace() {
		return omitNamespace;
	}

	/** Indicates whether to omit the default namespace from the XML.
	 * <p>If true, the XML does not specify a default namespace.
	 * <p>If false, the XML specifies a default namespace with the value of the report’s DataSchema property. The DataSchema property defaults to the report name.
	 * <p>The default value isfalse. 
	 */
	public void setOmitNamespace(Boolean omitNamespace) {
		this.omitNamespace = omitNamespace;
	}

	public Boolean getOmitSchema() {
		return omitSchema;
	}

	/** Indicates whether to omit the schema location from the XML. The location is the SchemaLocation attribute.
	 * <p>The default value of OmitSchema depends on the value of OmitNamespace:
	 * <p>If OmitNamespace = False, then OmitSchema = False by default. The user can override the default by setting OmitSchema = True.
	 * <p>If OmitNamespace = True, then OmitSchema will function as True regardless of the value explicitly configured for OmitShema. 
	 */
	public void setOmitSchema(Boolean omitSchema) {
		this.omitSchema = omitSchema;
	}

	public String getEncoding() {
		return encoding;
	}

	/** The Internet Assigned Numbers Authority (IANA) name of a character encoding that is supported by the .NET Framework.
	 * <p>The default value is UTF-8. Examples of other values include ASCII, UTF-7, and UTF-16.
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	/** The file extension to use for the generated file. */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Boolean getSchema() {
		return schema;
	}

	/**	A value of true indicates that an XML schema is rendered. The default value is false. 
	 * <p>Indicates whether the XML schema definition (XSD) is rendered or whether the actual XML data is rendered.
	 */
	public void setSchema(Boolean schema) {
		this.schema = schema;
	}

}
