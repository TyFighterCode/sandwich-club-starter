package com.udacity.sandwichclub.utils;

import android.net.Uri;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
        String sandwichName;
        String sandOrigin;
        String sandDescription;
        String sandPic;

            JSONObject sandwichJsonObject = new JSONObject(json);
            JSONObject sandwichNameObj = sandwichJsonObject.getJSONObject("name");
            sandwichName = sandwichNameObj.getString("mainName");
            JSONArray anotherName = sandwichNameObj.getJSONArray("alsoKnownAs");
            JSONArray sandIngredients = sandwichJsonObject.getJSONArray("ingredients");


            ArrayList<String> anotherNamesList = new ArrayList<>();
            for (int i = 0; i < anotherName.length(); i++) {
                anotherNamesList.add(anotherName.getString(i));
            }
            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < sandIngredients.length(); i++) {
                ingredientsList.add(sandIngredients.getString(i));
            }

            sandOrigin = sandwichJsonObject.getString("placeOfOrigin");
            sandDescription = sandwichJsonObject.getString("description");
            sandPic = sandwichJsonObject.getString("image");

//     public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
            return new Sandwich(sandwichName, anotherNamesList, sandOrigin, sandDescription, sandPic, ingredientsList);

        } catch (JSONException e) {

            Log.e("Sandwich", "unexpected JSON exception", e);
            return null;
        }

    }
}
