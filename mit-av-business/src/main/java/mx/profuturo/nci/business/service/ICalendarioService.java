package mx.profuturo.nci.business.service;

import java.util.Date;

import mx.profuturo.nci.business.exception.MitBusinessException;

public interface ICalendarioService {
	Date consultaSiguienteDiaHabil(Date fecha) throws MitBusinessException;
	Boolean esDiaHabil(Date fecha) throws MitBusinessException;
	String esDiaHabilNom(Date fecha) throws MitBusinessException;
}
