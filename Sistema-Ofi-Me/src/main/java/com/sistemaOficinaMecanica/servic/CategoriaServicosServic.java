package com.sistemaOficinaMecanica.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaOficinaMecanica.model.CategoriaServicos;
import com.sistemaOficinaMecanica.repository.CategoriaServicosRepository;

@Service
public class CategoriaServicosServic {
	
	@Autowired
	private CategoriaServicosRepository repo;
	
	public List<CategoriaServicos> listarTodos() {
		return repo.findAll();
	}
	
	public CategoriaServicos salvar(CategoriaServicos cat) {
		return repo.save(cat);
	}
	public void deletar(Long id) {
		repo.deleteById(id);
	}
	public CategoriaServicos buscarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}
}
