package com.ngf.cursoionic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ngf.cursoionic.domain.Categoria;
import com.ngf.cursoionic.repositories.CategoriaRepository;
import com.ngf.cursoionic.services.exceptions.DataIntegrityException;
import com.ngf.cursoionic.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}

	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj){
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id){
		find(id);
		try {
		repo.deleteById(id); 
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Erro. Exclusão de Categoria que contem Produtos associados");
		}
	}

}


