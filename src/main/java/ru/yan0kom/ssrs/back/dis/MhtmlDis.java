package ru.yan0kom.ssrs.back.dis;

/** MHTML Device Information Settings */
public class MhtmlDis extends DeviceInformationSettings {
	private Boolean javaScript;
	private Boolean outlookCompat;
	private Boolean mhtmlFragment;
	private DataVisualizationFitSizing dataVisualizationFitSizing;
	
	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "JavaScript", javaScript);
		addParameter(sb, "OutlookCompat", outlookCompat);
		addParameter(sb, "MHTMLFragment", mhtmlFragment);
		addParameter(sb, "DataVisualizationFitSizing", dataVisualizationFitSizing);
	}

	public Boolean getJavaScript() {
		return javaScript;
	}

	/** Indicates whether JavaScript is supported in the rendered report. */
	public void setJavaScript(Boolean javaScript) {
		this.javaScript = javaScript;
	}

	public Boolean getOutlookCompat() {
		return outlookCompat;
	}

	/** Indicates whether to render with extra metadata that makes the report look better in Outlook. The default value is true. */
	public void setOutlookCompat(Boolean outlookCompat) {
		this.outlookCompat = outlookCompat;
	}

	public Boolean getMhtmlFragment() {
		return mhtmlFragment;
	}

	/** Indicates whether an MHTML fragment is created in place of a full MHTML document. An MHTML fragment includes the report content in a TABLE element and omits the HTML and BODY elements. The default value is false. */
	public void setMhtmlFragment(Boolean mhtmlFragment) {
		this.mhtmlFragment = mhtmlFragment;
	}

	public DataVisualizationFitSizing getDataVisualizationFitSizing() {
		return dataVisualizationFitSizing;
	}

	/** Indicates data visualization fit behavior when inside a tablix. This includes chart, gauge, and map.
	 * <p>The possible values are Approximate and Exact.
	 * <p>The default value is Approximate. If the setting is removed from the rsreportserver.config file then the default behavior is Exact.
	 * <p>Enabling Exact may have performance impact because the processing to determine the exact size may take longer.
	 */
	public void setDataVisualizationFitSizing(DataVisualizationFitSizing dataVisualizationFitSizing) {
		this.dataVisualizationFitSizing = dataVisualizationFitSizing;
	}

}
