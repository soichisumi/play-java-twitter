package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by s-sumi on 2016/05/08.
 */
@Entity
public class Tweet extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long tweetId;

    @NotNull
    public String userId;

    @CreatedTimestamp
    public Date postDate;

    @Constraints.Required
    @Constraints.Pattern(value = "\\w{1,140}", message = "ツイートは英数字で1-140字です")
    public String content;

    @ManyToOne
    public User user;

    public static Finder<Long, Tweet> find = new Finder<Long, Tweet>(Tweet.class);
}