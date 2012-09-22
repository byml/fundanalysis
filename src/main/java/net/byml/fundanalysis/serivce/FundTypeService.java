package net.byml.fundanalysis.serivce;

import net.byml.fundanalysis.model.FundType;

public interface FundTypeService {
	public FundType findById(Long id);

	public FundType findByCode(String code);

	public Iterable<FundType> findAll();

	public void save(FundType fundType);
}
