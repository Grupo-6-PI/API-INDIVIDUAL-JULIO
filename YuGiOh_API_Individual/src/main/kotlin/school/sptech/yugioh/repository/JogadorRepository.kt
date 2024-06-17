package school.sptech.yugioh.repository

import org.springframework.data.jpa.repository.JpaRepository

import school.sptech.yugioh.dominio.Jogador

interface JogadorRepository: JpaRepository<Jogador, Int> {
}