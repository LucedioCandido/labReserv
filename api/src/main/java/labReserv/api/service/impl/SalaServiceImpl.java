package labReserv.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labReserv.api.entity.Equipamento;
import labReserv.api.entity.Sala;
import labReserv.api.exception.ErroNaoExisteRegistroNoBD;
import labReserv.api.repository.SalaRepository;
import labReserv.api.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService {
	
	SalaRepository repository;
	
	@Autowired
	public SalaServiceImpl(SalaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Sala salvar(Sala sala) {	
		return repository.save(sala);
	}

	@Override
	public Optional<Sala> atualizar(Sala sala) {
		Optional<Sala> salaUp = repository.findById(sala.getId());
		
		if(salaUp.isPresent()) {
			Sala retorno = repository.save(sala);
			
			return Optional.of(retorno);
		}
		
		throw new ErroNaoExisteRegistroNoBD("Sala inexistente na base da dados");
	}

	@Override
	public boolean deletar(Sala sala) {
		Optional<Sala> salaOpt;
		salaOpt = repository.findById(sala.getId());
		if(salaOpt.isPresent()) {
			repository.delete(sala);
			return true;
		}else {
			throw new ErroNaoExisteRegistroNoBD("Sala inexistente na base da dados");
		}
	}

	@Override
	public List<Sala> obtertodos() {
		return repository.findAll();
	}

	@Override
	public Optional<Sala> obterPorId(Long id) {
		Optional<Sala> salaOpt;
		salaOpt = repository.findById(id);
		if(salaOpt.isPresent()) {
			return salaOpt;
		}else {
			throw new ErroNaoExisteRegistroNoBD("Sala inexistente na base da dados");
		}
	}

	@Override
	public List<Sala> obterPorLab(Long lab) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipamento> obterEquipamentos(Sala sala) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
