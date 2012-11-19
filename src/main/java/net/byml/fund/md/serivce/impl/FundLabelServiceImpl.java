package net.byml.fund.md.serivce.impl;

import net.byml.fund.md.model.FundLabel;
import net.byml.fund.md.repository.FundLabelRepository;
import net.byml.fund.md.serivce.FundLabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundLabelServiceImpl  implements FundLabelService {
	@Autowired
	private FundLabelRepository repository;

	public Iterable<FundLabel> findAll() {
		return repository.findAll();
	}

	public FundLabel findById(Long id) {
		return repository.findOne(id);
	}

	public FundLabel findByCode(String code) {
		return repository.findByCode(code);
	}

	public void save(FundLabel fundLabel) {
		repository.save(fundLabel);
	}

}
