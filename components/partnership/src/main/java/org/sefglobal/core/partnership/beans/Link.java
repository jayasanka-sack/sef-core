package org.sefglobal.core.partnership.beans;

import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Link {
    private Society society;
    private String link;


    public Link(Society society, int eventId, String serverAddress) {
        this.society = society;
        this.link = createLink(eventId, society.getId(), serverAddress);
    }

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String createLink(int eventId, int societyId, String serverAddress) {
        String base64encodedString = Base64.getEncoder()
                .encodeToString((eventId + ":" + societyId).getBytes(StandardCharsets.UTF_8));

        return serverAddress + "/" + base64encodedString;
    }
}
