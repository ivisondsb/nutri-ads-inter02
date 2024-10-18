package br.com.ivisondsb.nutri_inter.services

import br.com.ivisondsb.nutri_inter.dto.CreateNutriDTO
import br.com.ivisondsb.nutri_inter.dto.NutriDTO
import br.com.ivisondsb.nutri_inter.models.Nutri
import br.com.ivisondsb.nutri_inter.repositories.NutriRepository
import br.com.ivisondsb.nutri_inter.repositories.PessoaRepository
import org.springframework.stereotype.Service

@Service
class NutriService(
    private val nutriRepository: NutriRepository,
    private val pessoaRepository: PessoaRepository
) {

    fun toDTO(nutri: Nutri): NutriDTO {
        return NutriDTO(
            id = nutri.id,
            idPessoa = nutri.idPessoa.id,
            crn = nutri.crn
        )
    }

    fun fromDTO(nutriDTO: CreateNutriDTO): Nutri {

        val pessoa = pessoaRepository.findById(nutriDTO.idPessoa)
            .orElseThrow { (throw IllegalArgumentException("Pessoa não encontrada")) }

        return Nutri(
            idPessoa = pessoa,
            crn = nutriDTO.crn
        )
    }

    fun save(nutri: Nutri): Nutri = nutriRepository.save(nutri)
    fun findAll(): List<Nutri> = nutriRepository.findAll()
    fun findById(id: Long): Nutri = nutriRepository.findById(id).orElse(null)
    fun deleteById(id: Long) = nutriRepository.deleteById(id)
}