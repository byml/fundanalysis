package net.byml.fundanalysis.repository;

import net.byml.fundanalysis.model.Fund;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface FundRepository extends PagingAndSortingRepository<Fund, Long> {
	public Fund findByCode(String code);
}
