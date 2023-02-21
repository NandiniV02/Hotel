package com.sprint1.HBA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.HBA.entities.Admin;
import com.sprint1.HBA.repositories.AdminDao;


@Service
public class AdminService {
	@Autowired
	AdminDao ad;
	public String insertAdmin(Admin admin)
	{
		ad.save(admin);
		return "Admin Registered Successfully";
	}
	
     public String authenticateAdmin(Admin admin) {
		
		Optional<Admin> opAdmin=ad.findById(admin.getAdminId());
		if(opAdmin.isPresent()) {
			Admin dbAdmin=opAdmin.get();
			if(admin.getAdminPassword().equals(dbAdmin.getAdminPassword())) {
				dbAdmin.setAuthenticated(true);
				ad.save(dbAdmin);
				return "Authenticated Successfully";
				}
			else
				return "Incorrect Password";
		}
		else return "No Admin";
	}

	public List<Admin> showAllAdmins() {
		// TODO Auto-generated method stub
		return ad.findAll();
	}

	public Optional<Admin> getAdminById(int id) {
		// TODO Auto-generated method stub
		return ad.findById(id);
	}
}




