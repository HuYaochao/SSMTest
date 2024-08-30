package org.company.ssm.web.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.company.ssm.entity.Person;
import org.company.ssm.util.PageDate;
import org.company.ssm.util.Result;
import org.company.ssm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person/findByPage")
    public Result<PageDate<Person>> findByPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize){
        Page<Person> page = PageHelper.startPage(pageNum,pageSize);
        personService.findByPage();
        List<Person> rows = page.getResult();
        long total = page.getTotal();

        PageDate<Person> pageDate = new PageDate<>();
        pageDate.setTotal(total);
        pageDate.setRows(rows);
        return Result.ok(pageDate);
    }
//        List<Person> list = personService.findByPage();
//        Long total = personService.getTotal();
//        Map<String,Object> map = new HashMap<>();
//        Map<String,Object> mapPage = new HashMap<>();
//        mapPage.put("rows",list);
//        mapPage.put("total",total);
    @GetMapping("/person/findById")
    public Result<Person> findById(Integer id){
        Person person = personService.findById(id);

        return Result.ok(person);
    }

    @GetMapping("/person/deleteById")
    public Result<Person> deleteById(Integer id){
        Boolean flag = personService.deleteById(id);

        return flag?Result.ok("删除成功"):Result.err("删除失败");
    }

    @PostMapping("/person/updateById")
    public Result<Person> updateById(@RequestBody Person person) throws FileNotFoundException {
        System.out.println(person);
        boolean flag = personService.updateById(person);
        return flag?Result.ok("更新成功"):Result.err("更新失败");
    }

}


//
//    @GetMapping("/person/findById")
//    public Map<String,Object> findById(Integer id){
//        Person person = personService.findById(id);
//        Map<String,Object> map = new HashMap<>();
//        map.put("code",200);
//        map.put("msg","OK");
//        map.put("data",person);
//        return map;
//    }
