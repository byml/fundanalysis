package net.byml.fundanalysis.serivce.impl;

import net.byml.fundanalysis.model.Fund;
import net.byml.fundanalysis.repository.FundRepository;
import net.byml.fundanalysis.serivce.FundService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("fundService")
public class FundServiceImpl implements FundService {

	@Autowired
	private FundRepository repository;

	public Fund findById(Long id) {
		return repository.findOne(id);
	}

	public Fund findByCode(String code) {
		return repository.findByCode(code);
	}

	public Iterable<Fund> findByIds(Iterable<Long> ids) {
		return repository.findAll(ids);
	}

	public void delete(Fund fund) {
		repository.delete(fund);
	}

	public void save(Fund fund) {
		repository.save(fund);
	}

	public Iterable<Fund> findAll() {
		return repository.findAll();
	}
}
