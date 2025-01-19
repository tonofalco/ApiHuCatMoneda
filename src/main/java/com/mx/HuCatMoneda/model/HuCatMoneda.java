package com.mx.HuCatMoneda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//CREATE TABLE HU_CAT_MONEDA ( 
//	    NUM_CIA NUMBER(4, 0) PRIMARY KEY, 
//	    CLAVE_MONEDA VARCHAR2(3), 
//	    DESCRIPCION VARCHAR2(30), 
//	    SIMBOLO VARCHAR2(5), 
//	    ABREVIACION VARCHAR2(5), 
//	    MONEDA_CORRIENTE CHAR(1), 
//	    STATUS CHAR(1)
//	);


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HuCatMoneda {
	
	@Id
	@Column(name="NUM_CIA") private Long idNumCia;
	
	@Column(name="CLAVE_MONEDA") private String claveMoneda;
	
	@Column(name="DESCRIPCION") private String descripcion;
	
	@Column(name="SIMBOLO") private String simbolo;
	
	@Column(name="ABREVIACION") private String abreviacion;
	
	@Column(name="MONEDA_CORRIENTE") private String monedaCorriente;
	
	@Column(name="STATUS") private String status;

}
