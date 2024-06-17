package school.sptech.yugioh.controller

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import school.sptech.yugioh.dominio.Deck
import school.sptech.yugioh.dto.DeckContabilResponse
import school.sptech.yugioh.repository.DeckRepository
import school.sptech.yugioh.service.DeckService


@RestController
@RequestMapping("/decks")
class DeckController(
    val deckService: DeckService,
    val deckRepository: DeckRepository
) {

    @PostMapping
    fun criar(@RequestBody @Valid novoDeck: Deck) :
            ResponseEntity<Deck> {

        val deckSalvo = deckRepository.save(novoDeck)
        return ResponseEntity.status(201).body(deckSalvo)
    }

    @GetMapping("lista-decks")
    fun listar(): ResponseEntity<List<Deck>> {
        val decks = deckRepository.findAll()

        if(decks.isEmpty()) {
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(decks)
    }

    @GetMapping("/filtro-jogador/{jogadorId}")
    fun buscarPorIdJogador(@PathVariable jogadorId: Int):
            ResponseEntity<List<Deck>> {

        val decks = deckService.getListaPorJogador(jogadorId)
        return ResponseEntity.status(200).body(decks)
    }

    @GetMapping("/deck-geral")
    fun listarContabil() : ResponseEntity<List<DeckContabilResponse>> {
        val dtos = deckService.getListaContabil()
        return ResponseEntity.status(200).body(dtos)
    }
}