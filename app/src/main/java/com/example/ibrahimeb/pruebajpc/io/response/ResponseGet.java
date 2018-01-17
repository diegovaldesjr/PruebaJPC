package com.example.ibrahimeb.pruebajpc.io.response;

import java.util.ArrayList;

/**
 * Created by ibrahimeb on 17/1/2018.
 */

public class ResponseGet {
    String url, origin;

    public ResponseGet(String url, String origin) {
        this.url = url;
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
