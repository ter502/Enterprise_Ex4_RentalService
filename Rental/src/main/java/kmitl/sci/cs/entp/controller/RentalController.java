package kmitl.sci.cs.entp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kmitl.sci.cs.entp.Service.RentalService;
import kmitl.sci.cs.entp.model.Vehicle;

@RestController
@RequestMapping("/v1")
public class RentalController {
	@Autowired
	private RentalService service;	
	@GetMapping("/vehicles")
	public List<Vehicle> getVehicles() {
		return service.getVehicles();
	}
	@GetMapping("/vehicles/{id}")
	public Vehicle getVehicle(@PathVariable("id") String vehicleId) {
		return service.getVehicle(Long.valueOf(vehicleId));
	}
	@PostMapping("/create")
	public void creat(@RequestBody Vehicle vehicle) {
		service.create(vehicle);
	}
	@PostMapping("{vehicleId}/vehicles/{userId}")
	public void associate(@PathVariable("vehicleId") String vehicleId, @PathVariable("userId") String userId) {
		Vehicle vehicle = service.getVehicle(Long.valueOf(vehicleId));
		if(vehicle != null) {
			service.associate(Long.valueOf(vehicleId), userId);
		}
	}
	@DeleteMapping("{vehicleId}/vehicles/{userId}")
	public void delete(@PathVariable("vehicleId") String vehicleId, @PathVariable("userId") String userId) {
		Vehicle vehicle = service.getVehicle(Long.valueOf(vehicleId));
		if(vehicle != null) {
			service.delete(Long.valueOf(vehicleId));
		}
	}
}
