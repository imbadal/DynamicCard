package com.example.assignmentconzumex.model;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Data {

    private String category;
    private String color;
    private String fontName;
    private String fontSize;
    private String fontStyle;
    private long opacity;
    private String textTransformation;
    private String type;
    private Value value;
    private String valueType;

    public Data() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public long getOpacity() {
        return opacity;
    }

    public void setOpacity(long opacity) {
        this.opacity = opacity;
    }

    public String getTextTransformation() {
        return textTransformation;
    }

    public void setTextTransformation(String textTransformation) {
        this.textTransformation = textTransformation;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    @Override
    public String toString() {
        return "Data{" +
                "category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", fontName='" + fontName + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", fontStyle='" + fontStyle + '\'' +
                ", opacity=" + opacity +
                ", textTransformation='" + textTransformation + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public static class ValueDeserilizer implements JsonDeserializer<Value> {

        @Override
        public Value deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json.isJsonNull()) {
                return null;
            }
            Value value = new Value();

            if (json.isJsonPrimitive()) {
                if (json.getAsJsonPrimitive().isNumber())

                    if (json.getAsDouble() - json.getAsInt() > 0) {
                        value.setText(String.valueOf(json.getAsDouble()));
                    } else {
                        value.setText(String.valueOf(json.getAsInt()));
                    }
                else if (json.getAsJsonPrimitive().isString()) {
                    value.setText(json.getAsString());
                }
            } else if (json.isJsonObject()) {

                Value.Image image = new Value.Image();

                JsonObject jsonObject = json.getAsJsonObject();
                String cdn = jsonObject.get("cdn").getAsString();
                String filename = jsonObject.get("filename").getAsString();
                String folder = jsonObject.get("folder").getAsString();

                image.setCdn(cdn);
                image.setFilename(filename);
                image.setFolder(folder);

                value.setImage(image);

            } else {
                return null;
            }
            return value;
        }
    }
}




