package com.ceylon.ghost;


    public class Posts {
        String name;
        String imageUrl;
        String feature_image;
        String html;
        String reading_time;
        String url;


        public Posts(String reading_time) {
            this.reading_time = reading_time;
        }

        public Posts(String name, String imageUrl, String feature_image, String html,String url) {
            this.name = name;
            this.imageUrl = imageUrl;
            this.feature_image = feature_image;
            this.html = html;
            this.url =url;

        }

        public Posts() {
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }



        public String getReading_time() {
            return reading_time;
        }

        public void setReading_time(String reading_time) {
            this.reading_time = reading_time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getFeature_image() {
            return feature_image;
        }

        public void setFeature_image(String feature_image) {
            this.feature_image = feature_image;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }

