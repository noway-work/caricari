package com.example.demo.service

/**
 * Created by version1 on 2017/02/11.
 */

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.demo.model.Test
import com.example.demo.repository.TestRepository

/**
 * DBからのデータ取得と加工を行う.
 */
@Service
open class TestService @Autowired constructor(private val testRepository: TestRepository) {

    /**
     * 全ユーザリストの取得
     * @return ユーザリスト
     */
    fun findAllTest(): MutableList<Test> = testRepository.findAll()
}