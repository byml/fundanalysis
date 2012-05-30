package t;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import t.T.Ta;
import t.T.Tb;

public class C implements I {

	public List<T> getTList() {
		List<T> list = new ArrayList<T>();
		T t1 = new T();
		t1.setTa(new Ta(1, 2));
		t1.setTb(new Tb(3, 4));
		list.add(t1);
		T t2 = new T();
		t2.setTa(new Ta(5, 6));
		t2.setTb(new Tb(7, 8));
		list.add(t2);
		return list;
	}

	@Test
	public void test() {
		I i = new C();

		List<T> list = i.getTList();
		for (Iterator it = list.iterator(); it.hasNext();) {
			T t = (T) it.next();
			System.out.println("a=" + t.getTa().getA() + " b="
					+ t.getTa().getB() + " c=" + t.getTb().getC() + " d="
					+ t.getTb().getD());
		}

	}
}
