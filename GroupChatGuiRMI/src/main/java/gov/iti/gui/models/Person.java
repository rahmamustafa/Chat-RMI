package gov.iti.gui.models;


public class Person{
    String name;
    String imageUrl;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        System.out.println("urllllllllllllllllllllllllllllllllllllllllllllllll:"+imageUrl);
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Person(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }


    public Person() {
      
    }

    


}