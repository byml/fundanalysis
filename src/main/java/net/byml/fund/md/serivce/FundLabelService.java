package net.byml.fund.md.serivce;

import net.byml.fund.md.model.FundLabel;

public interface FundLabelService {
	public FundLabel findById(Long id);

	public FundLabel findByCode(String code);

	public Iterable<FundLabel> findAll();

	public void save(FundLabel fundLabel);
}
