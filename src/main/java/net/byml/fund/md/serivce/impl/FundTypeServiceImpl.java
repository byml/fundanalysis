package net.byml.fund.md.serivce.impl;

import net.byml.fund.md.model.FundType;
import net.byml.fund.md.repository.FundTypeRepository;
import net.byml.fund.md.serivce.FundTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("fundTypeService")
public class FundTypeServiceImpl implements FundTypeService {
	@Autowired
	private FundTypeRepository repository;

	public Iterable<FundType> findAll() {
		return repository.findAll();
	}

	public FundType findById(Long id) {
		return repository.findOne(id);
	}

	public FundType findByCode(String code) {
		return repository.findByCode(code);
	}

	public void save(FundType fundType) {
		repository.save(fundType);
	}

}
