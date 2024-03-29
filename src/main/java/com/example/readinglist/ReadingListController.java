package com.example.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    public Not anot;

    private ReadingListRepository readingListRepository;


    @Autowired
    public ReadingListController(ReadingListRepository readingLIstRepository){
        this.readingListRepository = readingLIstRepository;
    }


    @Autowired
    public void setOut(){
        System.out.println("set out\nset out\nset out\nset out\nset out\nset out\n");
        anot.printThis();
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader, Model model
    ){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null){
            model.addAttribute("books", readingList);
        }
     return "readingList";
    }



    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book
    ){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String createUser(){

        return "CreateUser";
    }


}
