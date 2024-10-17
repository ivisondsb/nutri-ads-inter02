package br.com.ivisondsb.nutri_inter.models

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "pessoas")
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,
    @Column(name = "nome")
    val nome: String = "",
    @Column(name = "sexo")
    val sexo: Char = ' ',
    @Column(name = "cpf")
    val cpf: String = "",
    @Column(name = "data_nascimento")
    val dataDeNascimento: LocalDate = LocalDate.now(),
    @Column(name = "idade")
    val idade: Int = LocalDate.now().year - dataDeNascimento.year,
    @Column(name = "telefone")
    val telefone: String = "",
    @Column(name = "email")
    val email: String = "",
    @Column(name = "cep")
    val cep: String = "",
    @Column(name = "endereco")
    val endereco: String = "",
    @Column(name = "complemento")
    val complemento: String = "",
    @Column(name = "numero_casa")
    val numeroDaCasa: Int = 0,
    @Column(name = "bairro")
    val bairro: String = "",
    @Column(name = "cidade")
    val cidade: String = "",
    @Column(name = "estado")
    val estado: String = ""
)