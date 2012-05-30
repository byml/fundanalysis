package byml.fundanalysis.serivce;

import java.util.Collection;
import java.util.List;

import byml.fundanalysis.model.Fund;

public interface FundService {
	public Fund findById(Long id);
	
	public Fund findByCode(String code);
	
	public List<Fund> findByIds(Collection idColl);
	
	
	/**
	 * Update the data repository with the 
	 * state of the provided Fund object.
	 * @param fund Fund object
	 */
	public void update(Fund fund);
	
	
	/**
	 * Remove the associated Fund
	 * record from the data repository.
	 * @param fund
	 */
	public void delete(Fund fund);
	
	
	/**
	 * Save the state of the provided
	 * Fund object into the data
	 * repository.
	 * @param fund
	 */
	public void save(Fund fund); 
	
	public List<Fund> findAllFunds() ;
}
