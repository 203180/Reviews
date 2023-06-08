package mk.ukim.finki.wp.eshop.repository;


import mk.ukim.finki.wp.eshop.bootstrap.DataHolder;
import mk.ukim.finki.wp.eshop.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class InMemoryReviewRepository {

    public List<Review> listAll(){
        return DataHolder.reviewsList;
    }

    public List<Review> getAll(Specification<Review> specification, Sort sort) {
        return DataHolder.reviewsList;
    }




}
