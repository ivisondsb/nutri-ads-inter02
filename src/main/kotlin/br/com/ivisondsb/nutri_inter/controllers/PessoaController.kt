package br.com.ivisondsb.nutri_inter.controllers

import br.com.ivisondsb.nutri_inter.models.Pessoa
import br.com.ivisondsb.nutri_inter.services.PessoaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoas")
class PessoaController(private val pessoaService: PessoaService) {

    @GetMapping
    fun getAll(): List<Pessoa> = pessoaService.findAll()

    @GetMapping("/{id}")
    fun getPessoaById(@PathVariable id: Long): ResponseEntity<Pessoa> {
        val pessoa = pessoaService.findById(id)
        return if (pessoa != null) ResponseEntity.ok(pessoa) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createPessoa(@RequestBody pessoa: Pessoa): Pessoa = pessoaService.save(pessoa)

    @PutMapping("/{id}")
    fun updatePessoa(@PathVariable id: Long, @RequestBody pessoa: Pessoa): ResponseEntity<Pessoa> {
        val pessoaExistente = pessoaService.findById(id)
        return if (pessoaExistente != null) {
            val pessoaAtualizada = pessoaService.save(pessoa.copy(id = id))
            ResponseEntity.ok(pessoaAtualizada)
        } else {
            ResponseEntity.notFound().build()
        }
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