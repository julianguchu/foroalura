package com.foxcreations.springtest.app.ServiceImp;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.foxcreations.springtest.app.Service.TopicoService;
import com.foxcreations.springtest.app.model.Topico;
import com.foxcreations.springtest.app.repository.TopicoRepository;

@Service
public class TopicoServiceImp   implements TopicoService{
	
	private TopicoRepository topicoRepository;
	

	public  TopicoServiceImp(TopicoRepository topicoRepository) {
		this.topicoRepository= topicoRepository;
		
		
	}
	

	public void crearTopico(Topico topico) {
		topicoRepository.save(topico);
		
	}

	public List<Topico> listarTopicos() {
		// TODO Auto-generated method stub
		return (List<Topico>) topicoRepository.findAll();
	}

	public Optional<Topico> buscarTopicoById(Integer id) {
		
		return topicoRepository.findById(id);
	}

	public void eliminarTopico(Integer id) {
		topicoRepository.deleteById(id);
		
	}

	public Topico actualizarTopico(Topico topico) {
		
		return topicoRepository.save(topico);
	}

}
