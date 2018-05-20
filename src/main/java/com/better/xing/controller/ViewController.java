package com.better.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 14:04
 */
@Controller
@RequestMapping("/myblog")
public class ViewController {
    @RequestMapping("/{view}")
    public String goTo(@PathVariable("view") String view){
        return view;
    }
}
