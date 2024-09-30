package Main.main.cat.boscdelacoma.newpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private String name;
    private String genre;
    private String platform;
    private float price;
    private Set<User> consultingUsers;
    private List<Review> reviews;

    public Game(String name, String genre, String platform, float price) {
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
        this.consultingUsers = new HashSet<>();
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public float getPrice() {
        return price;
    }

    public void addConsultingUser(User user) {
        consultingUsers.add(user);
    }

    public Set<User> getConsultingUsers() {
        return consultingUsers;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void displayInfo() {
        System.out.println(name + " is a " + genre + " game on " + platform + " priced at $" + price);
    }
}
