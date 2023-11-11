package com.marketingapp.services;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {
	public void saveOneLead(Lead l);

	public List<Lead> listAllLeads();    //26.09.22

	public void deleteOnelead(long id);    //27.09.22

	public Lead getById(long id);
	

}
