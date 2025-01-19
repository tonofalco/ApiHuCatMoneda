package com.mx.HuCatMoneda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.HuCatMoneda.dao.huCatModnedaDao;
import com.mx.HuCatMoneda.model.HuCatMoneda;

@Service
public class HuCatMonedaServImp implements HuCatMonedaServ {
	
	@Autowired
	huCatModnedaDao dao;
	
	@Override
	public List<HuCatMoneda> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Override
	public HuCatMoneda buscar(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public HuCatMoneda guardar(HuCatMoneda hcm) {
		// TODO Auto-generated method stub
		return dao.save(hcm);
	}
	
	@Override
	public void actualizar(HuCatMoneda hcm) {
		// TODO Auto-generated method stub
		dao.save(hcm);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	


}
