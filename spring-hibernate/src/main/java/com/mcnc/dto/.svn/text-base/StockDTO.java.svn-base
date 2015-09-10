package com.mcnc.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class StockDTO{
	private String stockId;
	private String stockName;
	
	private Set<StockDetailDTO> stockDetails = new HashSet<StockDetailDTO>();
	
	@Id
	@Column(name = "stock_id")
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
	@Column(name = "stock_name")
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="stock") // mappedBy to field of StockDetailDTO
	public Set<StockDetailDTO> getStockDetails() {
		return stockDetails;
	}
	public void setStockDetails(Set<StockDetailDTO> stockDetails) {
		this.stockDetails = stockDetails;
	}
	@Override
	public String toString() {
		return "StockDTO [stockId=" + stockId + ", stockName=" + stockName + "]";
	}
}
