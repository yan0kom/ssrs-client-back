package ru.yan0kom.ssrs.back.dis;

/** RGDI Device Information Settings */
public class RgdiDis extends DeviceInformationSettings {
	private Integer page;
	private String rgdiVersion;

	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "Page", page);
		addParameter(sb, "RGDIVersion", rgdiVersion);
	}

	public Integer getPage() {
		return page;
	}

	/** Specifies page of the report to render. The default value is 1. */
	public void setPage(Integer page) {
		this.page = page;
	}

	public String getRgdiVersion() {
		return rgdiVersion;
	}

	/** This setting has no effect. */
	public void setRgdiVersion(String rgdiVersion) {
		this.rgdiVersion = rgdiVersion;
	}

}
