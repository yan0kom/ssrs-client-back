package ru.yan0kom.test.ssrs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.yan0kom.ssrs.back.dis.AtomDis;
import ru.yan0kom.ssrs.back.dis.AutoFit;
import ru.yan0kom.ssrs.back.dis.CsvDis;
import ru.yan0kom.ssrs.back.dis.DataVisualizationFitSizing;
import ru.yan0kom.ssrs.back.dis.ExcelDis;
import ru.yan0kom.ssrs.back.dis.HtmlDis;
import ru.yan0kom.ssrs.back.dis.ImageDis;
import ru.yan0kom.ssrs.back.dis.MhtmlDis;
import ru.yan0kom.ssrs.back.dis.OutputFormat;
import ru.yan0kom.ssrs.back.dis.PdfDis;
import ru.yan0kom.ssrs.back.dis.PptxDis;
import ru.yan0kom.ssrs.back.dis.RgdiDis;
import ru.yan0kom.ssrs.back.dis.WordDis;
import ru.yan0kom.ssrs.back.dis.XmlDis;

public class DisTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testHtml() {
		HtmlDis html = new HtmlDis();
		html.setAccessibleTablix(true);
		html.setBookmarkId("TheTestBookmark");		
		html.setDocMap(true);
		html.setExpandContent(true);
		html.setFindString("TheTestFindString");
		html.setHtmlFragment(true);
		html.setImageConsolidation(true);
		html.setJavaScript(true);
		html.setLinkTarget("TheTestLinkTarget");
		html.setOutlookCompat(false);
		html.setParameters(true);
		html.setPrefixId("TheTestPrefix");
		html.setReplacementRoot("/link");
		html.setSection(0);
		html.setStreamRoot("/images");
		html.setStyleStream(true);
		html.setToolbar(true);
		html.setUserAgent("TheTestUserAgent");
		html.setDataVisualizationFitSizing(DataVisualizationFitSizing.Approximate);
		
		assertEquals("<DeviceInfo>"+
				"<AccessibleTablix>True</AccessibleTablix>"+
				"<BookmarkID>TheTestBookmark</BookmarkID>"+				
				"<DocMap>True</DocMap>"+
				"<ExpandContent>True</ExpandContent>"+
				"<FindString>TheTestFindString</FindString>"+
				"<HTMLFragment>True</HTMLFragment>"+
				"<ImageConsolidation>True</ImageConsolidation>"+
				"<JavaScript>True</JavaScript>"+
				"<LinkTarget>TheTestLinkTarget</LinkTarget>"+
				"<OutlookCompat>False</OutlookCompat>"+
				"<Parameters>True</Parameters>"+
				"<PrefixId>TheTestPrefix</PrefixId>"+
				"<ReplacementRoot>/link</ReplacementRoot>"+
				"<Section>0</Section>"+
				"<StreamRoot>/images</StreamRoot>"+
				"<StyleStream>True</StyleStream>"+
				"<Toolbar>True</Toolbar>"+
				"<UserAgent>TheTestUserAgent</UserAgent>"+
				"<DataVisualizationFitSizing>Approximate</DataVisualizationFitSizing>"+
				"</DeviceInfo>", 
				html.getXmlString());
	}
	
	@Test
	public void testAtom() {
		AtomDis atom = new AtomDis();
		atom.setDataFeed("TheTestDataFeed");
		atom.setEncoding("UTF-16");
		
		assertEquals("<DeviceInfo>"+
				"<DataFeed>TheTestDataFeed</DataFeed>"+
				"<Encoding>UTF-16</Encoding>"+
				"</DeviceInfo>", 
				atom.getXmlString());
	}
	
	@Test
	public void testCsv() {
		CsvDis csv = new CsvDis();
		csv.setEncoding("UTF-8");
		csv.setExcelMode(false);
		csv.setFieldDelimiter(";");
		csv.setFileExtension(".csv");
		csv.setNoHeader(false);
		csv.setQualifier("`");
		csv.setRecordDelimiter("\n");
		csv.setSuppressLineBreaks(false);
		csv.setUseFormattedValues(true);
		
		assertEquals("<DeviceInfo>"+
				"<Encoding>UTF-8</Encoding>"+
				"<ExcelMode>False</ExcelMode>"+
				"<FieldDelimiter xml:space=\"preserve\">;</FieldDelimiter>"+
				"<FileExtension>.csv</FileExtension>"+
				"<NoHeader>False</NoHeader>"+
				"<Qualifier xml:space=\"preserve\">`</Qualifier>"+
				"<RecordDelimiter xml:space=\"preserve\">\n</RecordDelimiter>"+
				"<SuppressLineBreaks>False</SuppressLineBreaks>"+
				"<UseFormattedValues>True</UseFormattedValues>"+
				"</DeviceInfo>", 
				csv.getXmlString());		
	}
	
	@Test
	public void testExcel() {
		ExcelDis excel = new ExcelDis();
		excel.setOmitDocumentMap(false);
		excel.setOmitFormulas(true);
		excel.setSimplePageHeaders(true);
		
		assertEquals("<DeviceInfo>"+
				"<OmitDocumentMap>False</OmitDocumentMap>"+
				"<OmitFormulas>True</OmitFormulas>"+
				"<SimplePageHeaders>True</SimplePageHeaders>"+
				"</DeviceInfo>",
				excel.getXmlString());
	}
	
	@Test
	public void testImage() {
		ImageDis image = new ImageDis();
		image.setColumns(2);
		image.setColumnSpacing(0);
		image.setDpiX(96);
		image.setDpiY(96);
		image.setEndPage(1);
		image.setMarginBottom(0.4);
		image.setMarginLeft(0.2);
		image.setMarginRight(0.2);
		image.setMarginTop(0.4);
		image.setOutputFormat(OutputFormat.TIFF);
		image.setPageHeight(11.69);
		image.setPageWidth(8.27);
		image.setPrintDpiX(300);
		image.setPrintDpiY(300);
		image.setStartPage(0);
		
		assertEquals("<DeviceInfo>"+
				"<Columns>2</Columns>"+
				"<ColumnSpacing>0</ColumnSpacing>"+
				"<DpiX>96</DpiX>"+
				"<DpiY>96</DpiY>"+
				"<EndPage>1</EndPage>"+
				"<MarginBottom>0.4in</MarginBottom>"+
				"<MarginLeft>0.2in</MarginLeft>"+
				"<MarginRight>0.2in</MarginRight>"+
				"<MarginTop>0.4in</MarginTop>"+
				"<OutputFormat>TIFF</OutputFormat>"+
				"<PageHeight>11.69in</PageHeight>"+
				"<PageWidth>8.27in</PageWidth>"+
				"<PrintDpiX>300</PrintDpiX>"+
				"<PrintDpiY>300</PrintDpiY>"+
				"<StartPage>0</StartPage>"+
				"</DeviceInfo>",
				image.getXmlString());		
	}
	
	@Test
	public void testMhtml() {
		MhtmlDis mhtml = new MhtmlDis();
		mhtml.setJavaScript(true);
		mhtml.setOutlookCompat(false);
		mhtml.setMhtmlFragment(true);
		mhtml.setDataVisualizationFitSizing(DataVisualizationFitSizing.Exact);
		
		assertEquals("<DeviceInfo>"+
				"<JavaScript>True</JavaScript>"+
				"<OutlookCompat>False</OutlookCompat>"+
				"<MHTMLFragment>True</MHTMLFragment>"+
				"<DataVisualizationFitSizing>Exact</DataVisualizationFitSizing>"+
				"</DeviceInfo>", 
				mhtml.getXmlString());
	}

	@Test
	public void testPdf() {
		PdfDis pdf = new PdfDis();
		pdf.setColumns(2);
		pdf.setColumnSpacing(0);
		pdf.setDpiX(96);
		pdf.setDpiY(96);
		pdf.setEndPage(1);
		pdf.setHumanReadablePdf(true);
		pdf.setMarginBottom(0.4);
		pdf.setMarginLeft(0.2);
		pdf.setMarginRight(0.2);
		pdf.setMarginTop(0.4);
		pdf.setPageHeight(11.69);
		pdf.setPageWidth(8.27);
		pdf.setStartPage(0);
		
		assertEquals("<DeviceInfo>"+
				"<Columns>2</Columns>"+
				"<ColumnSpacing>0</ColumnSpacing>"+
				"<DpiX>96</DpiX>"+
				"<DpiY>96</DpiY>"+
				"<EndPage>1</EndPage>"+
				"<HumanReadablePDF>True</HumanReadablePDF>"+
				"<MarginBottom>0.4in</MarginBottom>"+
				"<MarginLeft>0.2in</MarginLeft>"+
				"<MarginRight>0.2in</MarginRight>"+
				"<MarginTop>0.4in</MarginTop>"+
				"<PageHeight>11.69in</PageHeight>"+
				"<PageWidth>8.27in</PageWidth>"+
				"<StartPage>0</StartPage>"+
				"</DeviceInfo>",
				pdf.getXmlString());		
	}

	@Test
	public void testPptx() {
		PptxDis pptx = new PptxDis();
		pptx.setColumns(2);
		pptx.setColumnSpacing(0);
		pptx.setDpiX(96);
		pptx.setDpiY(96);
		pptx.setEndPage(1);		
		pptx.setMarginBottom(0.4);
		pptx.setMarginLeft(0.2);
		pptx.setMarginRight(0.2);
		pptx.setMarginTop(0.4);
		pptx.setPageHeight(11.69);
		pptx.setPageWidth(8.27);
		pptx.setStartPage(0);
		pptx.setUseReportPageSize(false);
		
		assertEquals("<DeviceInfo>"+
				"<Columns>2</Columns>"+
				"<ColumnSpacing>0</ColumnSpacing>"+
				"<DpiX>96</DpiX>"+
				"<DpiY>96</DpiY>"+
				"<EndPage>1</EndPage>"+
				"<MarginBottom>0.4in</MarginBottom>"+
				"<MarginLeft>0.2in</MarginLeft>"+
				"<MarginRight>0.2in</MarginRight>"+
				"<MarginTop>0.4in</MarginTop>"+
				"<PageHeight>11.69in</PageHeight>"+
				"<PageWidth>8.27in</PageWidth>"+
				"<StartPage>0</StartPage>"+
				"<UseReportPageSize>False</UseReportPageSize>"+
				"</DeviceInfo>",
				pptx.getXmlString());		
	}

	@Test
	public void testXml() {
		XmlDis xml = new XmlDis();
		xml.setEncoding("ASCII");
		xml.setFileExtension("xml");
		xml.setIndented(true);
		xml.setMimeType("application/xml");
		xml.setOmitNamespace(true);
		xml.setOmitSchema(true);
		xml.setSchema(false);
		xml.setUseFormattedValues(false);
		xml.setXslt("/the/test.xsl");
		
		assertEquals("<DeviceInfo>"+
				"<XSLT>/the/test.xsl</XSLT>"+
				"<MIMEType>application/xml</MIMEType>"+
				"<UseFormattedValues>False</UseFormattedValues>"+
				"<Indented>True</Indented>"+
				"<OmitNamespace>True</OmitNamespace>"+
				"<OmitSchema>True</OmitSchema>"+
				"<Encoding>ASCII</Encoding>"+
				"<FileExtension>xml</FileExtension>"+
				"<Schema>False</Schema>"+
				"</DeviceInfo>",
				xml.getXmlString());		
	}
	
	@Test
	public void testWord() {
		WordDis word = new WordDis();
		word.setAutoFit(AutoFit.Default);
		word.setExpandToggles(true);
		word.setFixedPageWidth(false);
		word.setOmitDrillthroughs(true);
		word.setOmitHyperlinks(true);
		
		assertEquals("<DeviceInfo>"+
				"<AutoFit>Default</AutoFit>"+
				"<ExpandToggles>True</ExpandToggles>"+
				"<FixedPageWidth>False</FixedPageWidth>"+
				"<OmitHyperlinks>True</OmitHyperlinks>"+
				"<OmitDrillthroughs>True</OmitDrillthroughs>"+
				"</DeviceInfo>",
				word.getXmlString());		
	}
	
	@Test
	public void testRgdi() {
		RgdiDis rgdi = new RgdiDis();
		rgdi.setPage(4);
		rgdi.setRgdiVersion("1.2");
		
		assertEquals("<DeviceInfo>"+
				"<Page>4</Page>"+
				"<RGDIVersion>1.2</RGDIVersion>"+
				"</DeviceInfo>",
				rgdi.getXmlString());		
	}
}
