package mk.ukim.finki.wp.eshop.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wp.eshop.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Review> reviewsList = new ArrayList<>();

    List<Review> reviewList = new ArrayList<>();
    public static Page<Review> reviewPage = new PageImpl<>(reviewsList);


    @PostConstruct
    public void init(){
        reviewsList.add(new Review("5 star review","5 star review",5,
                "2021-01-25T13:00:35+00:00",1611579635L,"Reviewer #20"));
        reviewsList.add(new Review("4 star review", "4 star review",4, "2021-01-25T13:00:21+00:00",1611579621L,"Reviewer #19"));
        reviewsList.add(new Review("3 star review", "3 star review",3, "2021-01-25T13:00:10+00:00",1611579610L,"Reviewer #18"));
        reviewsList.add(new Review("2 star review", "2 star review",2, "2021-01-25T12:59:57+00:00",1611579597L,"Reviewer #17"));
        reviewsList.add(new Review("", "",4, "2021-01-25T12:59:15+00:00",1611579555L,"Reviewer #14"));
    }
}
