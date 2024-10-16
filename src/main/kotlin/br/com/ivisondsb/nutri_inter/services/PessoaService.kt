package br.com.ivisondsb.nutri_inter.services

import br.com.ivisondsb.nutri_inter.models.Pessoa
import br.com.ivisondsb.nutri_inter.repositories.PessoaRepository
import org.springframework.stereotype.Service

@Service
class PessoaService(private val pessoaRepository: PessoaRepository) {

    fun save(pessoa: Pessoa): Pessoa = pessoaRepository.save(pessoa)
    fun findAll(): List<Pessoa> = pessoaRepository.findAll()
    fun findById(id: Long): Pessoa? = pessoaRepository.findById(id).orElse(null)
    fun deleteById(id: Long) = pessoaRepository.deleteById(id)
}