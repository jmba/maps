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
        if(name != null) {
            this.name = name;
        }else{
            throw new IllegalArgumentException();
        }
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
        if(artist != null) {
            this.artist = artist;
        }else{
            throw new IllegalArgumentException();
        }
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
        if(creationDate != null) {
            this.creationDate = creationDate;
        }else{
            throw new IllegalArgumentException();
        }
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
        if(era != null) {
            this.era = era;
        }else{
            throw new IllegalArgumentException();
        }
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
        if(style != null) {
            this.style = style;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String asString() {
        return ROLE_IDENTIFIER;
    }
}
