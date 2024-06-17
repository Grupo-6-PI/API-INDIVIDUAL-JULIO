package school.sptech.yugioh.dto


import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import school.sptech.yugioh.dominio.Jogador

data class DeckCadastroRequest(
    @field:Size(min = 3)
    var nome: String,

    @field:PositiveOrZero
    var qtdCartas: Int? = null,

    var jogador: Jogador? = null
)