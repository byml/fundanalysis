package net.byml.fund.md.repository;

import net.byml.fund.md.model.FundType;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FundTypeRepository extends
		PagingAndSortingRepository<FundType, Long> {
	public FundType findByCode(String code);
}
