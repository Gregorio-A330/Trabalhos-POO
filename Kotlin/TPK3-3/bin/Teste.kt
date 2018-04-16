object Teste {
  @JvmStatic fun main(args:Array<String>) {
    var constelacao = Constelacao("Sargitario")
    var estrela1 = Estrela("Beta Aquarri", 3000.0, "Azul")
    var estrela2 = Estrela("Gamma Aquarri", 2000.0, "Vermelha")
    var estrela3 = Estrela("Zeta Aquarri", 4000.0, "Amarela")
    estrela1.mostrar()
    estrela2.mostrar()
    estrela3.mostrar()
    System.out.println(constelacao.tempConstelacao())
    constelacao.adicionar(estrela1)
    System.out.println(constelacao.tempConstelacao())
    constelacao.adicionar(estrela2)
    constelacao.adicionar(estrela3)
    // Cálculo da soma da temperatura de uma constelação
    // é feito pela soma das temperaturas de todas as estrelas
    // desta constelação, que neste caso é 3000 + 2000+ 4000 = 9000 graus.
    System.out.println(constelacao.tempConstelacao())
    println()
    constelacao.infoEstrelas()
  }
}