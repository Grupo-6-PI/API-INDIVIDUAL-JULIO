package school.sptech.projetoestoque.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import school.sptech.yugioh.dominio.Deck
import school.sptech.yugioh.dominio.Jogador
import school.sptech.yugioh.repository.CartaRepository
import school.sptech.yugioh.repository.DeckRepository
import school.sptech.yugioh.repository.JogadorRepository
import school.sptech.yugioh.service.JogadorService

@ExtendWith(MockitoExtension::class)
class JogadorServiceTest {

    @Mock
    private lateinit var jogadorRepository: JogadorRepository

    @Mock
    private lateinit var cartaRepository: CartaRepository

    @Mock
    private lateinit var deckRepository: DeckRepository

    @InjectMocks
    private lateinit var jogadorService: JogadorService

    @Test
    fun `Cartas totais do Jogador`() {
        val jogadorId = 1
        val decks = listOf(
            Deck(id = 1, nome = "Deck 1", qtdCartas = 10, jogador = Jogador(id = jogadorId)),
            Deck(id = 2, nome = "Deck 2", qtdCartas = 15, jogador = Jogador(id = jogadorId))
        )

        Mockito.`when`(deckRepository.findAllByJogadorId(jogadorId)).thenReturn(decks)

        val totalCartas = jogadorService.calcularQtdCartasTotais(jogadorId)

        assertEquals(25, totalCartas)
    }

    @Test
    fun `Vitorias Totais por Jogador`() {
        val jogadorId = 1
        val decks = listOf(
            Deck(id = 1, nome = "Deck 1", qtdVitorias = 5, jogador = Jogador(id = jogadorId)),
            Deck(id = 2, nome = "Deck 2", qtdVitorias = 8, jogador = Jogador(id = jogadorId))
        )

        Mockito.`when`(deckRepository.findAllByJogadorId(jogadorId)).thenReturn(decks)

        val totalVitorias = jogadorService.calcularQtdVitoriasTotais(jogadorId)

        assertEquals(13, totalVitorias)
    }

    @Test
    fun `Retorno de 0 Para quando não forem achadas cartas`() {
        val jogadorId = 1

        Mockito.`when`(deckRepository.findAllByJogadorId(jogadorId)).thenReturn(emptyList())

        val totalCartas = jogadorService.calcularQtdCartasTotais(jogadorId)

        assertEquals(0, totalCartas)
    }

    @Test
    fun `Retorno de 0 Para quando não forem achadas decks`() {
        val jogadorId = 1

        Mockito.`when`(deckRepository.findAllByJogadorId(jogadorId)).thenReturn(emptyList())

        val totalVitorias = jogadorService.calcularQtdVitoriasTotais(jogadorId)

        assertEquals(0, totalVitorias)
    }
}
