package com.trabajo.Grupo16OO22021.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trabajo.Grupo16OO22021.converters.PermisoConverter;
import com.trabajo.Grupo16OO22021.entities.Lugar;
import com.trabajo.Grupo16OO22021.entities.Permiso;
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
	@Override
	public boolean validatePermisoPeriodo(PermisoPeriodoModel permisoPeriodoModel) {
		if(permisoPeriodoModel.getPedido()==null||permisoPeriodoModel.getRodado()==null||permisoPeriodoModel.getCantDias()==0||permisoPeriodoModel.getFecha().toString().equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean validetePermisoDiario(PermisoDiarioModel permisoDiarioModel) {
		if(permisoDiarioModel.getPedido()==null||permisoDiarioModel.getFecha().toString().equals("")||permisoDiarioModel.getMotivo().equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public List<PermisoDiario> traerDiarioEntreFechas(LocalDate desde, LocalDate hasta){
		
		List<PermisoDiario> permisos = this.getAll1();
		List<PermisoDiario> permisosOk = new ArrayList<PermisoDiario>();
		
		for (PermisoDiario permiso : permisos) {
			
			if(permiso.getFecha().isAfter(desde) && permiso.getFecha().isBefore(hasta)) {

				permisosOk.add(permiso);
			
			}
	
		}
		return permisosOk;
	}
	
public List<PermisoPeriodo> traerPeriodoEntreFechas(LocalDate desde, LocalDate hasta){
		
		List<PermisoPeriodo> permisos = this.getAll();
		List<PermisoPeriodo> permisosOk = new ArrayList<PermisoPeriodo>();
		
		for (PermisoPeriodo permiso : permisos) {
			
			LocalDate desdePlus = desde.minusDays(permiso.getCantDias());
			
			if(permiso.getFecha().isAfter(desdePlus) && permiso.getFecha().isBefore(hasta)) {

				permisosOk.add(permiso);
			}
	
		}
		return permisosOk;
	}
		
		
	public List<PermisoDiario> traerDiarioFechaYLugar(LocalDate fechaDesde, LocalDate fechaHasta, Lugar lugar) {

		List<PermisoDiario> permisosDiario = this.traerDiarioEntreFechas(fechaDesde, fechaHasta);
		List<PermisoDiario> permisosDiario2 = new ArrayList<PermisoDiario>();

		for (PermisoDiario permisoDiario : permisosDiario) {

				for (Lugar permisoLugar : permisoDiario.getDesdeHasta()) {
					if(permisoLugar.getIdLugar() == lugar.getIdLugar())
						permisosDiario2.add(permisoDiario);
				}
		}
		return permisosDiario2;
	}

	public List<PermisoPeriodo> traerPeriodoFechaYLugar(LocalDate fechaDesde, LocalDate fechaHasta, Lugar lugar) {
		
		List<PermisoPeriodo> permisosPeriodo = this.traerPeriodoEntreFechas(fechaDesde, fechaHasta);
		List<PermisoPeriodo> permisosPeriodoOk = new ArrayList<PermisoPeriodo>();

		for (PermisoPeriodo permisoPeriodo : permisosPeriodo) {

				for (Lugar permisoLugar : permisoPeriodo.getDesdeHasta()) {
					if(permisoLugar.getIdLugar() == lugar.getIdLugar())
						permisosPeriodoOk.add(permisoPeriodo);
				}
		}
		return permisosPeriodoOk;		 
	}
//	List<PermisoDiario> permisoDiarioLista = permisoService.getAll1();
//	List<PermisoDiario> permisoDiarioLista1 = new ArrayList<PermisoDiario>();

//	List<PermisoPeriodo> permisoPeriodoLista = permisoService.getAll();
//	List<PermisoPeriodo> permisoPeriodoLista1 = new ArrayList<PermisoPeriodo>();
//
//	for (PermisoDiario permisoDiarioLista2 : permisoDiarioLista) {
//		if (permisoDiarioLista2.getFecha().isAfter(fechaDesde1)
//				&& permisoDiarioLista2.getFecha().isBefore(fechaHasta1)) {
//			permisoDiarioLista1.add(permisoDiarioLista2);
//		}
//	}
//	for (PermisoPeriodo permisoPeriodoLista2 : permisoPeriodoLista) {
//		if (permisoPeriodoLista2.getFecha().isAfter(fechaDesde1)
//				&& permisoPeriodoLista2.getFecha().isBefore(fechaHasta1)) {
//			permisoPeriodoLista1.add(permisoPeriodoLista2);
//		}
//	}
	


}