package br.com.ivisondsb.nutri_inter.dto

data class PessoaDTO(
    val id: Long?,
    val nome: String,
    val sexo: Char,
    val cpf: String,
    val dataDeNascimento: String,
    val idade: Int,
    val telefone: String,
    val email: String,
    val cep: String,
    val endereco: String,
    val complemento: String,
    val numeroDaCasa: Int,
    val bairro: String,
    val cidade: String,
    val estado: String
)