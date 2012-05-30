package byml.fundanalysis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import byml.fundanalysis.model.FundType;

@Repository("fundTypeDao")
public class FundTypeDaoJpa implements FundTypeDao {
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<FundType> findAllFundTypes() {

		TypedQuery<FundType> query = entityManager.createQuery("from "
				+ FundType.class.getName(), FundType.class);

		List<FundType> fundTypes = query.getResultList();

		return fundTypes;

	}

	public void save(FundType fundType) {
		entityManager.persist(fundType);
	}
}
