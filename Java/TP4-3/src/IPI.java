
public class IPI extends Imposto {

	@Override
	public double calcular(double valorProduto) {
	   double valorFinal = valorProduto - (valorProduto * 5 / 100 );
		  return valorFinal;
	}
}

