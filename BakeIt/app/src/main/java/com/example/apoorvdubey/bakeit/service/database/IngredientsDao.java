package com.example.apoorvdubey.bakeit.service.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.apoorvdubey.bakeit.service.model.Ingredient;


import java.util.List;

@Dao
public interface IngredientsDao {
    @Query("SELECT * FROM Ingredient where recipeId =(:value)")
    LiveData<List<Ingredient>> loadAllIngredients(Integer value);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIngredient(Ingredient result);

}
