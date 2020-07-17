package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.domain.User;
import com.example.demo.exception.BusinessExcepption;
import com.example.demo.repository.BookRepository;
import com.example.demo.vo.BaseReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/a/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = bookRepository.findByReader(reader);
        if (!CollectionUtils.isEmpty(readingList)) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }


    @RequestMapping(value = "/a/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book){

        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/a/{reader}";
    }

    @GetMapping("/user/{name}")
    @ResponseBody
    public BaseReponse getAll(@PathVariable("name") String name){
        User user = new User();
//        user.setId(1L);
////        user.setName("许林创");
////        user.setAge(211);
////        user.setSex(1);
        if (!"xlc".equals(name)) {
            throw new BusinessExcepption("100001","测试异常");
        }
        return BaseReponse.ok();
    }

    private void testException(){
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
