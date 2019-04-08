package com.example.assignmentconzumex.model;

public class Value {

    private String text;
    private Image image;

    Value() {
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static class Image {

        String cdn;
        String filename;
        String folder;

        public Image() {
        }

        public Image(String cdn, String filename, String folder) {
            this.cdn = cdn;
            this.filename = filename;
            this.folder = folder;
        }

        @Override
        public String toString() {
            return "Image{" +
                    "cdn='" + cdn + '\'' +
                    ", filename='" + filename + '\'' +
                    ", folder='" + folder + '\'' +
                    '}';
        }

        public String getCdn() {
            return cdn;
        }

        public void setCdn(String cdn) {
            this.cdn = cdn;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFolder() {
            return folder;
        }

        public void setFolder(String folder) {
            this.folder = folder;
        }
    }

    @Override
    public String toString() {
        return "Value{" +
                "text='" + text + '\'' +
                ", image=" + image +
                '}';
    }
}
