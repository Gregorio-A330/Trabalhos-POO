
public class ICMS extends Imposto {

	@Override
	public double calcular(double valorProduto) {		
		return valorProduto * 0.90;
	}

}
