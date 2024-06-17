package school.sptech.yugioh.controller

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import school.sptech.yugioh.dominio.Carta
import school.sptech.yugioh.dto.CartaSimplesResponse
import school.sptech.yugioh.service.CartaService


@RestController
@RequestMapping("/cartas")
class CartaController(
    val cartaService: CartaService
) {

    @GetMapping("/simples/{id}")
    fun getSimples(@PathVariable id:Int) : ResponseEntity<CartaSimplesResponse> {
        val dto = cartaService.getSimples(id)
        return ResponseEntity.status(200).body(dto)
    }

    @GetMapping("/simples")
    fun listarSimples() : ResponseEntity<List<CartaSimplesResponse>> {
        val dtos = cartaService.getListaSimples()
        return ResponseEntity.status(200).body(dtos)
    }


    @PostMapping
    fun criar(@RequestBody @Valid novaCarta: Carta) : ResponseEntity<Carta> {
        cartaService.salvar(novaCarta)
        return ResponseEntity.status(201).body(novaCarta)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id:Int, @RequestBody @Valid carta: Carta) : ResponseEntity<Carta> {
        carta.id = id
        cartaService.salvar(carta)
        return ResponseEntity.status(200).body(carta)
    }

    @GetMapping
    fun listar() : ResponseEntity<List<Carta>> {
        val cartas = cartaService.getLista()
        return ResponseEntity.status(200).body(cartas)
    }

}