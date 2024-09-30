package Main.main.cat.boscdelacoma.newpackage;

public class Review {
    private User user;
    private String comment;
    private int rating;

    public Review(User user, String comment, int rating) {
        this.user = user;
        this.comment = comment;
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}
