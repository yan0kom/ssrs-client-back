package ru.yan0kom.ssrs.back.dis;

/** HTML Device Information Settings */
public class HtmlDis extends DeviceInformationSettings {
	private Boolean accessibleTablix;
	private String bookmarkId;
	private Boolean docMap;
	private Boolean expandContent;
	private String findString;
	private Boolean htmlFragment;
	private Boolean imageConsolidation;
	private Boolean javaScript;
	private String linkTarget;
	private Boolean outlookCompat;
	private Boolean parameters;
	private String prefixId;
	private String replacementRoot;
	private Integer section;
	private String streamRoot;
	private Boolean styleStream;
	private Boolean toolbar;
	private String userAgent;
	private DataVisualizationFitSizing dataVisualizationFitSizing;
	
	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "AccessibleTablix", accessibleTablix);
		addParameter(sb, "BookmarkID", bookmarkId);
		addParameter(sb, "DocMap", docMap);
		addParameter(sb, "ExpandContent", expandContent);
		addParameter(sb, "FindString", findString);
		addParameter(sb, "HTMLFragment", htmlFragment);
		addParameter(sb, "ImageConsolidation", imageConsolidation);
		addParameter(sb, "JavaScript", javaScript);
		addParameter(sb, "LinkTarget", linkTarget);
		addParameter(sb, "OutlookCompat", outlookCompat);
		addParameter(sb, "Parameters", parameters);
		addParameter(sb, "PrefixId", prefixId);
		addParameter(sb, "ReplacementRoot", replacementRoot);
		addParameter(sb, "Section", section);
		addParameter(sb, "StreamRoot", streamRoot);
		addParameter(sb, "StyleStream", styleStream);
		addParameter(sb, "Toolbar", toolbar);
		addParameter(sb, "UserAgent", userAgent);
		addParameter(sb, "DataVisualizationFitSizing", dataVisualizationFitSizing);
	}

	public Boolean getAccessibleTablix() {
		return accessibleTablix;
	}

	/** Indicates whether to render with additional accessibility metadata for use with screen readers. The additional accessibility metadata causes the rendered report to be compliant with the following technical standards in the "Web-based Intranet and Internet Information and Applications" section (1194.22) of the Electronic and Information Technology Accessibility Standards (Section 508) document:
	 * <p>(g) Row and column headers shall be identified for data tables.
	 * <p>(h) Markup shall be used to associate data cells and header cells for data tables that have two or more logical levels of row or column headers. 
	 */
	public void setAccessibleTablix(Boolean accessibleTablix) {
		this.accessibleTablix = accessibleTablix;
	}

	public String getBookmarkId() {
		return bookmarkId;
	}

	/** The bookmark ID to jump to in the report. */
	public void setBookmarkId(String bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public Boolean getDocMap() {
		return docMap;
	}

	/** Indicates whether to show or hide the report document map. The default value of this parameter is true. */
	public void setDocMap(Boolean docMap) {
		this.docMap = docMap;
	}

	public Boolean getExpandContent() {
		return expandContent;
	}

	/** Indicates whether the report should be enclosed in a table structure which constricts horizontal size. */
	public void setExpandContent(Boolean expandContent) {
		this.expandContent = expandContent;
	}

	public String getFindString() {
		return findString;
	}

	/** The text to search for in the report. The default value of this parameter is an empty string. */
	public void setFindString(String findString) {
		this.findString = findString;
	}

	public Boolean getHtmlFragment() {
		return htmlFragment;
	}

	/** Indicates whether an HTML fragment is created in place of a full HTML document. An HTML fragment includes the report content in a TABLE element and omits the HTML and BODY elements. The default value is false. If you are rendering to HTML using the M:ReportExecution2005.ReportExecutionService.Render(System.String,System.String,System.String@,System.String@,System.String@, ReportExecution2005.Warning[]@,System.String[]@) method of the SOAP API, you need to set this device information to true if you are rendering a report with images. Rendering using SOAP with the HTMLFragment property set to true creates URLs containing session information that can be used to properly request images. The images must be uploaded resources in the report server database. */
	public void setHtmlFragment(Boolean htmlFragment) {
		this.htmlFragment = htmlFragment;
	}

	public Boolean getImageConsolidation() {
		return imageConsolidation;
	}

	/** Indicates whether to consolidate the rendered chart, map, gauge, and indicator images into one large image. The consolidation of images helps improve the performance of the report in the client browser when the report contains many data visualization items. The default value is true for most modern browsers. */
	public void setImageConsolidation(Boolean imageConsolidation) {
		this.imageConsolidation = imageConsolidation;
	}

	public Boolean getJavaScript() {
		return javaScript;
	}

	/** Indicates whether JavaScript is supported in the rendered report. The default value is true. */
	public void setJavaScript(Boolean javaScript) {
		this.javaScript = javaScript;
	}

	public String getLinkTarget() {
		return linkTarget;
	}

	/** The target for hyperlinks in the report. You can target a window or frame by providing the name of the window, like LinkTarget=window_name, or you can target a new window using LinkTarget=_blank. Other valid target names include _self, _parent, and _top. */
	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}

	public Boolean getOutlookCompat() {
		return outlookCompat;
	}

	/** Indicates whether to render with extra metadata that makes the report look better in Outlook. For others, the default value is false. */
	public void setOutlookCompat(Boolean outlookCompat) {
		this.outlookCompat = outlookCompat;
	}

	public Boolean getParameters() {
		return parameters;
	}

	/**	Indicates whether to show or hide the parameters area of the toolbar. If you set this parameter to a value of true, the parameters area of the toolbar is displayed. The default value of this parameter is true. */
	public void setParameters(Boolean parameters) {
		this.parameters = parameters;
	}

	public String getPrefixId() {
		return prefixId;
	}

	/** When used with HTMLFragment, adds the specified prefix to all ID attributes in the HTML fragment that is created. */
	public void setPrefixId(String prefixId) {
		this.prefixId = prefixId;
	}

	public String getReplacementRoot() {
		return replacementRoot;
	}

	/** The string to prepend to all drillthrough, toggle, and bookmark links in the report when rendered outside of the ReportViewer control. For example, this is used for redirecting a user’s click to a custom page. */
	@Deprecated
	public void setReplacementRoot(String replacementRoot) {
		this.replacementRoot = replacementRoot;
	}

	public Integer getSection() {
		return section;
	}

	/** The page number of the report to render. A value of 0 indicates that all sections of the report are rendered. The default value is 1. */
	public void setSection(Integer section) {
		this.section = section;
	}

	public String getStreamRoot() {
		return streamRoot;
	}

	/** The path used for prefixing the value of the src attribute of the IMG element in the HTML report returned by the report server. By default, the report server provides the path. You can use this setting to specify a root path for the images in a report (for example, http://<servername>/resources/companyimages). */
	@Deprecated
	public void setStreamRoot(String streamRoot) {
		this.streamRoot = streamRoot;
	}

	public Boolean getStyleStream() {
		return styleStream;
	}

	/** Indicates whether styles and scripts are created as a separate stream instead of in the document. The default value is false. */
	public void setStyleStream(Boolean styleStream) {
		this.styleStream = styleStream;
	}

	public Boolean getToolbar() {
		return toolbar;
	}

	/**	Indicates whether to show or hide the toolbar. The default of this parameter is true. If the value of this parameter is false, all remaining options (except the document map) are ignored. If you omit this parameter, the toolbar is automatically displayed for rendering formats that support it.
	 * <p>The Report Viewer toolbar is rendered when you use URL access to render a report. The toolbar is not rendered through the SOAP API. However, the Toolbar device information setting affects the way that the report is displayed when using the SOAP Render method. If the value of this parameter is true when using SOAP to render to HTML, only the first section of the report is rendered. If the value is false, the entire HTML report is rendered as a single HTML page. 
	 */
	public void setToolbar(Boolean toolbar) {
		this.toolbar = toolbar;
	}

	public String getUserAgent() {
		return userAgent;
	}

	/** The user-agent string of the browser that is making the request, which is found in the HTTP request. */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
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
