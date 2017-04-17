package com.example.tarat.longlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tarat.longlife.Message";
    public static final String EXTRA_AGE = "com.example.tarat.longlife.Age";
    public static final String EXTRA_SEX = "com.example.tarat.longlife.Sex";
    public static final String EXTRA_COUNTRY = "com.example.tarat.longlife.Country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        EditText et = (EditText) findViewById(R.id.editText2);
//        et.setFilters(new InputFilter[]{ new InputFilterMinMax("1920", "2017")});

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.ValidYears, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinnMFer
        spinner3.setAdapter(adapter3);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.MFU, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinnMFer
        spinner.setAdapter(adapter);

// Create an ArrayAdapter using the string array and a default spinner layout
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Countries, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinnMFer
        spinner2.setAdapter(adapter2);


    // Example of a call to a native method
 //   TextView tv = (TextView) findViewById(R.id.sample_text);
 //   tv.setText(stringFromJNI());
    }

    /** Called when the user taps the Calculate button */
    public void showSimulation(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Simulate.class);
        Spinner spinner3Text = (Spinner) findViewById(R.id.spinner3);
        String message = spinner3Text.getSelectedItem().toString();
        intent.putExtra(EXTRA_AGE, message);

        Spinner spinner1Text = (Spinner) findViewById(R.id.spinner);
        message = spinner1Text.getSelectedItem().toString();
        intent.putExtra(EXTRA_SEX, message);

        Spinner spinner2Text = (Spinner) findViewById(R.id.spinner2);
        message = spinner3Text.getSelectedItem().toString();
        intent.putExtra(EXTRA_COUNTRY, message);
        startActivity(intent);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
