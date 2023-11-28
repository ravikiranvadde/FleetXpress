package com.adbms.fleetXpress.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adbms.fleetXpress.entity.Maintenance;
import com.adbms.fleetXpress.service.MaintenanceService;

@RestController
public class MaintenanceController {
	@Autowired
	private MaintenanceService maintenanceService;
	
	@GetMapping("/admin/maintenance")
    public ModelAndView getAllCars() {
		ModelAndView modelAndView = new ModelAndView();
		List<Maintenance> maintenances = maintenanceService.getAllMaintenanceDetails();
        modelAndView.addObject("maintenanceList", maintenances);
        modelAndView.setViewName("maintenance");
        return modelAndView;
    }
}
