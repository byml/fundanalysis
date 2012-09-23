package net.byml.fund.md.repository;

import net.byml.fund.md.model.Fund;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FundRepository extends PagingAndSortingRepository<Fund, Long> {
	public Fund findByCode(String code);
}
