package kmitl.sci.cs.entp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonInclude(Include.NON_NULL)
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vehicleId;
	
	@Column(length=30)
	@JsonProperty("status")
	private String status;
	
	@Column(length=30)
	@JsonProperty("owner")
	private String owner;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
	@JsonProperty("association_data")
	private Date associationDate;
	
	public Vehicle() {
		status = "AVAILABLE";
	}

	public Long getId() {
		return vehicleId;
	}
	public void setId(Long id) {
		this.vehicleId = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getAssociationDate() {
		return associationDate;
	}
	public void setAssociationDate(Date associationDate) {
		this.associationDate = associationDate;
	}
	public String showInfo() {
		return "id = " + vehicleId + " Status = " + status + " Owner = " + owner + " AssociationDate = " + associationDate;
	}
	
}
