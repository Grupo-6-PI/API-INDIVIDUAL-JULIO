package school.sptech.yugioh.service


import org.springframework.stereotype.Service

import school.sptech.yugioh.repository.CartaRepository
import school.sptech.yugioh.repository.DeckRepository
import school.sptech.yugioh.repository.JogadorRepository

@Service
class JogadorService(
    val jogadorRepository: JogadorRepository,
    val cartaRepository: CartaRepository,
    val deckRepository: DeckRepository
) {
    fun calcularQtdCartasTotais(jogadorId: Int): Int {
        val decks = deckRepository.findAllByJogadorId(jogadorId)
        return decks.sumOf { it.qtdCartas ?: 0 }
    }

    fun calcularQtdVitoriasTotais(jogadorId: Int): Int {
        val decks = deckRepository.findAllByJogadorId(jogadorId)
        return decks.sumOf { it.qtdVitorias ?: 0 }
    }
}