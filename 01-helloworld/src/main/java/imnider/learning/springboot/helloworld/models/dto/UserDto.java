package imnider.learning.springboot.helloworld.models.dto;

import imnider.learning.springboot.helloworld.models.User;

public class UserDto {
    private User user;
    private String title;

    public UserDto() {
    }

    public UserDto(User user, String title) {
        this.user = user;
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
