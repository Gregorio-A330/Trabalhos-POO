import java.util.Scanner;

object AdivinheMeuNumero {
	@JvmStatic fun main(args: Array<String>) {
		val adivinha = AdvinhatorClass()
		val continua = false
		while (!continua) {
			println("Entre com o seu numero: ")
			val leitor = Scanner(System.`in`)
			adivinha.advinhation(leitor.nextInt())
		}
	}
}

