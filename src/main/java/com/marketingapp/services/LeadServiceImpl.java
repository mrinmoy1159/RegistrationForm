package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repositories.LeadRepository;
@Service     // springboot know this is model layer beacuse of @service annotation
public class LeadServiceImpl implements LeadService {    //21.09.22
	
	@Autowired    //Springboot automatically create object and inject address.
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead l) {
		leadRepo.save(l);

	}

	@Override
	public List<Lead> listAllLeads() {
		// TODO Auto-generated method stub
		List<Lead> leads = leadRepo.findAll();    //26.09.22
	    return leads;
	}

	@Override
	public void deleteOnelead(long id) {    //27.09.22
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead getById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		 Lead lead = findById.get();
		 return lead;
	}



}
