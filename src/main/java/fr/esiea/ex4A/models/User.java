/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

    private final String username;
    private final String email;
    private final String twitter;
    private final Sex sex;
    private final Sex sexPref;

    @JsonIgnore private final Integer age;

    @Pattern(regexp = "^[A-Z]{2}$")
    private final String country;

    private enum Sex {M, O, F;}
    @JsonCreator
    public User(
            @NotNull @NotBlank @JsonProperty(required = true, value = "userName") String username,
            @NotNull @NotBlank @JsonProperty(required = true, value = "userEmail") String email,
            @NotNull @NotBlank @JsonProperty(required = true, value = "userTweeter") String twitter,
            @NotNull @NotBlank @JsonProperty(required = true, value = "userSex") String sex,
            @NotNull @NotBlank @JsonProperty(required = true, value = "userSexPref") String sexPref,
            @NotNull @NotBlank @JsonProperty(required = true, value = "userCountry")
                    String country) {
        this.username = username;
        this.email = email;
        this.twitter = twitter;
        this.sex = Sex.valueOf(sex);
        this.sexPref = Sex.valueOf(sexPref);
        this.country = country;
        this.age = null;
    }
    public User(@NotNull @NotBlank User user, @NotNull @NotBlank Integer age) {
        this.age = age;
        this.username = user.username;
        this.email = user.email;
        this.twitter = user.twitter;
        this.sex = user.sex;
        this.sexPref = user.sexPref;
        this.country = user.country;
    }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getTwitter() { return twitter; }
    public Sex getSex() { return sex; }
    public Sex getSexPref() { return sexPref; }
    public Integer getAge() { return age; }
    public String getCountry() { return country; }
}
