package com.sas.simuladotest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.simuladotest.entity.Gabarito;
import com.sas.simuladotest.repository.GabaritoRepository;

@RestController
@RequestMapping("/gabaritos")
public class GabaritoResource {
	
	@Autowired
	private GabaritoRepository gabaritoRepository;
	
	
	@GetMapping("/prova/{idProva}")
	public List<Gabarito> buscarGabaritoPeloIdDaProva(@PathVariable("idProva") Long idProva) {
		return gabaritoRepository.buscarGabaritoPeloIdDaProva(idProva);
	}

}
