package br.com.ivisondsb.nutri_inter.repositories

import br.com.ivisondsb.nutri_inter.models.Nutri
import org.springframework.data.jpa.repository.JpaRepository

interface NutriRepository : JpaRepository<Nutri, Long>