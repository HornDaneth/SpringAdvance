package com.mcnc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcnc.dto.StockDTO;

@Repository
@Transactional
public class StockDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<StockDTO> getStocks(){
		@SuppressWarnings("unchecked")
		List<StockDTO> list = sessionFactory.getCurrentSession().createCriteria(StockDTO.class).list();
		return list;
	}
}
