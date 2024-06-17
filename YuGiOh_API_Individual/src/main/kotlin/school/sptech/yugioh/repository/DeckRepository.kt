package school.sptech.yugioh.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import school.sptech.yugioh.dominio.Deck

interface DeckRepository : JpaRepository<Deck, Int> {
    fun findAllByJogadorId(jogadorId: Int): List<Deck>

    @Query("SELECT d FROM Deck d WHERE d.jogador.id = :id")
    fun buscaPorJogadorId(id: Int) : List<Deck>

    @Query("SELECT d FROM Deck d WHERE d.qtdCartas >= :qtdMin AND d.qtdCartas <= :qtdMax")
    fun buscaEntreDuasQuantidades(qtdMin: Int, qtdMax: Int)

    fun findByJogadorId(id: Int) : List<Deck>

    @Query("SELECT new Deck(d.id, d.nome, d.qtdCartas) FROM Deck d")
    fun findContabil(): List<Deck>
}