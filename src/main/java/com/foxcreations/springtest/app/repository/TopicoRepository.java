package com.foxcreations.springtest.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foxcreations.springtest.app.model.Topico;

@Repository
public interface TopicoRepository  extends CrudRepository<Topico, Integer>{

}
