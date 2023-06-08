package mk.ukim.finki.wp.eshop.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class Review {

    private Long id;

    private Long reviewId;

    private String reviewFullText;

    private String reviewText;

    private Integer numLikes = 0;

    private Integer numComments = 0;

    private Integer numShares = 0;

    private Integer rating;

    private String reviewCreatedOn = "2 months ago";

    private OffsetDateTime reviewCreatedOnDate;

    private Long reviewCreatedOnTime;

    private Long reviewerId;

    private String reviewerUrl;

    private String reviewerName;

    private String reviewerEmail;

    private String sourceType = "custom";

    private Boolean isVerified = false;

    private String source = "custom";

    private String sourceName = "1-20 Reviews";

    private Long sourceId = 54353720L;

    private List<String> tags = new ArrayList<>();

    private String href;

    private List<String> logoHref = new ArrayList<>();

    private List photos = new ArrayList();

    public Review(String reviewFullText, String reviewText, Integer rating, String reviewCreatedOnDate,
                  Long reviewCreatedOnTime, String reviewerName) {

        this.id = (long) (Math.random() * 1000);

        this.reviewId = (long) (Math.random() * 10000);

        this.reviewFullText = reviewFullText;

        this.reviewText = reviewText;

        this.rating = rating;

        this.reviewCreatedOnDate = OffsetDateTime.parse(reviewCreatedOnDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        this.reviewCreatedOnTime = reviewCreatedOnTime;

        this.reviewerName = reviewerName;
    }
}
