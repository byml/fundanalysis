package byml.fundanalysis.serivce;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import byml.fundanalysis.dao.FundDao;
import byml.fundanalysis.model.Fund;

@Service("fundService")
public class FundServiceImpl implements FundService {

	@Autowired
	private FundDao fundDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.ku.it.si.springjpaoracleexample.service.FundService#findbyfundId(
	 * java.lang.String)
	 */

	public Fund findById(Long fundId) {

		return fundDao.findById(fundId);

	}

	public FundDao getFundDao() {
		return fundDao;
	}

	public void setFundDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}

	public List<Fund> findAllFunds() {

		return fundDao.findAllFunds();

	}

	@Transactional
	public void update(Fund fund) {

		fundDao.update(fund);

	}

	@Transactional
	public void delete(Fund fund) {

		fundDao.delete(fund);

	}

	@Transactional
	public void save(Fund fund) {

		fundDao.save(fund); // Fund object's fundId instance field will now have
							// a value

	}

	public Fund findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fund> findByIds(Collection idColl) {
		// TODO Auto-generated method stub
		return null;
	}

}
