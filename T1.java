import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

import net.ejing.inventory.service.dao.InventorySqlUtil;

public class T1 extends JDBCTest {
	public void test() throws Exception {
		Set joIdSet = new HashSet();
		joIdSet.add(new Long(-7));
		joIdSet.add(new Long(-2));
		Connection conn = getConnection();
		InventorySqlUtil.updateLock(conn, "wip_item_lock_job_order", "job_order_id", joIdSet, 100, true);
		InventorySqlUtil.updateLock(conn, "wip_item_lock_job_order", "job_order_id", joIdSet, 100, true);
		conn.rollback();
	}
}
