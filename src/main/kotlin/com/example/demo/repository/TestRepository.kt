package com.example.demo.repository

/**
 * Created by version1 on 2017/02/11.
 */


import com.example.demo.model.Test
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<Test, Long> {
}