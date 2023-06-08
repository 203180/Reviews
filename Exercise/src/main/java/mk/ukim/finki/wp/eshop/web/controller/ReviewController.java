package mk.ukim.finki.wp.eshop.web.controller;


import mk.ukim.finki.wp.eshop.model.Review;
import mk.ukim.finki.wp.eshop.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping
    public String getReviewPage(@RequestParam(required = false)String orderRating,
                                @RequestParam(required = false)String minRating,
                                @RequestParam(required = false)String orderDate,
                                @RequestParam(required = false)String prioText,
                                Model model){
        if(orderRating != null || minRating != null || orderDate != null || prioText != null){

        }
        List<Review> reviews = reviewService.listAll();
        model.addAttribute("reviews",reviews);
        return "reviews";
    }




}
