package org.company.ssm.service.impl;

import org.company.ssm.entity.Person;
import org.company.ssm.mapper.PersonMapper;
import org.company.ssm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> findByPage() {
//       Integer pageNum, Integer pageSize
//        if (pageNum == null || pageSize == null){
//            return  null;
//        }
//        pageNum = (pageNum-1)*pageSize;
//        pageNum,pageSize

        return personMapper.findByPage();
    }

//    @Override
//    public Long getTotal() {
//        return personMapping.getTotal();
//    }

    @Override
    public Person findById(Integer id) {
        return personMapper.findById(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NEVER)
    public Boolean deleteById(Integer id) {
        return personMapper.deleteById(id);
    }

    @Override
    public boolean updateById(Person person) throws FileNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("xx");
        return personMapper.updateById(person);
    }


}
