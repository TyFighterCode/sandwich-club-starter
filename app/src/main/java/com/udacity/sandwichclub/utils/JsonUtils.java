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

        //final String SAND_DESCRIPTION = "sandDescriptions";
        //final String SAND_INGREDIENTS = "sandIngredients";
        //final String SAND_KNOWNAS = "sandKnownAS";
        //final String SAND_ORIGIN = "sandOrigins";
        //final String SAND_PIC = "sandPicture";
        //String[] parsedWeatherData = null;
        String sandwichName;
        String sandOrigin;
        String sandDescription;
        String sandPic;


        try {
            //creating objects to use for json data
            JSONObject sandwichJsonObject = new JSONObject(json);
            sandwichName = sandwichJsonObject.getString("name");
            //String sandwichJsonName = parseSandwichJson(sandwichName);
            JSONArray anotherName = sandwichJsonObject.getJSONArray("knownAs");
            JSONArray sandIngredients = sandwichJsonObject.getJSONArray("ingredients");


            ArrayList<String> anotherNamesList = new ArrayList<>();
            for (int i = 0; i < anotherName.length(); i++) {
                anotherNamesList.add(anotherName.getString(i));
            }
            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < sandIngredients.length(); i++) {
                ingredientsList.add(sandIngredients.getString(i));
            }

            sandOrigin = sandwichJsonObject.getString("sandOrigin");
            sandDescription = sandwichJsonObject.getString("sandDescription");
            sandPic = sandwichJsonObject.getString("sandPic");
//     public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
            return new Sandwich(sandwichName, anotherNamesList, sandOrigin, sandDescription, sandPic, ingredientsList);

        } catch (JSONException e) {

            Log.e("Sandwich", "unexpected JSON exception", e);
            return null;
        }

    }
}
