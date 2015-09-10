package com.mcnc.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.dao.impl.StockDAO;
import com.mcnc.dao.impl.StockDetailDAO;
import com.mcnc.dto.StockDTO;
import com.mcnc.dto.StockDetailDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
public class TestStockDAO {
	@Autowired
	StockDAO dao;
	
	@Autowired
	StockDetailDAO detailDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}
	
	@Test //@Transactional is used if detail.getStock() use FetchType.LAZY
	public void test() {
		List<StockDTO> stocks = dao.getStocks();
		for (StockDTO stockDTO : stocks) {
			System.out.println("-----------------------");
			System.out.println(stockDTO);
			Set<StockDetailDTO> stockDetails = stockDTO.getStockDetails();
			System.out.println(stockDetails);
		}
	}
	
	@Test
	public void testDetail() {
		List<StockDetailDTO> details = detailDao.getStockDetails();
		for (StockDetailDTO detail : details) {
			System.out.println("-----------------------");
			System.out.println(detail);
			StockDTO stock = detail.getStock();
			System.out.println(stock);
		}
	}

}
