package byml.fundanalysis.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byml.fundanalysis.dao.FundTypeDao;
import byml.fundanalysis.model.FundType;

@Service("fundTypeService")
public class FundTypeServiceImpl implements FundTypeService {
	@Autowired
	private FundTypeDao fundTypeDao;

	public FundTypeDao getFundTypeDao() {
		return fundTypeDao;
	}

	public void setFundTypeDao(FundTypeDao fundTypeDao) {
		this.fundTypeDao = fundTypeDao;
	}

	public List<FundType> findAllFundTypes() {
		return fundTypeDao.findAllFundTypes();
	}

}
