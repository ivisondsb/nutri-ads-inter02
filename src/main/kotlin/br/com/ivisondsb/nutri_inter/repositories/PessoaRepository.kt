package br.com.ivisondsb.nutri_inter.repositories

import br.com.ivisondsb.nutri_inter.models.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepository : JpaRepository<Pessoa, Long>
