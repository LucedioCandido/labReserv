package labReserv.api.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labReserv.api.entity.Laboratorio;
import labReserv.api.exception.ErroNaoExisteRegistroNoBD;
import labReserv.api.repository.LabRepository;
import labReserv.api.service.LabService;

@Service
public class LabServiceImpl implements LabService{
	
	private LabRepository repository;
		
	@Autowired
	public LabServiceImpl(LabRepository repository) {
		super();
		this.repository = repository;
	}
	

	@Override
	public Laboratorio salvar(Laboratorio lab) {
		return repository.save(lab);
	}

	@Override
	public Optional<Laboratorio> atualizar(Laboratorio lab) {
		
		Optional<Laboratorio> laboratorio = repository.findById(lab.getId());
				
		if(laboratorio.isPresent()) {
			Laboratorio retorno = repository.save(lab);
			
			return Optional.of(retorno);
		}
		
		throw new ErroNaoExisteRegistroNoBD("Laboratório não existe na base da dados");
	}


	@Override
	public Optional<Laboratorio> obterPorId(Long id) {
		Optional<Laboratorio> laboratorio;
		laboratorio = repository.findById(id);
		if(laboratorio.isPresent()) {
			return laboratorio;
		}else {
			return null;
		}
	}


	@Override
	public List<Laboratorio> obterTodos() {
		return repository.findAll();
	}


	@Override
	public boolean deletar(Laboratorio lab) {
		Optional<Laboratorio> laboratorio;
		laboratorio = repository.findById(lab.getId());
		if(laboratorio.isPresent()) {
			repository.delete(lab);
			return true;
		}else {
			throw new ErroNaoExisteRegistroNoBD("Laboratório não existe na base da dados");
		}
	}
	
}
