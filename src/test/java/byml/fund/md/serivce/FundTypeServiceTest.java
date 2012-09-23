package byml.fund.md.serivce;

import net.byml.fund.md.serivce.FundTypeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class FundTypeServiceTest {
	@Autowired
	FundTypeService service;

	@Test
	public void testFindAllFundTypes() {
		service.findAll();
	}

}
