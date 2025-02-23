package utp.soa.avance.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import utp.soa.avance.model.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier,Long> {
}
