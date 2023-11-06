import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TwitterTest {

    @Test
    void test1() {
        Twitter tw = new Twitter();
        tw.postTweet(1,5);
        tw.postTweet(2,3);
        tw.postTweet(1,101);
        tw.postTweet(2,13);
        tw.postTweet(2,10);
        tw.postTweet(1,2);
        tw.postTweet(1,94);
        tw.postTweet(2,505);
        tw.postTweet(1,333);
        tw.postTweet(2,22);
        tw.postTweet(1,11);
        tw.postTweet(1,205);
        tw.postTweet(2,203);
        tw.postTweet(1,201);
        tw.postTweet(2,213);
        tw.postTweet(1,200);
        tw.postTweet(2,202);
        tw.postTweet(1,204);
        tw.postTweet(2,208);
        tw.postTweet(2,233);
        tw.postTweet(1,222);
        tw.postTweet(2,211);
        tw.getNewsFeed(1);
        tw.follow(1, 2);
        assertThat(tw.getNewsFeed(1)).isEqualTo(List.of(211,222,233,208,204,202,200,213,201,203));
        tw.unfollow(1,2);
        tw.getNewsFeed(1);

    }


}