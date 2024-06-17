package school.sptech.yugioh.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import school.sptech.yugioh.service.JogadorService

@RestController
@RequestMapping("/estatisticas")
class JogadorController(
    val jogadorService: JogadorService
) {

    @GetMapping("/total-cartas/{jogadorId}")
    fun getTotalCartas(@PathVariable jogadorId: Int): ResponseEntity<Int> {
        val totalCartas = jogadorService.calcularQtdCartasTotais(jogadorId)
        return ResponseEntity.ok(totalCartas)
    }

    @GetMapping("/total-vitorias/{jogadorId}")
    fun getTotalVitorias(@PathVariable jogadorId: Int): ResponseEntity<Int> {
        val totalVitorias = jogadorService.calcularQtdVitoriasTotais(jogadorId)
        return ResponseEntity.ok(totalVitorias)
    }
}