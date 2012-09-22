package net.byml.fundanalysis.repository;

import net.byml.fundanalysis.model.FundType;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface FundTypeRepository extends
		PagingAndSortingRepository<FundType, Long> {
	public FundType findByCode(String code);
}
