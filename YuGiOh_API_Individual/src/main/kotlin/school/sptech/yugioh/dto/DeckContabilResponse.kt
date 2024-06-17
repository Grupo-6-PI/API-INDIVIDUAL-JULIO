package school.sptech.yugioh.dto

data class DeckContabilResponse(
    var id: Int? = null,
    var nome: String? = null,
    var qtdCartas: Int? = null,

) {

    fun isEsgotado():Boolean {
        return qtdCartas!! == 0
    }

}
