package ru.yan0kom.ssrs.back.dis;

/** Word Device Information Settings */
public class WordDis extends DeviceInformationSettings {
	private AutoFit autoFit;
	private Boolean expandToggles;
	private Boolean fixedPageWidth;
	private Boolean omitHyperlinks;
	private Boolean omitDrillthroughs;

	@Override
	protected void addSettings(StringBuilder sb) {
		addParameter(sb, "AutoFit", autoFit);
		addParameter(sb, "ExpandToggles", expandToggles);
		addParameter(sb, "FixedPageWidth", fixedPageWidth);
		addParameter(sb, "OmitHyperlinks", omitHyperlinks);
		addParameter(sb, "OmitDrillthroughs", omitDrillthroughs);
	}

	public AutoFit getAutoFit() {
		return autoFit;
	}

	/**	False. AutoFit is set to false set on any Word table.
	 * <p>True. AutoFit is set to true on every Word table.
	 * <p>Never. AutoFit values are not set on any Word table and behavior reverts to the Word default.
	 * <p>Default. AutoFit is set on tables that are narrower than the physical drawing area (physical page width excluding margins) per logical page. 
	 */
	public void setAutoFit(AutoFit autoFit) {
		this.autoFit = autoFit;
	}

	public Boolean getExpandToggles() {
		return expandToggles;
	}

	/** Indicates whether all items that can be toggled should render in their fully-expanded state. The default value is false. */
	public void setExpandToggles(Boolean expandToggles) {
		this.expandToggles = expandToggles;
	}

	public Boolean getFixedPageWidth() {
		return fixedPageWidth;
	}

	/** Indicates whether the Page Width written to the DOC file will grow to accommodate the width of the largest page in the Report Body. The default value is false. */
	public void setFixedPageWidth(Boolean fixedPageWidth) {
		this.fixedPageWidth = fixedPageWidth;
	}

	public Boolean getOmitHyperlinks() {
		return omitHyperlinks;
	}

	/** Indicates whether to omit the Hyperlink action on all items where it is set. The default value is false */
	public void setOmitHyperlinks(Boolean omitHyperlinks) {
		this.omitHyperlinks = omitHyperlinks;
	}

	public Boolean getOmitDrillthroughs() {
		return omitDrillthroughs;
	}

	/** Indicates whether to omit the Drillthrough action on all items where it is set. The default value is false */
	public void setOmitDrillthroughs(Boolean omitDrillthroughs) {
		this.omitDrillthroughs = omitDrillthroughs;
	}

}
