
public class trabalho1x1 {

	int ligada,queimada,x;
	
	void lampadanova() {
		ligada=0;
		queimada=10;
	}
	
	void lampadaqueimada() {
		System.out.println("Lampada Queimada...");
	}
	
	void estado() {
		if(ligada==queimada)
			lampadaqueimada();
		else 
			if(x==0)
				System.out.println("Lampada Apagada...");
			else
				System.out.println("Lampada Acesa...");
	}
	
	void click() {
		if(ligada==queimada)
		lampadaqueimada();
		else 
			if(x==0) {
			x=1;
			System.out.println("Acendeu...");
			ligada++;
		}
		else {
			x=0;
			System.out.println("Apagou...");
		}					
	}

}
