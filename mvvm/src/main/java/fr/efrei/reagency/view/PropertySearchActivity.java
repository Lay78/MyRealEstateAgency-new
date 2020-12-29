package fr.efrei.reagency.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import fr.efrei.reagency.R;
import fr.efrei.reagency.viewmodel.PropertySearchActivityViewModel;

final public class PropertySearchActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = PropertySearchActivity.class.getSimpleName();

    private CheckBox chkHouse;
    private CheckBox chkFlat;
    private CheckBox chkOffice;
    private CheckBox chkStudent;
    private RadioButton rdNotSold;
    private RadioButton rdSold;
    private EditText  priceMin;
    private EditText  priceMax;
    private EditText  surfaceMin;
    private EditText  surfaceMax;
    private EditText  roomMin;
    private EditText  roomMax;
    private EditText delaySold;
    private Button btnSearch;

    private PropertySearchActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //We first set up the layout linked to the activity
        setContentView(R.layout.activity_search_property);

        chkHouse = findViewById(R.id.chkHouse);
        chkFlat = findViewById(R.id.chkFlat);
        chkOffice = findViewById(R.id.chkOffice);
        chkStudent = findViewById(R.id.chkStudent);
        rdNotSold = findViewById(R.id.propertyNotSold);
        rdSold = findViewById(R.id.propertySold);

        priceMin = findViewById(R.id.priceMin);
        priceMax = findViewById(R.id.priceMax);
        surfaceMin = findViewById(R.id.surfaceMin);
        surfaceMax = findViewById(R.id.surfaceMax);
        roomMin = findViewById(R.id.roomMin);
        roomMax = findViewById(R.id.roomMax);
        delaySold = findViewById(R.id.delaySold);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(this);
//        viewModel = new ViewModelProvider(this).get(PropertySearchActivityViewModel.class);
//        observeEvent();
    }

//    private void observeEvent() {
//        viewModel.event.observe(this, new Observer<PropertySearchActivityViewModel.Event>() {
//            @Override
//            public void onChanged(PropertySearchActivityViewModel.Event event) {
//                if (event == PropertySearchActivityViewModel.Event.ResetForm) {
//                    resetForm();
//                } else if (event == PropertySearchActivityViewModel.Event.DisplayError) {
//                    displayError();
//                }
//            }
//        });
//    }

    @Override
    public void onClick(View v) {
        String dataBack = "";
        final boolean propertyTypeHouse = chkHouse.isChecked();
        final boolean propertyTypeFlat = chkFlat.isChecked();
        final boolean propertyTypeOffice = chkOffice.isChecked();
        final boolean propertyTypeStudent = chkStudent.isChecked();
        final boolean propertySold = rdSold.isChecked();

        int propertyPriceMin, propertyPriceMax, propertySurfaceMin, propertySurfaceMax;
        int propertyRoomMin, propertyRoomMax, propertyDelaySold;

        String s = priceMin.getEditableText().toString();
        if (s.equals("")) propertyPriceMin = 0;
        else propertyPriceMin = Integer.parseInt(s);

        s = priceMax.getEditableText().toString();
        if (s.equals("")) propertyPriceMax = 0;
        else propertyPriceMax = Integer.parseInt(s);

        s = surfaceMin.getEditableText().toString();
        if (s.equals("")) propertySurfaceMin = 0;
        else propertySurfaceMin = Integer.parseInt(s);

        s = surfaceMax.getEditableText().toString();
        if (s.equals("")) propertySurfaceMax = 0;
        else propertySurfaceMax = Integer.parseInt(s);

        s = roomMin.getEditableText().toString();
        if (s.equals("")) propertyRoomMin = 0;
        else propertyRoomMin = Integer.parseInt(s);

        s = roomMax.getEditableText().toString();
        if (s.equals("")) propertyRoomMax = 0;
        else propertyRoomMax = Integer.parseInt(s);

        s = delaySold.getEditableText().toString();
        if (s.equals("")) propertyDelaySold = 0;
        else propertyDelaySold = Integer.parseInt(s);

        dataBack = "propertyTypeHouse="+propertyTypeHouse+";"+
                "propertyTypeFlat="+propertyTypeFlat+";"+
                "propertyTypeOffice="+propertyTypeOffice+";"+
                "propertyTypeStudent="+propertyTypeStudent+";"+"propertySold="+propertySold+";"+
                "priceMin="+propertyPriceMin+";"+"priceMax="+propertyPriceMax+";"+
                "surfaceMin="+propertySurfaceMin+";"+"surfaceMax="+propertySurfaceMax+";"+
                "roomMin="+propertyRoomMin+";"+"roomMax="+propertyRoomMax+";"+
                "delaySold="+propertyDelaySold;

        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("searchData", dataBack);
        setResult(RESULT_OK, intent);
        finish();

//        viewModel.searchProperty(propertyTypeHouse, propertyTypeFlat, propertyTypeOffice, propertyTypeStudent,
//                propertySold, propertyPriceMin, propertyPriceMax, propertySurfaceMin,
//                propertySurfaceMax, propertyRoomMin, propertyRoomMax, propertyDelaySold);
    }
//    private void displayError() {
//        new AlertDialog.Builder(this)
//                .setTitle(R.string.error_title)
//                .setMessage(R.string.cannot_add_property)
//                .setPositiveButton(android.R.string.ok, null)
//                .show();
//    }
//    private void resetForm() {}
}
