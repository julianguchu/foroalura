package com.foxcreations.springtest.app.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foxcreations.springtest.app.Service.TopicoService;
import com.foxcreations.springtest.app.model.Topico;



@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	private  TopicoService topicoiServiceImpl;
	
	public  TopicosController(TopicoService topicoiServiceImpl) {
		this.topicoiServiceImpl= topicoiServiceImpl;
	}
	

	
	@PostMapping
	public ResponseEntity<?> crearTopico(@RequestBody  @Valid  Topico topico,  BindingResult result){
		List<String>  errorsFormat= new ArrayList<String>();
		if(result.hasErrors()) {
			
			List<ObjectError>errores=result.getAllErrors();
				errores.stream().forEach(objeto ->{ 
					errorsFormat.add(objeto.getDefaultMessage());
					
					
				});
				return   new ResponseEntity<List<String>>(errorsFormat,HttpStatus.BAD_REQUEST);
			
			
		}
		topicoiServiceImpl.crearTopico(topico); //to do excepcion de validacion controler advice
		return  new ResponseEntity<String>("Topico creado con exito", HttpStatus.CREATED);
				
		
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Topico>> listarTopicos(){
		
		return   new ResponseEntity<List<Topico>>(topicoiServiceImpl.listarTopicos(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> encontrarTopicoPorId( @PathVariable("id") Integer id ){
		Optional<Topico> elementoEncontrado= topicoiServiceImpl.buscarTopicoById(id);
		if(!elementoEncontrado.isPresent()) {
			return   new ResponseEntity<String>("topico no encontrado", HttpStatus.NOT_FOUND);
			
		}
		return   new ResponseEntity<Topico>(elementoEncontrado.get(), HttpStatus.OK);
		
	}
	
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarTopico( @PathVariable("id") Integer id,  @RequestBody Topico topico){
		
		
		Optional<Topico> topicoRecuperado=topicoiServiceImpl.buscarTopicoById(id);
		if(!topicoRecuperado.isPresent()) {
			
			return   new ResponseEntity<String>("recurso a actuzalizar no encontrado", HttpStatus.NOT_FOUND);
			
		}
		
		Topico topicoaActualizar= topicoRecuperado.get();
		
		topicoaActualizar.setTitulo(topico.getTitulo());
		topicoaActualizar.setMensaje(topico.getMensaje());
		topicoaActualizar.setFechaCreacion(topico.getFechaCreacion());
		topicoaActualizar.setAutor(topico.getAutor());
		topicoaActualizar.setCurso(topico.getCurso());
		topicoaActualizar.setEstatus(topico.getEstatus());
		
	
		
		
		return   new ResponseEntity<Topico>(topicoiServiceImpl.actualizarTopico(topicoaActualizar), HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarTopico(@PathVariable("id") Integer id ){
		
		Optional<Topico>   elementoEncontrado= topicoiServiceImpl.buscarTopicoById(id);
		if(!elementoEncontrado.isPresent()) {
			return   new ResponseEntity<String >("a  borrar no se ha encontrado", HttpStatus.NOT_FOUND);
		}
		topicoiServiceImpl.eliminarTopico(id);
		
		return   new ResponseEntity<String >("recurso eliminado", HttpStatus.ACCEPTED);
		
	}
	
	
}
