package school.sptech.yugioh.service

import org.modelmapper.ModelMapper

import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

import school.sptech.yugioh.dominio.Carta
import school.sptech.yugioh.dto.CartaSimplesResponse
import school.sptech.yugioh.repository.CartaRepository
import school.sptech.yugioh.repository.DeckRepository


@Service
class CartaService(
    val cartaRepository: CartaRepository,
    val deckRepository: DeckRepository,
    val mapper: ModelMapper = ModelMapper()
) {

    fun validarListaCarta(lista: List<Carta>) {
        if (lista.isEmpty()) {
            throw ResponseStatusException(HttpStatusCode.valueOf(204))
        }
    }

    fun validarIdCarta(id:Int) {
        if (!cartaRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatusCode.valueOf(404))
        }
    }

    fun getListaSimples():List<CartaSimplesResponse> {
        val lista = cartaRepository.findSimples()
        validarListaCarta(lista)

        val dtos = lista.map {
            mapper.map(it, CartaSimplesResponse::class.java)
        }
        return dtos
    }


    fun salvar(carta: Carta) {
        if (!deckRepository.existsById(carta!!.id)) {
            throw ResponseStatusException(
                HttpStatusCode.valueOf(404))
        }

        cartaRepository.save(carta)
    }

    fun getSimples(id:Int): CartaSimplesResponse {
        validarIdCarta(id)

        val carta = cartaRepository.findById(id).get()

        val dto = mapper.map(
            carta,
            CartaSimplesResponse::class.java
        )
        return dto
    }

    fun getLista():List<Carta> {
        val lista = cartaRepository.findAll()
        validarListaCarta(lista)

        return lista
    }

}