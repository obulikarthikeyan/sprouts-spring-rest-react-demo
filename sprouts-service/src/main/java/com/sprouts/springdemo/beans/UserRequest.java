package com.sprouts.springdemo.beans;

import com.sprouts.springdemo.data.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.Instant;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNumber;
    private Boolean isActive;
    private Long timeCreated;
    private Long timeUpdated;

    private UserRequest() {
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String emailId;
        private Long phoneNumber;
        private Boolean isActive = Boolean.TRUE;
        private Long timeCreated = Instant.now().getEpochSecond();
        private Long timeUpdated = Instant.now().getEpochSecond();

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder emailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public Builder phoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder timeUpdated(Long timeUpdated) {
            this.timeUpdated = timeUpdated;
            return this;
        }

        public UserRequest build() {
            UserRequest userRequest = new UserRequest();
            userRequest.firstName = this.firstName;
            userRequest.lastName = this.lastName;
            userRequest.emailId = this.emailId;
            userRequest.phoneNumber = this.phoneNumber;
            userRequest.isActive = this.isActive;
            userRequest.timeCreated = this.timeCreated;
            userRequest.timeUpdated = this.timeUpdated;
            return userRequest;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmailId() {
            return emailId;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public Boolean getActive() {
            return isActive;
        }

        public Long getTimeCreated() {
            return timeCreated;
        }

        public Long getTimeUpdated() {
            return timeUpdated;
        }
    }

    public User toUserData() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
