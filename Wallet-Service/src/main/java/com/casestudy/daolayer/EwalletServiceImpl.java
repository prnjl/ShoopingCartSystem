package com.casestudy.daolayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.casestudy.model.Ewallet;
import com.casestudy.model.Statement;
import com.casestudy.repository.EwalletRepository;
import com.casestudy.repository.StatementsRepository;

public class EwalletServiceImpl implements EwalletService  {
	
	@Autowired
	EwalletRepository EwalRepo;
	
	@Autowired
	StatementsRepository sRepo;
	@Override
	public List<Ewallet> getWallets() {
		
		return (List<Ewallet>) EwalRepo.findAll();
	}

	@Override
	public Ewallet addWallet(Ewallet ewal) {
		
		Ewallet ew = EwalRepo.save(ewal);
		return ew;
	}

	@Override
	public void addMoney() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Ewallet update(Ewallet ewal) {
		
		Ewallet ew = EwalRepo.save(ewal);
		return ew;
		
	}
	@Override
	public String getById(String eid) {
		
		EwalRepo.findById(eid);	
		return "Ewallet "+eid +"got";
	}

	@Override
	public String deleteById(String id) {
		EwalRepo.deleteById(id);
		return "Ewallet" +id+ "deleted";
		
	}
	@Override
	public List<Statement> getStatementsById(String id) {
		
	  //return (List<Statement>) sRepo;
		return null;
	}

	@Override
	public List<Statement> getStatements() {
		
		return (List<Statement>) sRepo.findAll();
	}

}
