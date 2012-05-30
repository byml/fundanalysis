package byml.fundanalysis.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import byml.fundanalysis.model.Fund;

@Repository("fundDao")
public class FundDaoJpa implements FundDao {
	private static final Logger logger = Logger.getLogger(FundDaoJpa.class
			.getName());

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Fund findById(Long fundId) throws DataAccessException {

		Fund fund = null;

		TypedQuery<Fund> query = entityManager.createNamedQuery(
				"fund.findById", Fund.class);

		query.setParameter("id", fundId);

		try {

			fund = query.getSingleResult();

		} catch (javax.persistence.NoResultException ex) {

			logger.warn("No Fund was found with a fundId of " + fundId);

		}

		return fund;

	}

	public Fund findByCode(String code) {
		Fund fund = null;

		TypedQuery<Fund> query = entityManager.createNamedQuery(
				"fund.findByCode", Fund.class);

		query.setParameter("code", code);

		try {

			fund = query.getSingleResult();

		} catch (javax.persistence.NoResultException ex) {

			logger.warn("No Fund was found with a code of " + code);

		}

		return fund;
	}

	public List<Fund> findByCodeColl(Collection<String> codeColl) {
		List<Fund> list = new ArrayList<Fund>();

		TypedQuery<Fund> query = entityManager.createNamedQuery(
				"fund.findByCodeList", Fund.class);
		query.setParameter("code", codeColl);
		try {
			list = query.getResultList();
		} catch (javax.persistence.NoResultException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List<Fund> findAllFunds() {

		TypedQuery<Fund> query = entityManager.createQuery(
				"from " + Fund.class.getName(), Fund.class);

		List<Fund> funds = query.getResultList();

		return funds;

	}

	public void update(Fund fund) {
		entityManager.merge(fund);
	}

	public void delete(Fund fund) {

		// use merge to get the Fund object into
		// this persistence context
		Fund deleteFund = entityManager.merge(fund);

		entityManager.remove(deleteFund);

	}

	public void save(Fund fund) {
		entityManager.persist(fund);
	}

}
