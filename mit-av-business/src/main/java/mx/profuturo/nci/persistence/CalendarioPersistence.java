package mx.profuturo.nci.persistence;

import java.util.Date;

import mx.profuturo.nci.stereotype.Mapper;

@Mapper
public interface CalendarioPersistence {
	Date selectNextLaborDay(Date fecha);
	Short isDiaHabil(Date fecha);
	String isDiaHabilNom(Date fecha);
}
