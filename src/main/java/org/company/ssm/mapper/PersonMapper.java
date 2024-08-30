package org.company.ssm.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.company.ssm.entity.Person;

import java.util.List;

@Mapper
public interface PersonMapper {
     boolean updateById(Person person);

    List<Person> findByPage();

//(@Param("pageNum") Integer pageNum,
//                            @Param("pageSize")  Integer pageSize
//    Long getTotal();

    Person findById(Integer id);

    Boolean deleteById(Integer id);
}
