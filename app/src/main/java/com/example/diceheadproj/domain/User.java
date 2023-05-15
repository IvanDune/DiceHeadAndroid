package com.example.diceheadproj.domain;

import com.orm.SugarRecord;

import java.util.Set;

public class User extends SugarRecord<User> {
    private Long id;

        private String login;

        private String password;

        private String nickname;

        private String email;

        private Boolean active;

        private String description;


        Set<Character> characters;

//        private Integer grade;
//        private Set<Role> roles;
//        private Set<Review> reviews;
//        private Set<Game> subscriptions = new HashSet<>();

        public User() {
        }

        public User(String login, String password, String nickname, String email) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
            this.email = email;
//            this.grade = 0;
        }

//        public Integer gameValue(){
//            return getSubscriptions().size();
//        }
//
//        public Integer characterValue(){
//            return getCharacters().size();
//        }
//
//
//        public boolean isAdmin(){
//            return roles.contains(Role.ADMIN);
//        }
//
//        public Set<Game> getSubscriptions() {
//            return subscriptions;
//        }
//
//        public void setSubscriptions(Set<Game> subscriptions) {
//            this.subscriptions = subscriptions;
//        }

        public Boolean isActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

//        public Set<Role> getRoles() {
//            return roles;
//        }
//
//        public void setRoles(Set<Role> roles) {
//            this.roles = roles;
//        }
//
//        public void setGrade(Integer grade){
//            if (roles.contains("MASTER"))
//                this.grade = grade;
//        }
//
//        public Integer getGrade(){
//            return grade;
//        }



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

//        public Set<Review> getReviews() {
//            return reviews;
//        }
//
//        public void setReviews(Set<Review> reviews) {
//            this.reviews = reviews;
//        }
//
//
//        public void changeVote(Review review){ // Plus new vote
//            if (roles.contains(Role.MASTER)){
//                int allVotes = grade * reviews.size()  + review.getGrade();
//                reviews.add(review);
//                grade = (allVotes)/(reviews.size());
//
//            }
//        }
//
//        public void changeVote(Review oldReview, Review newReview){ // Change old vote
//            if (roles.contains("MASTER")){
//                int allVotes = grade * reviews.size()  + newReview.getGrade() - oldReview.getGrade();
//                grade = (allVotes)/(reviews.size()+1);
//            }
//        }

//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            return getRoles();
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        @Override
//        public String getUsername() {
//            return login;
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return isActive();
//        }

        public Boolean getActive() {
            return active;
        }

        public Set<Character> getCharacters() {
            return characters;
        }

        public void setCharacters(Set<Character> characters) {
            this.characters = characters;
        }

//        @Override
//        public int compareTo(User user) {
//            return id.compareTo(user.getId());
//        }
}
