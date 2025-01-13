package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class PendingUserAction extends Dto {
    /**
     * The URL to which to redirect the user to perform strong customer authentication (SCA) via a Mangopay-hosted webpage. This value is a variable and should not be hardcoded.
     * <p>
     * Caution: Before redirecting the user on this URL, you must add the query parameter ReturnUrl with the percent-encoded URL to which you want the SCA session to return the user after authentication (whether successful or not).
     * <p>
     * For more details, see <a href="https://docs.mangopay.com/guides/users/sca#how-to-redirect-a-user-for-an-sca-session">How to redirect a user for an SCA session</a>
     */
    @SerializedName("RedirectUrl")
    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public Boolean allFieldsNull(){
        return redirectUrl == null;
    }
}
