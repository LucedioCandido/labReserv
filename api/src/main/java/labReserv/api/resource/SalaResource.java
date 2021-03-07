package labReserv.api.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import labReserv.api.entity.Equipamento;
import labReserv.api.entity.Sala;
import labReserv.api.exception.ErroNaoExisteRegistroNoBD;
import labReserv.api.service.SalaService;

@RestController
@RequestMapping("/sala")
public class SalaResource {
	
	SalaService servico;

	public SalaResource(SalaService servico) {
		super();
		this.servico = servico;
	}
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Sala>> listar(){
		List<Sala> salas = new ArrayList<>();
		salas = servico.obtertodos();
		return new ResponseEntity<>(salas, HttpStatus.OK);
	}
	
	@GetMapping("/salas-lab/{id}")
	public ResponseEntity<List<Sala>> listarPorLab(@PathVariable("id") Long id){
		List<Sala> salas = new ArrayList<>();
		salas = servico.obterPorLab(id);
		return new ResponseEntity<>(salas, HttpStatus.OK);
	}
		
	
	@GetMapping("/equipamentos")
	public ResponseEntity<List<Equipamento>> listarEquipamentosSala(@RequestBody Sala sala){
		List<Equipamento> equipamentos = new ArrayList<>();
		equipamentos = servico.obterEquipamentos(sala);
		return new ResponseEntity<>(equipamentos, HttpStatus.OK);
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarSala(@RequestBody Sala novaSala) {
		try {
			return new ResponseEntity<>(servico.salvar(novaSala), HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarLab(@RequestBody Sala sala) {
		try {
			return new ResponseEntity<>(servico.atualizar(sala), HttpStatus.OK);
		}catch (ErroNaoExisteRegistroNoBD e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<?> deleteLab(@RequestBody Sala sala) {
		try {
			servico.deletar(sala);
			return new ResponseEntity<>(HttpStatus.OK);
					
		}catch (ErroNaoExisteRegistroNoBD e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}
	
	
	
}
