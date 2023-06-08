package mk.ukim.finki.wp.eshop.service;

import mk.ukim.finki.wp.eshop.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> listAll();

    List<Review> sort(String orderRating, String minRating, String orderDate, String prioText);
}
