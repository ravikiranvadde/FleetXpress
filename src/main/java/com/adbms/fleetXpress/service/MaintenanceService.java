package com.adbms.fleetXpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbms.fleetXpress.entity.Maintenance;
import com.adbms.fleetXpress.repo.MaintenanceRepository;

@Service
public class MaintenanceService {
	
	@Autowired
	public MaintenanceRepository maintenanceRepo;
	
	public List<Maintenance> getAllMaintenanceDetails(){
		return maintenanceRepo.findAll();
	}

}
