/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Match {

    private final String username;
    private final String twitter;

    public Match(@NotNull @NotBlank User user) {
        this.username = user.getUsername();
        this.twitter = user.getTwitter();
    }

    public Match(@NotNull @NotBlank String username, @NotNull @NotBlank String twitter) {
        this.username = username;
        this.twitter = twitter;
    }

    public String getUsername() {
        return username;
    }

    public String getTwitter() {
        return twitter;
    }
}
