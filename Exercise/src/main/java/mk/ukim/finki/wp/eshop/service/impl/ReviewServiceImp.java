package mk.ukim.finki.wp.eshop.service.impl;

import mk.ukim.finki.wp.eshop.model.Review;
import mk.ukim.finki.wp.eshop.repository.InMemoryReviewRepository;
import mk.ukim.finki.wp.eshop.repository.ReviewSpecification;
import mk.ukim.finki.wp.eshop.repository.SearchCriteria;
import mk.ukim.finki.wp.eshop.repository.SearchOperation;
import mk.ukim.finki.wp.eshop.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImp implements ReviewService {

    private final InMemoryReviewRepository inMemoryReviewRepository;


    public ReviewServiceImp(InMemoryReviewRepository inMemoryReviewRepository) {
        this.inMemoryReviewRepository = inMemoryReviewRepository;
    }


    @Override
    public List<Review> listAll() {
        return inMemoryReviewRepository.listAll();
    }

    @Override
    public List<Review> sort(String orderRating, String minRating, String orderDate, String prioText) {
        List<Review> reviews = inMemoryReviewRepository.listAll();
            return null;
    }



    public List<Review> all(List<Map<String, String>> paramsList) {
        ReviewSpecification specification = new ReviewSpecification();

        Sort.Direction sortDirection = Sort.Direction.DESC;

        for (Map<String, String> params : paramsList) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value)) {
                    if (key.equals("rating")) {
                        // Handle rating logic
                        if (value.equals("highestFirst")) {
                            sortDirection = Sort.Direction.DESC;
                        } else if (value.equals("lowestFirst")) {
                            sortDirection = Sort.Direction.ASC;
                        }
                    } else if (key.equals("minimumRating")) {
                        // Handle minimumRating logic
                        specification.add(new SearchCriteria("rating", value, SearchOperation.GREATER_THAN_EQUAL));
                    } else if (key.equals("reviewCreatedOnDate")) {
                        // Handle reviewCreatedOnDate logic
                        if (value.equals("oldestFirst")) {
                            sortDirection = Sort.Direction.ASC;
                        } else if (value.equals("newestFirst")) {
                            sortDirection = Sort.Direction.DESC;
                        }
                    } else if (key.equals("prioritizeText") && value.equals("yes")) {
                        // Handle prioritizeText logic
                        specification.add(new SearchCriteria("reviewText", null, SearchOperation.NOT_NULL));
                    } else {
                        // Handle other parameters as needed
                    }
                }
            }
        }

        Sort sort = Sort.by(sortDirection, "rating");

        List<Review> reviews = inMemoryReviewRepository.getAll(specification, sort);
        return reviews;
    }
    
}
