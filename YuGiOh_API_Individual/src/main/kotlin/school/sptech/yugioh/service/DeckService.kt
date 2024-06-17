package school.sptech.yugioh.service

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

import school.sptech.yugioh.dominio.Deck
import school.sptech.yugioh.dto.DeckContabilResponse
import school.sptech.yugioh.repository.DeckRepository

@Service
class DeckService(

    val deckRepository: DeckRepository

) {

    fun validarListaDeck(lista: List<Deck>) {
        if (lista.isEmpty()) {
            throw ResponseStatusException(HttpStatusCode.valueOf(204))
        }
    }

    fun getListaPorJogador(id: Int): List<Deck> {
        val lista = deckRepository.buscaPorJogadorId(id)
        validarListaDeck(lista)

        return lista
    }

    fun getListaContabil(): List<DeckContabilResponse> {
        val decks = deckRepository.findContabil()
        if (decks.isEmpty()) {
            throw ResponseStatusException(HttpStatus.NO_CONTENT)
        }
        return decks.map { deck ->
            DeckContabilResponse(
                id = deck.id,
                nome = deck.nome,
                qtdCartas = deck.qtdCartas
            )
        }
    }
}
