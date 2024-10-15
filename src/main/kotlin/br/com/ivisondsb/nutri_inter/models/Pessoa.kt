package br.com.ivisondsb.nutri_inter.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nome: String,
    val sexo: Char,
    val cpf: String,
    val dataDeNascimento: LocalDate,
    val idade: Int = LocalDate.now().year - dataDeNascimento.year,
    val telefone: String,
    val email: String,
    val cep: String,
    val endereco: String,
    val complemento: String,
    val numeroDaCasa: Int,
    val bairro: String,
    val cidade: String
)