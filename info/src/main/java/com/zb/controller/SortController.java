package com.zb.controller;

import com.zb.pojo.Sort;
import com.zb.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sort")
public class SortController {
   @Autowired(required = false)
   private SortService sortService;

   @RequestMapping("/listSort")
    public List<Sort> listSort(){
       return sortService.listSort();
   }
}
