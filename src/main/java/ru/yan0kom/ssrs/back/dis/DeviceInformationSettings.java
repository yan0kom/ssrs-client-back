package ru.yan0kom.ssrs.back.dis;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class DeviceInformationSettings {
	
	public String getXmlString() {
		StringBuilder sb = new StringBuilder("<DeviceInfo>");
		addSettings(sb);
		sb.append("</DeviceInfo>");
		return sb.toString();
	}
	
	protected abstract void addSettings(StringBuilder sb);
	
	protected void addParameter(StringBuilder sb, String name, Object value, String attr) {
		if (value != null) {
			sb.append("<");
			sb.append(name);
			if (attr != null) {
				sb.append(" ");
				sb.append(attr);
			}
			sb.append(">");
			if (value instanceof Boolean) {
				sb.append((Boolean) value ? "True" : "False");
			}else {
				sb.append(value.toString());
			}
			sb.append("</");
			sb.append(name);
			sb.append(">");
		}
	}
	
	protected void addParameter(StringBuilder sb, String name, Object value) {
		addParameter(sb, name, value, null);
	}
	
	protected void addInchParameter(StringBuilder sb, String name, Double inches) {
		DecimalFormat df = new DecimalFormat();
		DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);
		addParameter(sb, name, String.format("%sin", df.format(inches)), null);
	}
	
}
