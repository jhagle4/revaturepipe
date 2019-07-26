package com.revature.service;

import java.util.List;

import com.revature.model.Stock;

public interface StockService {



	// Stock getStockById(int id);

	//public Stock insertStock(int id, String symbol, int amount, double price);

	// Stock getStockById(HttpServletRequest req, HttpServletResponse resp);
	public Stock getStockById(int id);

	void updateStock(int amount, int id);

	public void removeStock(int id);

	List<Stock> getAllStocks(int id);

	Stock insertStock(double purchaseprice, String symbol, int amount, int portid);

}
