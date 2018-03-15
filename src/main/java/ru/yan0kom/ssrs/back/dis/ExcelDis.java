package ru.yan0kom.ssrs.back.dis;

/** Excel Device Information Settings */
public class ExcelDis extends DeviceInformationSettings {
	private Boolean omitDocumentMap;
	private Boolean omitFormulas;
	private Boolean simplePageHeaders;
	
	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "OmitDocumentMap", omitDocumentMap);
		addParameter(sb, "OmitFormulas", omitFormulas);
		addParameter(sb, "SimplePageHeaders", simplePageHeaders);
	}

	public Boolean getOmitDocumentMap() {
		return omitDocumentMap;
	}

	/** Indicates whether to omit the document map for reports that support it. The default value is false. */
	public void setOmitDocumentMap(Boolean omitDocumentMap) {
		this.omitDocumentMap = omitDocumentMap;
	}

	public Boolean getOmitFormulas() {
		return omitFormulas;
	}

	/** Indicates whether to omit formulas from the rendered report. The default value is false. */
	public void setOmitFormulas(Boolean omitFormulas) {
		this.omitFormulas = omitFormulas;
	}

	public Boolean getSimplePageHeaders() {
		return simplePageHeaders;
	}

	/** Indicates whether the page header of the report is rendered to the Excel page header. A value of false indicates that the page header is rendered to the first row of the worksheet. The default value is false. */
	public void setSimplePageHeaders(Boolean simplePageHeaders) {
		this.simplePageHeaders = simplePageHeaders;
	}

}
