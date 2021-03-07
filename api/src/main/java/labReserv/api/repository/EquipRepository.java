package labReserv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import labReserv.api.entity.Equipamento;

@Transactional
public interface EquipRepository extends JpaRepository<Equipamento, Long> {

}
