package net.byml.fund.md.serivce;

import net.byml.fund.md.model.FundType;

public interface FundTypeService {
	public FundType findById(Long id);

	public FundType findByCode(String code);

	public Iterable<FundType> findAll();

	public void save(FundType fundType);
}
