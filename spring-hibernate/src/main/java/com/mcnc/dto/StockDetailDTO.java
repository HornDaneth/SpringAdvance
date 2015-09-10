package com.mcnc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_detail")
public class StockDetailDTO {
	
	private String detailId;
	
	private int qty;
	
	
	private StockDTO stock;

	@Id
	@Column(name = "detail_id", unique = true, nullable = false)
	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "stock_id", nullable = false)
	public StockDTO getStock() {
		return stock;
	}
	public void setStock(StockDTO stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "StockDetailDTO [detailId=" + detailId + ", qty=" + qty + "]";
	}
}
