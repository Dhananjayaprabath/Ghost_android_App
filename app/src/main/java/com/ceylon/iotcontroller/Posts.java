package com.ceylon.iotcontroller;


    public class Posts {
        String name;
        String imageUrl;
        String feature_image;
        String html;


        public Posts(String name, String imageUrl, String feature_image,String html) {
            this.name = name;
            this.imageUrl = imageUrl;
            this.feature_image = feature_image;
            this.html = html;

        }

        public Posts() {
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

