package t;

public class T {
	private Ta ta;
	private Tb tb;

	public Ta getTa() {
		return ta;
	}

	public void setTa(Ta ta) {
		this.ta = ta;
	}

	public Tb getTb() {
		return tb;
	}

	public void setTb(Tb tb) {
		this.tb = tb;
	}

	static class Ta {
		int a;
		int b;

		public Ta(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

	}

	static class Tb {
		int c;
		int d;

		public Tb(int c, int d) {
			super();
			this.c = c;
			this.d = d;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		public int getD() {
			return d;
		}

		public void setD(int d) {
			this.d = d;
		}

	}
}
