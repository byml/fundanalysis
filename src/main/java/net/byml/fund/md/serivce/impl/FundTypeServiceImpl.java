package net.byml.fund.md.serivce.impl;

import java.util.Iterator;
import java.util.List;

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

	public void delete(FundType fundType) {
		repository.delete(fundType);
	}

	public void delete(List<Long> ids) {
		//repository.delete(repository.findAll(ids));
		for (Iterator<Long> it = ids.iterator(); it.hasNext();) {
			Long id = it.next();
			repository.delete(id);
		}
	}
}
