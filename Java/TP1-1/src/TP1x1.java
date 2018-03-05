public class TP1x1 {
	public static void main(String[] args) {
		int y;
		trabalho1x1 t = new trabalho1x1();
		t.lampadanova();
		for (y = 0; y <= 7; y++) {
			t.click();
			t.estado();
			t.click();
			t.estado();
			t.click();
			t.click();
		}
	}
}
