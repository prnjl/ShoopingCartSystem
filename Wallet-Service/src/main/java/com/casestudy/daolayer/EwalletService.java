package com.casestudy.daolayer;

import java.util.List;

import com.casestudy.model.Ewallet;
import com.casestudy.model.Statement;

public interface EwalletService {

	public List<Ewallet> getWallets();
	public Ewallet addWallet(Ewallet ewal);
	public void addMoney();
	public Ewallet update(Ewallet ewal);
	public String getById(String id);
	public String deleteById(String id);
	public List<Statement> getStatementsById(String id);
	public List<Statement> getStatements();
	
}
