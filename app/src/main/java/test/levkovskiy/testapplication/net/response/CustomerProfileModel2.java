package test.levkovskiy.testapplication.net.response;

import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "CustomerProfileModel2")
public class CustomerProfileModel2 {


    /**
     * name : Michael Smith Holdings
     * email : foo@bar.gaz
     * imageUrl : http://api.randomuser.me/portraits/med/women/39.jpg
     * totalLikes : 65
     * googleTotalReviews : 587
     * googleRating : 3.5
     * yelpTotalReviews : 756.0
     * yelpRating : 2.5
     * phoneNumber : 718-7760-9876
     * address : New York 64, Pittsford, NY
     * serviceArea : 30 mi
     * category : Mover // Storrage
     * description : Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries
     * photos : ["https://randomuser.me/api/portraits/med/women/92.jpg","https://randomuser.me/api/portraits/med/men/99.jpg","https://randomuser.me/api/portraits/med/women/20.jpg"]
     * recordings : [{"duration":60,"createDate":"2016-11-07 8:07:23","url":"http://www-mmsp.ece.mcgill.ca/documents/audioformats/wave/Samples/AFsp/M1F1-Alaw-AFsp.wav"},{"duration":120,"createDate":"2017-02-15 8:07:23","url":"http://www-mmsp.ece.mcgill.ca/documents/audioformats/wave/Samples/AFsp/M1F1-int24-AFsp.wav"}]
     */

    private String name;
    private String email;
    private String imageUrl;
    private int totalLikes;
    private int googleTotalReviews;
    private double googleRating;
    private double yelpTotalReviews;
    private double yelpRating;
    private String phoneNumber;
    private String address;
    private String serviceArea;
    private String category;
    private String description;
    private List<String> photos;
    private List<RecordingsEntity> recordings;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public void setGoogleTotalReviews(int googleTotalReviews) {
        this.googleTotalReviews = googleTotalReviews;
    }

    public void setGoogleRating(double googleRating) {
        this.googleRating = googleRating;
    }

    public void setYelpTotalReviews(double yelpTotalReviews) {
        this.yelpTotalReviews = yelpTotalReviews;
    }

    public void setYelpRating(double yelpRating) {
        this.yelpRating = yelpRating;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public void setRecordings(List<RecordingsEntity> recordings) {
        this.recordings = recordings;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getGoogleTotalReviews() {
        return googleTotalReviews;
    }

    public double getGoogleRating() {
        return googleRating;
    }

    public double getYelpTotalReviews() {
        return yelpTotalReviews;
    }

    public double getYelpRating() {
        return yelpRating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public List<RecordingsEntity> getRecordings() {
        return recordings;
    }

    public static class RecordingsEntity {
        /**
         * duration : 60
         * createDate : 2016-11-07 8:07:23
         * url : http://www-mmsp.ece.mcgill.ca/documents/audioformats/wave/Samples/AFsp/M1F1-Alaw-AFsp.wav
         */

        private int duration;
        private String createDate;
        private String url;

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getDuration() {
            return duration;
        }

        public String getCreateDate() {
            return createDate;
        }

        public String getUrl() {
            return url;
        }
    }
}