package org.company.ssm.service;

import org.company.ssm.entity.Person;

import java.io.FileNotFoundException;
import java.util.List;

public interface PersonService {

    List<Person> findByPage();
//Integer pageNum, Integer pageSize
//    Long getTotal();

    Person findById(Integer id);

    Boolean deleteById(Integer id);

    boolean updateById(Person person) throws FileNotFoundException;
}
