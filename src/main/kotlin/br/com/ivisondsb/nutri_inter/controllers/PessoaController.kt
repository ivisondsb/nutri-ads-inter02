package br.com.ivisondsb.nutri_inter.controllers

import br.com.ivisondsb.nutri_inter.dto.CreatePessoaDTO
import br.com.ivisondsb.nutri_inter.dto.PessoaDTO
import br.com.ivisondsb.nutri_inter.services.PessoaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/pessoas")
class PessoaController(private val pessoaService: PessoaService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<PessoaDTO>> {
        val pessoas = pessoaService.findAll()
        val pessoasDTO = pessoas.map { pessoaService.toDTO(it) }
        return ResponseEntity.ok(pessoasDTO)
    }

    @PostMapping
    fun createPessoa(@RequestBody pessoaDTO: CreatePessoaDTO): ResponseEntity<PessoaDTO> {
        val pessoa = pessoaService.fromDTO(pessoaDTO)
        val savedPessoa = pessoaService.save(pessoa)
        return ResponseEntity.ok(pessoaService.toDTO(savedPessoa))
    }

    @GetMapping("/{id}")
    fun getPessoaById(@PathVariable id: Long): ResponseEntity<PessoaDTO> {
        val pessoa = pessoaService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(pessoaService.toDTO(pessoa))
    }

    @PutMapping("/{id}")
    fun updatePessoa(@PathVariable id: Long, @RequestBody pessoaDTO: CreatePessoaDTO): ResponseEntity<PessoaDTO> {
        val pessoaExistente = pessoaService.findById(id) ?: return ResponseEntity.notFound().build()
        val updatedPessoa = pessoaExistente.copy(
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
        pessoaService.save(updatedPessoa)
        return ResponseEntity.ok(pessoaService.toDTO(updatedPessoa))
    }

    @DeleteMapping("/{id}")
    fun deletePessoa(@PathVariable id: Long): ResponseEntity<Void> {
        return if (pessoaService.findById(id) != null) {
            pessoaService.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}