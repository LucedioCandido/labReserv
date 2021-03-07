package labReserv.api.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import labReserv.api.entity.Equipamento;
import labReserv.api.entity.Laboratorio;
import labReserv.api.entity.Sala;
import labReserv.api.repository.CadEquipRepository;
import labReserv.api.repository.CadLabRepository;
import labReserv.api.repository.CadSalaRepository;


@RestController
@RequestMapping(path = "/api/cadastros")
public class Cadastros {
	
	private CadLabRepository repoLab;
	private CadSalaRepository repoSala;
	private CadEquipRepository repoEqui;
	
	
	/*public List<Laboratorio> getzao(){
		List<Laboratorio> labs = new ArrayList<>();
		Laboratorio lab = new Laboratorio();
		lab.setNome("LMBG");
		labs.add(lab);
		return labs;
	}
	
	public Laboratorio getLab() {
		Laboratorio lab = new Laboratorio();
		lab.setNome("LMBG");
		return lab;
	}*/
	
	@GetMapping
	public ResponseEntity<List<Laboratorio>> getLabs(){
		List<Laboratorio> labs = new ArrayList<>();
		labs = repoLab.findAll();
		return new ResponseEntity<>(labs, HttpStatus.OK);
	}
	
	@PostMapping("/cadastrarLab")
	public ResponseEntity cadastrarLab(@RequestBody Laboratorio novoLab) {
		
		try {
			Laboratorio lab = new Laboratorio(novoLab.getNome());
			lab = repoLab.save(lab);
			//lab = getLab();
			return new ResponseEntity(lab, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
				
	}
	
	@PostMapping("/cadastrarSala")
	public ResponseEntity cadastrarSala(@RequestBody Sala novaSala) {
		
		try {
			Sala sala = new Sala(novaSala.getIdLab(),novaSala.getNome());
			sala = repoSala.save(sala);
			return new ResponseEntity(sala, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
				
	}
	
	@PostMapping("/cadastrarEquip")
	public ResponseEntity cadastrarEquip(@RequestBody Equipamento novoEquip) {
		
		try {
			Equipamento equip = new Equipamento(novoEquip.getIdSala(),novoEquip.getTombamento(), novoEquip.getNome());
			equip = repoEqui.save(equip);
			return new ResponseEntity(equip, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
				
	}
	
}
