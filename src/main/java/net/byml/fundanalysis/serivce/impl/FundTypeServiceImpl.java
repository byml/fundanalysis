package net.byml.fundanalysis.serivce.impl;

import net.byml.fundanalysis.model.FundType;
import net.byml.fundanalysis.repository.FundTypeRepository;
import net.byml.fundanalysis.serivce.FundTypeService;

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
