package mx.profuturo.nci.ws.beans.response;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "codRet", "msgRet", "descRet" })
public class NotificacionConciliacionApovolResponse {
	
	private String codRet;
	private String msgRet;
	private String descRet;
	
	public NotificacionConciliacionApovolResponse() {

	}

	public NotificacionConciliacionApovolResponse(String codRet, String msgRet, String descRet) {
		super();
		this.codRet = codRet;
		this.msgRet = msgRet;
		this.descRet = descRet;
	}

	public String getCodRet() {
		return codRet;
	}

	public void setCodRet(String codRet) {
		this.codRet = codRet;
	}

	public String getMsgRet() {
		return msgRet;
	}

	public void setMsgRet(String msgRet) {
		this.msgRet = msgRet;
	}

	public String getDescRet() {
		return descRet;
	}

	public void setDescRet(String descRet) {
		this.descRet = descRet;
	}
	
	
	
	

}
