package xeon.com.youtube.Models;

/**
 * Created by tayyab on 8/25/18.
 */

public class News {
    public String Title;
    public String Description;
    public String ImageUrl;
    public String Date;
    public String NewsLink;

    public News() {
    }

    public News(String title, String description, String imageUrl) {
        Title = title;
        Description = description;
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public News setTitle(String title) {
        Title = title;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public News setDescription(String description) {
        Description = description;
        return this;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public News setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
        return this;
    }
}
