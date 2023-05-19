package kmitl.sci.cs.entp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kmitl.sci.cs.entp.model.Vehicle;

@Repository
public interface RentalRepository extends JpaRepository<Vehicle, Long>{
	Vehicle findByVehicleId(Long vehicleId);
}
