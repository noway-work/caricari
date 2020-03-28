package com.example.demo.controller

/**
 * Created by version1 on 2017/02/11.
 */

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import com.example.demo.service.TestService


@Controller
class TestController @Autowired constructor(private val testService: TestService) {
    @RequestMapping("/")
    fun root(): ModelAndView{
        return tests()
    }

    @RequestMapping("/tests")
    fun tests(): ModelAndView = ModelAndView("/ino/index").apply { addObject("tests", testService.findAllTest()) }
}