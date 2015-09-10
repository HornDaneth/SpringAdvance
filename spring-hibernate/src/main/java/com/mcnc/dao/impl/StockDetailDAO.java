package com.mcnc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcnc.dto.StockDetailDTO;

@Repository
@Transactional
public class StockDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<StockDetailDTO> getStockDetails(){
		@SuppressWarnings("unchecked")
		List<StockDetailDTO> list = sessionFactory.getCurrentSession().createCriteria(StockDetailDTO.class).list();
		return list;
	}
}
