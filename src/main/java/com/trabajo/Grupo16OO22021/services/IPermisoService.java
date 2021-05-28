package com.trabajo.Grupo16OO22021.services;

import java.util.List;

import com.trabajo.Grupo16OO22021.entities.PermisoDiario;
import com.trabajo.Grupo16OO22021.entities.PermisoPeriodo;
import com.trabajo.Grupo16OO22021.models.PermisoDiarioModel;
import com.trabajo.Grupo16OO22021.models.PermisoPeriodoModel;

public interface IPermisoService {

	public List<PermisoPeriodo> getAll();
	
	
	public List<PermisoDiario> getAll1();

	
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel);
	
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permisoDiarioModel);

}
