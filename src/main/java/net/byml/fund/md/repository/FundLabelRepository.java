package net.byml.fund.md.repository;

import net.byml.fund.md.model.FundLabel;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FundLabelRepository extends
		PagingAndSortingRepository<FundLabel, Long> {
	public FundLabel findByCode(String code);
}
