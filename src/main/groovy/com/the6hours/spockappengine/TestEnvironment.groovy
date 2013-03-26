package com.the6hours.spockappengine

import com.google.apphosting.api.ApiProxy

import java.util.concurrent.TimeUnit

/**
 *
 * @author Igor Artamonov (http://igorartamonov.com)
 * @since 16.03.13
 */
class TestEnvironment implements ApiProxy.Environment {

    public String getAppId() {
        return "Spock Tests";
    }

    public String getVersionId() {
        return "1.0";
    }

    public String getEmail() {
        return "test@localhost";
    }

    public boolean isLoggedIn() {
        return false;
    }

    public boolean isAdmin() {
        return false;
    }

    public String getAuthDomain() {
        return "spocktest.local";
    }

    public String getRequestNamespace() {
        return "spocktest.local";
    }

    public Map<String, Object> getAttributes() {
        return [:];
    }

    long getRemainingMillis() {
        return TimeUnit.SECONDS.toMillis(20)
    }

}
