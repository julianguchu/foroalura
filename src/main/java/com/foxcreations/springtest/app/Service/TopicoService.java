package com.foxcreations.springtest.app.Service;

import java.util.List;
import java.util.Optional;

import com.foxcreations.springtest.app.model.Topico;

public interface TopicoService {

	
	void crearTopico (Topico topico);
	List<Topico> listarTopicos ();
	Optional<Topico> buscarTopicoById(Integer id);
	void eliminarTopico (Integer id);
	Topico  actualizarTopico(Topico topico);
	
}
