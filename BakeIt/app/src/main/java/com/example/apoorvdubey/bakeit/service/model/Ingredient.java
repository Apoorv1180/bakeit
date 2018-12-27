package com.example.apoorvdubey.bakeit.service.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(foreignKeys = @ForeignKey(
        entity = RecipeResponse.class,
        parentColumns = "id",
        childColumns = "recipeId"))
public class Ingredient implements Parcelable{

    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("ingredient")
    @Expose
    private String ingredient;
    @ColumnInfo(name = "recipeId")
    public Integer recipeId;

    protected Ingredient(Parcel in) {
        if (in.readByte() == 0) {
            quantity = null;
        } else {
            quantity = in.readInt();
        }
        measure = in.readString();
        ingredient = in.readString();
        if (in.readByte() == 0) {
            recipeId = null;
        } else {
            recipeId = in.readInt();
        }
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient(Integer quantity, String measure, String ingredient, Integer recipeId) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
        this.recipeId = recipeId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (quantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(quantity);
        }
        parcel.writeString(measure);
        parcel.writeString(ingredient);
        if (recipeId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(recipeId);
        }
    }
}