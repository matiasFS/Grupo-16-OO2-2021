package com.trabajo.Grupo16OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trabajo.Grupo16OO22021.converters.PermisoConverter;
import com.trabajo.Grupo16OO22021.entities.PermisoDiario;
import com.trabajo.Grupo16OO22021.entities.PermisoPeriodo;
import com.trabajo.Grupo16OO22021.models.PermisoDiarioModel;
import com.trabajo.Grupo16OO22021.models.PermisoPeriodoModel;
import com.trabajo.Grupo16OO22021.repositories.IPermisoDiarioRepository;
import com.trabajo.Grupo16OO22021.repositories.IPermisoPeriodoRepository;
import com.trabajo.Grupo16OO22021.services.IPermisoService;

@Qualifier("permisoService")
@Service
public class PermisoService implements IPermisoService {

	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	
	@Override
	public List<PermisoPeriodo> getAll() {
		return permisoPeriodoRepository.findAll();
	}
	@Override
	public List<PermisoDiario> getAll1() {
		return permisoDiarioRepository.findAll();
	}

	@Override
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel) {
	
		PermisoPeriodo permiso = permisoPeriodoRepository.save(permisoConverter.modelToEntity(permisoPeriodoModel));
		permiso = permisoPeriodoRepository.save(permiso);
		
	return  permisoConverter.entityToModel(permiso);
	}


	

	@Override
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permisoDiarioModel) {
		
		PermisoDiario permiso = permisoDiarioRepository.save(permisoConverter.permisoDiarioModelToEntity(permisoDiarioModel));
		permiso = permisoDiarioRepository.save(permiso);
		
	return  permisoConverter.permisoDiarioEntityToModel(permiso);
	}

	


}