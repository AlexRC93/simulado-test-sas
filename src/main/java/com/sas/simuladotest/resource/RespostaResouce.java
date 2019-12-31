package com.sas.simuladotest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sas.simuladotest.entity.Resposta;
import com.sas.simuladotest.repository.RespostaRepository;

@RestController
@RequestMapping("/respostas")
public class RespostaResouce {
	
	@Autowired
	private RespostaRepository respostaRepository;
	
	@GetMapping
	public List<Resposta> listar() {
		return respostaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<Resposta> salvar(@RequestBody List<Resposta> respostas) {
		return respostaRepository.saveAll(respostas);
	}

}
