package web.demospringboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import web.demospringboot.api.output.BookOutput;
import web.demospringboot.dto.BookDTO;
import web.demospringboot.service.IBookService;

@RestController
public class BookAPI {

    @Autowired
    private IBookService bookService;

    @CrossOrigin
    @GetMapping(value = "/book")
    public BookOutput showBook(@RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "limit", required = false) Integer limit){
        BookOutput result = new BookOutput();
        if(page != null && limit != null){
            result.setPage(page);
            Pageable pageable = PageRequest.of(page-1, limit);
            result.setListResult(bookService.findAll(pageable));
            result.setTotalPage((int)Math.ceil((double) bookService.totalItem()/limit));
        }else{
            result.setListResult(bookService.findAll());
        }
        return result;
    }

    @GetMapping(value = "/book/{id}")
    public BookDTO showBookById(@PathVariable(value = "id") Long id){
        BookDTO result = new BookDTO();
        result = bookService.findOneById(id);
        return result;
    }

    @PostMapping(value = "/book")
    public BookDTO createBook(@RequestBody BookDTO model){
        return bookService.save(model);
    }

    @PutMapping(value = "/book/{id}")
    public BookDTO updateBook(@RequestBody BookDTO model, @PathVariable("id") Long id ){
        model.setId(id);
        return bookService.save(model);
    }

    @DeleteMapping(value = "/book")
    public void deleteBook(@RequestBody Long[] ids){
        bookService.delete(ids);
    }

}
