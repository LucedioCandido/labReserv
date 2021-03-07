package labReserv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import labReserv.api.entity.Laboratorio;

@Transactional
public interface LabRepository extends JpaRepository<Laboratorio, Long> {

}
