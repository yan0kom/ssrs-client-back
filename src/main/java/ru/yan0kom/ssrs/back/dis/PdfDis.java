package ru.yan0kom.ssrs.back.dis;

/** PDF Device Information Settings */
public class PdfDis extends DeviceInformationSettings {
	private Integer columns;
	private Integer columnSpacing;
	private Integer dpiX;
	private Integer dpiY;
	private Integer endPage;
	private Boolean humanReadablePdf;
	private Double marginBottom;
	private Double marginLeft;
	private Double marginRight;
	private Double marginTop;
	private Double pageHeight;
	private Double pageWidth;
	private Integer startPage;

	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "Columns", columns);
		addParameter(sb, "ColumnSpacing", columnSpacing);
		addParameter(sb, "DpiX", dpiX);
		addParameter(sb, "DpiY", dpiY);
		addParameter(sb, "EndPage", endPage);
		addParameter(sb, "HumanReadablePDF", humanReadablePdf);
		addInchParameter(sb, "MarginBottom", marginBottom);
		addInchParameter(sb, "MarginLeft", marginLeft);
		addInchParameter(sb, "MarginRight", marginRight);
		addInchParameter(sb, "MarginTop", marginTop);
		addInchParameter(sb, "PageHeight", pageHeight);
		addInchParameter(sb, "PageWidth", pageWidth);
		addParameter(sb, "StartPage", startPage);
	}

	public Integer getColumns() {
		return columns;
	}

	/** The number of columns to set for the report. This value overrides the report's original settings. */
	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	public Integer getColumnSpacing() {
		return columnSpacing;
	}

	/** The column spacing to set for the report. This value overrides the report's original settings. */
	public void setColumnSpacing(Integer columnSpacing) {
		this.columnSpacing = columnSpacing;
	}

	public Integer getDpiX() {
		return dpiX;
	}

	/** The resolution of the output device in x-direction. */
	public void setDpiX(Integer dpiX) {
		this.dpiX = dpiX;
	}

	public Integer getDpiY() {
		return dpiY;
	}

	/** The resolution of the output device in y-direction. */
	public void setDpiY(Integer dpiY) {
		this.dpiY = dpiY;
	}

	public Integer getEndPage() {
		return endPage;
	}

	/** The last page of the report to render. The default value is the value for StartPage. */
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Boolean getHumanReadablePdf() {
		return humanReadablePdf;
	}

	/** Indicates whether the PDF should be compressed, which allows the source to be more readable. The default value is false. */
	public void setHumanReadablePdf(Boolean humanReadablePdf) {
		this.humanReadablePdf = humanReadablePdf;
	}

	public Double getMarginBottom() {
		return marginBottom;
	}

	/** The bottom margin value, in inches, to set for the report. You must include an integer or decimal value followed by "in" (for example, 1in). This value overrides the report's original settings. */
	public void setMarginBottom(Double marginBottom) {
		this.marginBottom = marginBottom;
	}

	public Double getMarginLeft() {
		return marginLeft;
	}

	/** The left margin value, in inches, to set for the report. You must include an integer or decimal value followed by "in" (for example, 1in). This value overrides the report's original settings. */
	public void setMarginLeft(Double marginLeft) {
		this.marginLeft = marginLeft;
	}

	public Double getMarginRight() {
		return marginRight;
	}

	/** The right margin value, in inches, to set for the report. You must include an integer or decimal value followed by "in" (for example, 1in). This value overrides the report's original settings. */
	public void setMarginRight(Double marginRight) {
		this.marginRight = marginRight;
	}

	public Double getMarginTop() {
		return marginTop;
	}

	/** The top margin value, in inches, to set for the report. You must include an integer or decimal value followed by "in" (for example, 1in). This value overrides the report's original settings. */
	public void setMarginTop(Double marginTop) {
		this.marginTop = marginTop;
	}

	public Double getPageHeight() {
		return pageHeight;
	}

	/** The page height, in inches, to set for the report. You must include an integer or decimal value followed by "in" (for example, 11in). This value overrides the report's original settings. */
	public void setPageHeight(Double pageHeight) {
		this.pageHeight = pageHeight;
	}

	public Double getPageWidth() {
		return pageWidth;
	}

	/** The page width, in inches, to set for the report. You must include an integer or decimal value followed by "in" (for example, 8.5in). This value overrides the report's original settings. */
	public void setPageWidth(Double pageWidth) {
		this.pageWidth = pageWidth;
	}

	public Integer getStartPage() {
		return startPage;
	}

	/** The first page of the report to render. A value of 0 indicates that all pages are rendered. The default value is 1. */
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

}
