package ru.yan0kom.ssrs.back.dis;

/** Image Device Information Settings */
public class ImageDis extends DeviceInformationSettings {
	private Integer columns;
	private Integer columnSpacing;
	private Integer dpiX;
	private Integer dpiY;
	private Integer endPage;
	private Double marginBottom;
	private Double marginLeft;
	private Double marginRight;
	private Double marginTop;
	private Double pageHeight;
	private Double pageWidth;
	private Integer printDpiX;
	private Integer printDpiY;
	private Integer startPage;
	private OutputFormat outputFormat;

	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "Columns", columns);
		addParameter(sb, "ColumnSpacing", columnSpacing);
		addParameter(sb, "DpiX", dpiX);
		addParameter(sb, "DpiY", dpiY);
		addParameter(sb, "EndPage", endPage);
		addInchParameter(sb, "MarginBottom", marginBottom);
		addInchParameter(sb, "MarginLeft", marginLeft);
		addInchParameter(sb, "MarginRight", marginRight);
		addInchParameter(sb, "MarginTop", marginTop);
		addParameter(sb, "OutputFormat", outputFormat);
		addInchParameter(sb, "PageHeight", pageHeight);
		addInchParameter(sb, "PageWidth", pageWidth);
		addParameter(sb, "PrintDpiX", printDpiX);
		addParameter(sb, "PrintDpiY", printDpiY);
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

	/** The horizontal resolution of the output image. The default value is 96. Applies to BMP, GIF, PNG, and TIFF output formats. */
	public void setDpiX(Integer dpiX) {
		this.dpiX = dpiX;
	}

	public Integer getDpiY() {
		return dpiY;
	}

	/** The vertical resolution of the output image. The default value is 96. Applies to BMP, GIF, PNG, and TIFF output formats. */
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

	public OutputFormat getOutputFormat() {
		return outputFormat;
	}

	/** One of the Graphics Device Interface ( GDI) supported output formats: BMP, EMF, GIF, JPEG, PNG, or TIFF. */
	public void setOutputFormat(OutputFormat outputFormat) {
		this.outputFormat = outputFormat;
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

	public Integer getPrintDpiX() {
		return printDpiX;
	}

	/** The horizontal resolution of the output image. The default value is 300. Applies to the Enhanced MetaFile (EMF) output format. */
	public void setPrintDpiX(Integer printDpiX) {
		this.printDpiX = printDpiX;
	}

	public Integer getPrintDpiY() {
		return printDpiY;
	}

	/** The vertical resolution of the output image. The default value is 300. Applies to the Enhanced MetaFile (EMF) output format. */
	public void setPrintDpiY(Integer printDpiY) {
		this.printDpiY = printDpiY;
	}

	public Integer getStartPage() {
		return startPage;
	}

	/** The first page of the report to render. A value of 0 indicates that all pages are rendered. The default value is 1. */
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

}
