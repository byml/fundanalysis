package byml.fundanalysis.dao;

import java.util.List;

import byml.fundanalysis.model.FundType;

public interface FundTypeDao {
	
	public List<FundType> findAllFundTypes();
	
	public void save(FundType fundType); 
}
