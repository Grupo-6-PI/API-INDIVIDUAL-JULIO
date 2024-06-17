package school.sptech.yugioh.dominio

import jakarta.persistence.*


@Entity
data class Deck (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var nome: String? = null,
    var qtdCartas: Int? = null,
    @field:ManyToOne
    var jogador: Jogador? = null,
    var qtdVitorias: Int? = null
) {

    constructor(
        paramId: Int,
        paramNome: String
    ):
    this(id = paramId, nome = paramNome)

    constructor(
        paramId: Int,
        paramNome: String,
        paramJogador: Jogador,
        paramQtdVitorias: Int
    ):
    this(id = paramId, nome = paramNome, jogador = paramJogador, qtdVitorias = paramQtdVitorias)

    constructor(
        paramId: Int,
        paramNome: String,
        paramqtdCartas: Int,
    ):
    this(id = paramId, nome = paramNome,
         qtdCartas = paramqtdCartas)

}





