package org.wahlzeit.collaboration.implementation;

/**
 * Created by Johannes Bayerl on 11.01.15.
 */
public class ArtworkMapRole extends MapRole {
    public static String ROLE_IDENTIFIER = "ArtworkMapRole";

    private String name;
    private String artist;
    private String creationDate;
    private String era;
    private String style;

    /**
     * @methodtype getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @methodtype setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @methodtype getter
     * @return
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @methodtype setter
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @methodtype getter
     * @return
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * @methodtype setter
     * @param creationDate
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @methodtype getter
     * @return
     */
    public String getEra() {
        return era;
    }

    /**
     * @methodtype setter
     * @param era
     */
    public void setEra(String era) {
        this.era = era;
    }

    /**
     * @methodtype getter
     * @return
     */
    public String getStyle() {
        return style;
    }

    /**
     * @methodtype setter
     * @param style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String asString() {
        return ROLE_IDENTIFIER;
    }
}
