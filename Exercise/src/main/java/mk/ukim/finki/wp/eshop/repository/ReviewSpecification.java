package mk.ukim.finki.wp.eshop.repository;

import mk.ukim.finki.wp.eshop.model.Review;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReviewSpecification implements Specification<Review> {
    private List<SearchCriteria> list;

    public ReviewSpecification() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Review> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return new SpecificationHelper<Review>().resolvePredicate(list, root, query, builder);
    }



}
