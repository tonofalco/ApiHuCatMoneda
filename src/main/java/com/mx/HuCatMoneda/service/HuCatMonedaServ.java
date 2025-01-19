package com.mx.HuCatMoneda.service;

import java.util.List;

import com.mx.HuCatMoneda.model.HuCatMoneda;

public interface HuCatMonedaServ {

	public List<HuCatMoneda> listar();
	
	public HuCatMoneda buscar(Long id);

	public HuCatMoneda guardar(HuCatMoneda hcm);
	
	public void actualizar(HuCatMoneda hcm);

	public void eliminar(Long id);

}
