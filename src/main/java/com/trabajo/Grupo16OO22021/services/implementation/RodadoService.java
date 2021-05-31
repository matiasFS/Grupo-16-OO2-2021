package com.trabajo.Grupo16OO22021.services.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trabajo.Grupo16OO22021.converters.RodadoConverter;
import com.trabajo.Grupo16OO22021.entities.Rodado;
import com.trabajo.Grupo16OO22021.models.RodadoModel;
import com.trabajo.Grupo16OO22021.repositories.IRodadoRepository;
import com.trabajo.Grupo16OO22021.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService{
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	
	@Override
	public List<Rodado> getAll() {
		return rodadoRepository.findAll();
	}

	@Override
	public RodadoModel insertOrUpdate(RodadoModel rodadoModel) {
		Rodado rodado = rodadoRepository.save(rodadoConverter.modelToEntity(rodadoModel));
		rodado = rodadoRepository.save(rodado);
		
	return  rodadoConverter.entityToModel(rodado);
	}


	@Override
	public RodadoModel findById(int id) {
		return rodadoConverter.entityToModel(rodadoRepository.findById(id));
	}

	@Override
	public boolean validate(RodadoModel rodadoModel) {
		if(rodadoModel.getDominio().equals("")||rodadoModel.getVehiculo().equals("")||rodadoModel.getVehiculo().length()<3) {
			return false;
		} else {
			return true;
		}
		
	}


}
