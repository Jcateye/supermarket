package com.example.supermarket.controller;

import com.example.supermarket.mapper.GoodsMapper;
import com.example.supermarket.pojo.Goods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController("/goods")
public class GoodsController {

    @Resource
    private GoodsMapper goodsMapper;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody@Validated Goods goods) {
        goods.setBookId(UUID.randomUUID().toString().replace("-", ""));
        try {
            if (StringUtils.isEmpty(goods.getDetail())){
                goods.setDetail("无");
            }
            goodsMapper.insert(goods);
        } catch (Exception e) {
            return new ResponseEntity("添加失败:  " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("添加成功: "+ goods.getBookName());
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody@Validated List<Goods> goodsList) {
        try {
            for (Goods goods : goodsList) {
                goodsMapper.update(goods);
            }
        } catch (Exception e) {
            return new ResponseEntity("更新失败:  " + e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("更新成功 ");
    }

    @GetMapping("/delete/{bookId}")
    public ResponseEntity<String> delete(@PathVariable String bookId) {
        try {
            goodsMapper.deleteByPrimaryKey(bookId);
        } catch (Exception e) {
            return new ResponseEntity("删除失败:  " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("删除成功");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletes(@RequestBody List<String> bookIds) {
        try {
            for (String bookid : bookIds) {
                goodsMapper.deleteByPrimaryKey(bookid);
            }
        } catch (Exception e) {
            return new ResponseEntity("删除失败:  " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("删除成功");
    }

    @GetMapping("/query/{bookId}")
    public ResponseEntity<Goods> select(@PathVariable String bookId ) {
        Goods goods = null;
        try {
            goods =goodsMapper.selectByPrimaryKey(bookId);
        } catch (Exception e) {
            return new ResponseEntity("查询失败:  " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(goods);
    }

    @GetMapping("/queryall")
    public ResponseEntity<List<Goods>> select() {
        List<Goods> goods = null;
        try {
            goods =goodsMapper.selectALl();
        } catch (Exception e) {
            return new ResponseEntity("查询失败:  " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(goods);
    }
}
