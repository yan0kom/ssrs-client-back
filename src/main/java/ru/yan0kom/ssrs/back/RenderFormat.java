package ru.yan0kom.ssrs.back;

public enum RenderFormat {
	WORDOPENXML("Word", "docx"),
	WORD("Word 2003", "doc"),
	EXCELOPENXML("Excel", "xlsx"),
	EXCEL("Excel 2003", "xls"),
	/** SSRS 2016 */
	PPTX("PowerPoint", "pptx"),
	PDF("PDF", "pdf"),
	IMAGE("TIFF-файл", "tif"),
	MHTML("MHTML (веб-архив)", "mhtml"),
	CSV("CSV (с разделителями-запятыми)", "csv"),
	XML("XML-файл с данными отчета", "xml"),
	ATOM("Канал данных", "atom"),
	NULL("NullRenderer", "null"),
	RGDI("Файл удаленного GDI+", "gdi"),
	HTML40("HTML 4.0", "HTML4.0", "html"),
	/** SSRS 2016 */
	HTML5("HTML5", "html"),
	RPL("Модуль подготовки RPL", "rpl");
	
	private String name;
	private String localizedName;
	private String extension;
	
	RenderFormat(String localizedName, String extension) {
		this(localizedName, null, extension);
	}
	
	RenderFormat(String localizedName, String name, String extension) {
		this.localizedName = localizedName;
		this.name = name;
		this.extension = extension;
	}
	
	public String getLocalizedName() {
		return localizedName;
	}
	
	public String getName() {
		if (name == null) {
			return this.toString();
		}
		return name;
	}
	
	public String getExtension() {
		return extension;
	}		
}
