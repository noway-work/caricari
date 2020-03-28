package com.example.demo.model

/**
 * Created by version1 on 2017/02/11.
 */

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "test")
data class Test(@Id @GeneratedValue var id: Int? = 0,
                @Column(nullable = false) var test: String = ""
)