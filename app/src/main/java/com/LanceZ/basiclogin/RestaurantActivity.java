package com.LanceZ.basiclogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class RestaurantActivity extends AppCompatActivity {

    private EditText editTextRestaurantName;
    private EditText editTextRestaurantCuisne;
    private EditText editTextRestaurantAddress;
    private RatingBar ratingBarRestaurantRating;
    private SeekBar seekBarRestaurantPrice;
    private Button buttonRestaurantConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        wireWidgets();


        buttonRestaurantConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToBackendless();
            }
        });
        //prefillFields();
    }




    Intent restaurantIntent = getIntent();
    Restaurant restaurant = restaurantIntent.getParcelableExtra(RestaurantListActivity.EXTRA_RESTAURANT);



    private void saveToBackendless() {
        String restaurantName = editTextRestaurantName.getText().toString();
        String restaurantCuisine = editTextRestaurantCuisne.getText().toString();
        String restaurantAddress = editTextRestaurantAddress.getText().toString();
        int restaurantPrice = seekBarRestaurantPrice.getProgress();
        double restaurantRating = ratingBarRestaurantRating.getRating();

        // if(allFieldsValid(restaurantName, restaurantCuisine, restaurantAddress, restaurantPrice, restaurantRating)){

        if (restaurant != null) {
            restaurant.setName(restaurantName);
            restaurant.setAddress(restaurantAddress);
            restaurant.setCuisine(restaurantCuisine);
            restaurant.setRating(restaurantRating);
            restaurant.setPrice(restaurantPrice);
        } else {
            Restaurant restaurant = new Restaurant(restaurantName, restaurantCuisine, restaurantPrice, restaurantAddress, restaurantRating);
        }


        Restaurant restaurant = new Restaurant(restaurantName, restaurantCuisine, restaurantPrice, restaurantAddress, restaurantRating);
        Backendless.Persistence.of(Restaurant.class).save(restaurant, new AsyncCallback<Restaurant>() {
            public void handleResponse(Restaurant restaurant) {
                finish();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(RestaurantActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }

    //private boolean allFieldsValid(String restaurantName, String restaurantCuisine,

    private void wireWidgets(){
        editTextRestaurantName = findViewById(R.id.editText_restaurantactivitiy_name);
        editTextRestaurantCuisne = findViewById(R.id.editText_restaurantactivitiy_cuisine);
        editTextRestaurantAddress = findViewById(R.id.editText_restaurantactivitiy_address);
        ratingBarRestaurantRating = findViewById(R.id.ratingBar_restaurant_rating);
        seekBarRestaurantPrice = findViewById(R.id.seekBar_restaurantactivitiy);
        buttonRestaurantConfirm = findViewById(R.id.button_restaurantactivitiy_confirm);
    }
}
