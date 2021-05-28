package com.trabajo.Grupo16OO22021.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trabajo.Grupo16OO22021.repositories.IPersonaRepository;
import com.trabajo.Grupo16OO22021.converters.PersonaConverter;
import com.trabajo.Grupo16OO22021.entities.Persona;
import com.trabajo.Grupo16OO22021.models.PersonaModel;
import com.trabajo.Grupo16OO22021.services.IPersonaService;


@Qualifier("PersonaService")
@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	@Qualifier("PersonaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("PersonaConverter")
	private PersonaConverter personaConverter;
	
	@Override
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}

	@Override
	public PersonaModel insertOrUpdate(PersonaModel personaModel) {
		Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModel));
		
		return personaConverter.entityToModel(persona);
	}

	@Override
	public boolean remove(int id) {

		try {
			personaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public PersonaModel findById(int id) {
		return personaConverter.entityToModel(personaRepository.findById(id));
	}

	@Override
	public boolean validate(PersonaModel personaModel) {
		if(personaModel.getNombre().equals("") || personaModel.getApellido().equals("")
				|| Long.toString(personaModel.getDocumento()).length()<7) {
			return false;
		} else {
			return true;
		}
		
	}

}
