package labReserv.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import labReserv.api.repository.LabRepository;

@RestController
@RequestMapping("/laboratorio")
public class LabResource {
	
	private LabRepository repository;

	public LabResource(LabRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Laboratorio>> listar(){
		List<Laboratorio> labs = new ArrayList<>();
		labs = repository.findAll();
		return new ResponseEntity<>(labs, HttpStatus.OK);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarLab(@RequestBody Laboratorio novoLab) {
		try {
			return new ResponseEntity<>(repository.save(novoLab), HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarLab(@RequestBody Laboratorio lab) {
		try {
			Optional<Laboratorio> laboratorio;
			laboratorio = repository.findById(lab.getId());
			
			if(laboratorio.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<>( repository.save(lab), HttpStatus.OK);
			}
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<?> deleteLab(@RequestBody Laboratorio lab) {
		try {
			Optional<Laboratorio> laboratorio;
			laboratorio = repository.findById(lab.getId());
			
			if(laboratorio.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}else {
				repository.deleteById(lab.getId());
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}
	
}
