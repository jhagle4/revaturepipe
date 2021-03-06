package com.revature.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.revature.model.Portfolio;

/*
 * The PortfolioRepository listing the methods that will be implemented in the 
 * PortfolioRepository will implement. 
 */

@Repository("pr")
public interface PortfolioRepository {

	List<Portfolio> getAllPortfolios(String username);	
	Portfolio getPortfolioById(int id);
	Portfolio insertPortfolio(String user, String portname);
	Portfolio sellPortfolio(int id);

}
