package com.example.gallery2.model;

public class ImagesMetaData {
    private String id;
    private String description;
    private int width;
    private int height;
    private URLS urls;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public URLS getUrls() {
        return urls;
    }

    public static class URLS {
        String raw;
        String full;
        String regular;
        String small;
        String thumb;

        public String getRaw() {
            return raw;
        }

        public String getFull() {
            return full;
        }

        public String getRegular() {
            return regular;
        }

        public String getSmall() {
            return small;
        }

        public String getThumb() {
            return thumb;
        }
    }
}
