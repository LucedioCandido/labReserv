package labReserv.api.service;

import java.util.List;
import java.util.Optional;

import labReserv.api.entity.Laboratorio;

public interface LabService {
	Laboratorio salvar(Laboratorio lab);
	Optional<Laboratorio> atualizar(Laboratorio lab);
	List<Laboratorio> obterTodos();
	Optional<Laboratorio> obterPorId(Long id);
	boolean deletar(Laboratorio lab);
}
