package net.byml.fund.md.serivce;

import java.util.List;

import net.byml.fund.md.model.Fund;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FundService {
	Fund findById(Long id);

	Fund findByCode(String code);

	Iterable<Fund> findByIds(Iterable<Long> ids);

	/**
	 * Remove the associated Fund record from the data repository.
	 * 
	 * @param fund
	 */
	void delete(Fund fund);

	/**
	 * Save the state of the provided Fund object into the data repository.
	 * 
	 * @param fund
	 */
	void save(Fund fund);

	Iterable<Fund> findAll();
	
	Page<Fund> findByQuery(Pageable pageable) ;

	void delete(List<Long> uid);
}
