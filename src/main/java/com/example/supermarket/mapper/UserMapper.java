package com.example.supermarket.mapper;

import com.example.supermarket.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User selectByPrimaryKey(String id);

    @Insert("INSERT INTO USER VALUES(#{id}, #{username}, #{password})")
    int  insert(User User);

    @Update("UPDATE USER SET USERNAME=#{username}, PASSWORD=#{password} WHERE  ID=#{id}")
    int update(User User);

    @Delete("DELETE FROM USER WHERE ID=#{id}" )
    int deleteByPrimaryKey(String id);
}
