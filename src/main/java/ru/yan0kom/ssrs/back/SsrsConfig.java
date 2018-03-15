package ru.yan0kom.ssrs.back;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="config", namespace="yan0kom/ssrs-client-back/ssrs-config")
@XmlAccessorType(XmlAccessType.FIELD)
public class SsrsConfig {
	private static SsrsConfig instance;

	@XmlElement(name="server")
	private List<SsrsServer> servers;

	static {
		try {
			JAXBContext ctx = JAXBContext.newInstance(SsrsConfig.class);
			Unmarshaller loader = ctx.createUnmarshaller();
			instance = (SsrsConfig) loader.unmarshal(SsrsConfig.class.getResourceAsStream("/ssrs-config.xml"));
		} catch (JAXBException e) {
			System.err.println("Error: " + e.getClass().getName() + " " + e.getMessage());
		}
	}
	
	public static SsrsConfig getInstance() {
		return instance;
	}
	
	public SsrsServer getDefaultServer() {
		return servers.get(0);
	}
	
	public List<SsrsServer> getServers() {
		return servers;
	}

	public void setServers(List<SsrsServer> servers) {
		this.servers = servers;
	}
}
