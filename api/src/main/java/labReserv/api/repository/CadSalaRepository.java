package labReserv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import labReserv.api.entity.Sala;

@Transactional
public interface CadSalaRepository extends JpaRepository<Sala, Long>{

}
