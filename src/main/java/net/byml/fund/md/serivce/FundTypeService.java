package net.byml.fund.md.serivce;

import java.util.List;

import net.byml.fund.md.model.FundType;

public interface FundTypeService {
	public FundType findById(Long id);

	public FundType findByCode(String code);

	public Iterable<FundType> findAll();

	public void save(FundType fundType);

	public void delete(FundType fundType);

	public void delete(List<Long> id);
}
