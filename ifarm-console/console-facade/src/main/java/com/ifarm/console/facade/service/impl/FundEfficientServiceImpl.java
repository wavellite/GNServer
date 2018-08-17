package com.ifarm.console.facade.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigvision.web.util.DateTimeUtil;
import com.ifarm.console.facade.service.IFundEfficientService;
import com.ifarm.console.mapper.ContentMapper;
import com.ifarm.console.mapper.FundEfficientMapper;
import com.ifarm.console.shared.domain.po.FundEfficientCompanyPO;
import com.ifarm.console.shared.domain.po.FundEfficientPO;


@Service
public class FundEfficientServiceImpl  implements IFundEfficientService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(FundEfficientServiceImpl.class);
	@Autowired
	FundEfficientMapper fmaper;
	@Override
	public List<FundEfficientPO> getAll() {
	
		return fmaper.getAll();
	}

	@Override
	public List<FundEfficientPO> getByMonth(String t1, String t2) {
		// TODO Auto-generated method stub
		return fmaper.getByMonth(t1, t2);
	
	}

	@Override
	public void insert(FundEfficientPO po) {
		
		fmaper.insert(po);
	}

	@Override
	public void insertByList(List<List<String>> values) throws ParseException {
		// TODO Auto-generated method stub
		for(List<String> item:values)
		{
			FundEfficientPO po = new FundEfficientPO();
			po.setFundDate(DateTimeUtil.getDateByString((String)item.get(0)));
			po.setFundSource(item.get(1));
			po.setFundSum(new Integer(item.get(2)));
			po.setFundUsage(item.get(3));
			po.setMonthlyFundSum(new Integer(item.get(4)));
			po.setAlreadyLentFundSum( new Integer(item.get(5)));
			po.setLeftFundSum(new Integer(item.get(6)));
			po.setModifyTime(new Date());
			po.setCreateTime(new Date());
			logger.info(item.get(0)+" "+item.get(1)+" "+item.get(2)+" "+item.get(3)+" "+item.get(4)+" "+item.get(5)+" "+po.getModifyTime()+" "+po.getCreateTime());
			fmaper.insert(po);
		}
	}

	@Override
	public void update(FundEfficientPO fund) {
		// TODO Auto-generated method stub
		fmaper.update(fund);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return fmaper.delete(id);
	}

	@Override
	public int insertCompany(FundEfficientCompanyPO po) {
		// TODO Auto-generated method stub
		return fmaper.insertCompany(po);
	}

	@Override
	public List<FundEfficientCompanyPO> listCompany() {
		// TODO Auto-generated method stub
		return fmaper.listCompany();
	}
	
	

}
