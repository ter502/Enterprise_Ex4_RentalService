package kmitl.sci.cs.entp.Service;

import java.util.List;

import kmitl.sci.cs.entp.model.Vehicle;

public interface RentalService {
	public List<Vehicle> getVehicles();
	public Vehicle getVehicle (Long vehicleId);
	public void create(Vehicle vehicle);
	public void associate(Long vehicleId, String userId);
	public void delete(Long vehicleId);
}
