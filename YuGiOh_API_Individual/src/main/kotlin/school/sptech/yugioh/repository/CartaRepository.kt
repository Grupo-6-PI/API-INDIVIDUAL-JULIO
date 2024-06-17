package school.sptech.yugioh.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import school.sptech.yugioh.dominio.Carta

interface CartaRepository : JpaRepository<Carta, Int> {

    @Query("SELECT new Carta(c.id, c.nome) FROM Carta c")
    fun findSimples(): List<Carta>


}