package br.com.ivisondsb.nutri_inter.services

import br.com.ivisondsb.nutri_inter.dto.CreatePessoaDTO
import br.com.ivisondsb.nutri_inter.dto.PessoaDTO
import br.com.ivisondsb.nutri_inter.models.Pessoa
import br.com.ivisondsb.nutri_inter.repositories.PessoaRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PessoaService(private val pessoaRepository: PessoaRepository) {

    fun toDTO(pessoa: Pessoa): PessoaDTO {
        return PessoaDTO(
            id = pessoa.id,
            nome = pessoa.nome,
            sexo = pessoa.sexo,
            cpf = pessoa.cpf,
            email = pessoa.email,
            telefone = pessoa.telefone,
            dataDeNascimento = pessoa.dataDeNascimento.toString(),
            idade = LocalDate.now().year - pessoa.dataDeNascimento.year,
            cep = pessoa.cep,
            endereco = pessoa.endereco,
            numeroDaCasa = pessoa.numeroDaCasa,
            complemento = pessoa.complemento,
            bairro = pessoa.bairro,
            cidade = pessoa.cidade,
            estado = pessoa.estado
        )
    }

    fun fromDTO(pessoaDTO: CreatePessoaDTO): Pessoa {
        return Pessoa(
            nome = pessoaDTO.nome,
            sexo = pessoaDTO.sexo,
            cpf = pessoaDTO.cpf,
            email = pessoaDTO.email,
            telefone = pessoaDTO.telefone,
            dataDeNascimento = LocalDate.parse(pessoaDTO.dataDeNascimento),
            idade = pessoaDTO.idade,
            cep = pessoaDTO.cep,
            endereco = pessoaDTO.endereco,
            numeroDaCasa = pessoaDTO.numeroDaCasa,
            complemento = pessoaDTO.complemento,
            bairro = pessoaDTO.bairro,
            cidade = pessoaDTO.cidade,
            estado = pessoaDTO.estado
        )
    }

    fun save(pessoa: Pessoa): Pessoa = pessoaRepository.save(pessoa)
    fun findAll(): List<Pessoa> = pessoaRepository.findAll()
    fun findById(id: Long): Pessoa? = pessoaRepository.findById(id).orElse(null)
    fun deleteById(id: Long) = pessoaRepository.deleteById(id)
}