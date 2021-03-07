package labReserv.api.service;

import java.util.List;
import java.util.Optional;

import labReserv.api.entity.Equipamento;
import labReserv.api.entity.Sala;

public interface SalaService {
	Sala salvar(Sala sala);
	Optional<Sala> atualizar(Sala sala);
	boolean deletar(Sala sala);
	List<Sala> obtertodos();
	Optional<Sala> obterPorId(Long id);
	List<Sala> obterPorLab(Long lab);
	List<Equipamento> obterEquipamentos(Sala sala);
}
