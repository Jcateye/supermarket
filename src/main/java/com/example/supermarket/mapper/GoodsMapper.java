package com.example.supermarket.mapper;

import com.example.supermarket.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("SELECT * FROM Goods WHERE bookId=#{bookId}")
    Goods selectByPrimaryKey(String bookId);

    @Insert("INSERT INTO Goods VALUES(#{bookId}, #{bookName}, #{pirce} ,#{count}, #{detail})")
    int  insert(Goods goods);

    @Update("UPDATE Goods SET " +
            "bookName=#{bookName}, pirce=#{pirce},count=#{count}, detail=#{detail}" +
            "WHERE  bookId = #{bookId}")
    int update(Goods goods);

    @Delete("DELETE FROM GOODS WHERE BOOKID=#{id}")
    int deleteByPrimaryKey(String id);

    @Select("Select * From Goods order by number")
    List<Goods> selectALl();
}
