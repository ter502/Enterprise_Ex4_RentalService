package kmitl.sci.cs.entp.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kmitl.sci.cs.entp.model.Vehicle;
import kmitl.sci.cs.entp.repository.RentalRepository;

@Service
@Transactional
public class RentalServiceImpI implements RentalService{
	@Autowired
	private RentalRepository repository;
	
	@Override
	public List<Vehicle> getVehicles() {
		return repository.findAll();
	}
	@Override
	public Vehicle getVehicle(Long vehicleId) {
		return repository.findByVehicleId(vehicleId);
	}
	@Override
	public void create(Vehicle vehicle) {
		repository.save(vehicle);
	}
	@Override
	public void associate(Long vehicleId, String userId) {
		Vehicle v = repository.findByVehicleId(vehicleId);
		v.setOwner(userId);
		v.setStatus("ASSOCIATED");
		v.setAssociationDate(new Date());
		repository.save(v);
	}
	@Override
	public void delete(Long vehicleId) {
		Vehicle v = repository.findByVehicleId(vehicleId);
		v.setOwner(null);
		v.setStatus("AVAILABLE");
		v.setAssociationDate(null);
		repository.save(v);
	}
	
}
