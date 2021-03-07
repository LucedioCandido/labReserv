package labReserv.api.resource;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import labReserv.api.entity.Laboratorio;
import labReserv.api.exception.ErroNaoExisteRegistroNoBD;
import labReserv.api.service.LabService;

@RestController
@RequestMapping("/laboratorio")
public class LabResource {
	
	private LabService servico;
	
	public LabResource(LabService servico) {
		super();
		this.servico = servico;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Laboratorio>> listar(){
		List<Laboratorio> labs = new ArrayList<>();
		labs = servico.obterTodos();
		return new ResponseEntity<>(labs, HttpStatus.OK);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarLab(@RequestBody Laboratorio novoLab) {
		try {
			return new ResponseEntity<>(servico.salvar(novoLab), HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarLab(@RequestBody Laboratorio lab) {
		try {
			return new ResponseEntity<>(servico.atualizar(lab), HttpStatus.OK);
		}catch (ErroNaoExisteRegistroNoBD e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<?> deleteLab(@RequestBody Laboratorio lab) {
		try {
			servico.deletar(lab);
			return new ResponseEntity<>(HttpStatus.OK);
					
		}catch (ErroNaoExisteRegistroNoBD e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}

}
