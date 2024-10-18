package br.com.ivisondsb.nutri_inter.models

import jakarta.persistence.*

@Entity
@Table(name = "nutricionistas")
data class Nutri(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,
    @OneToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    val idPessoa: Pessoa,
    @Column(name = "crn")
    val crn: String = ""
)