package byml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.Predicate;

public class EntityConvertHelper {
	private static EntityConvertHelper instance;

	private EntityConvertHelper() {

	}

	public static EntityConvertHelper getInstance() {
		if (instance == null) {
			instance = new EntityConvertHelper();
		}
		return instance;
	}

	public List toEntityList(Class cls, List mapList) {
		List entityList = new ArrayList();
		for (Iterator it = mapList.iterator(); it.hasNext();) {
			Map map = (Map) it.next();
			Object entity = toEntity(cls, map);
			if (entity != null) {
				entityList.add(entity);
			}
		}
		return entityList;
	}

	public Object toEntity(Class cls, Map map) {
		Object entity = null;
		try {
			entity = cls.newInstance();
			BeanUtils.populate(entity, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
}
