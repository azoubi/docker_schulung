package de.gedoplan.docker_workshop.rest_demo.domain;

public class PodInfo {
	
	private String hostname;
	private String nodename;
	private String namespace;
	private String podip;
	private String podname;

	public PodInfo(String hostname, String nodename, String namespace, String ip, String podname) {
		this.hostname = hostname;
		this.nodename = nodename;
		this.namespace = namespace;
		this.podip = ip;
		this.podname = podname;
	}


	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getNodename() {
		return nodename;
	}

	public void setNodename(String nodename) {
		this.nodename = nodename;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getPodip() {
		return podip;
	}

	public void setPodip(String podip) {
		this.podip = podip;
	}

	public String getPodname() {
		return podname;
	}

	public void setPodname(String podname) {
		this.podname = podname;
	}


}
