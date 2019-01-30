package com.LanceZ.basiclogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;

import com.backendless.Backendless;

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

        wirewidgets();

        buttonRestaurantConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadRestaurantOnBackendless();
            }
        });


    }

    private void uploadRestaurantOnBackendless() {
        String restaurantName = editTextRestaurantName.getText().toString();
        String restaurantCuisine = editTextRestaurantCuisne.getText().toString();
        String restaurantAddress = editTextRestaurantAddress.getText().toString();
        int restaurantPrice = seekBarRestaurantPrice.getProgress();
        double restaurantRating = ratingBarRestaurantRating.getRating();

       // if(allFieldsValid(restaurantName, restaurantCuisine, restaurantAddress, restaurantPrice, restaurantRating)){


    }

    //private boolean allFieldsValid(String restaurantName, String restaurantCuisine,

    private void wirewidgets() {
        editTextRestaurantName = findViewById(R.id.editText_restaurantactivitiy_name);
        editTextRestaurantCuisne = findViewById(R.id.editText_restaurantactivitiy_cuisine);
        editTextRestaurantAddress = findViewById(R.id.editText_restaurantactivitiy_address);
        ratingBarRestaurantRating = findViewById(R.id.ratingBar_restaurant_rating);
        seekBarRestaurantPrice = findViewById(R.id.seekBar_restaurantactivitiy);
        buttonRestaurantConfirm = findViewById(R.id.button_restaurantactivitiy_confirm);
    }
}
