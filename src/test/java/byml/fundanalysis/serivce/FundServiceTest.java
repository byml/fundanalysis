package byml.fundanalysis.serivce;

import java.util.ArrayList;
import java.util.List;

import net.byml.fundanalysis.model.Fund;
import net.byml.fundanalysis.serivce.FundService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class FundServiceTest {
	@Autowired
	FundService service;

	@Test
	public void testFindById() {
		service.findById(3L);
	}

	@Test
	public void testFindByCode() {
		service.findByCode("150028");
	}

	@Test
	public void testFindByIds() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
		service.findByIds(ids);
	}

	@Test
	public void testDelete() {
		Fund fund = service.findByCode("cc3");
		service.delete(fund);
	}

	@Test
	public void testSave() {
		Fund fund = service.findByCode("cc3");
		service.save(fund);
	}

	@Test
	public void testFindAllFunds() {
		System.out.println(service.findAll());
	}

}
