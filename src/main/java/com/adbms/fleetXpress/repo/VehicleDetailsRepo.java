package com.adbms.fleetXpress.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.dto.VehicleDetails;
import com.adbms.fleetXpress.dto.VehicleDetailsProjection;
import com.adbms.fleetXpress.entity.VehicleSpec;

@Repository
public interface VehicleDetailsRepo extends JpaRepository<VehicleSpec, Long> {

//	@Query(value = "select new com.adbms.fleetXpress.dto.VehicleDetails(v.vehicleid, v.make,v.model,v.year,v.licensePlate, vc.VehicleSpec, m.maintenanceType, m.maintenanceDate) "
//			+ "from Vehicle v " + "left join VehicleSpec vc on vc.vehicleid = v.vehicleid "
//			+ "left join Maintenance m on m.vehicle.vehicleid = v.vehicleid " + "where v.vehicleid =:id", nativeQuery = true)
//	VehicleDetails getVehicleDetailsByVehicleId(Long id);
	
	
	@Query(value = "select v.make as make,v.model as model,v.\"year\" as year ,v.licenseplate as licensePlate, STRING_AGG(CONCAT(m.maintenanceType, ': ', m.maintenanceDate), ', ') AS maintenanceDetails, vs.vehicle_spec as vehicle_spec FROM vehicle v LEFT JOIN maintenance m ON m.vehicleid = v.vehicleid LEFT JOIN vehicle_specs vs ON vs.vehicleid = v.vehicleid WHERE v.vehicleid = :id GROUP by v.vehicleid,vs.spec_id"
			,nativeQuery = true)
	VehicleDetailsProjection getVehicleDetails(Long id);

}
