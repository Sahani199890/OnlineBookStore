package com.onlinebookstore.book.feignclinet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinebookstore.book.bookpojo.ReviewPojo;



@FeignClient("REVIEW")
public interface ReviewInterface {

	@GetMapping("/review_by_book_id/{bookId}")  
    public ReviewPojo reviewByBookId(@PathVariable("bookId") Long id);  

}
