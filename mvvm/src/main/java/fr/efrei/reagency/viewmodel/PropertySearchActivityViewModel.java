package fr.efrei.reagency.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import fr.efrei.reagency.bo.Property;
import fr.efrei.reagency.repository.PropertyRepository;

final public class PropertySearchActivityViewModel extends AndroidViewModel {

    public static final String TAG = PropertySearchActivityViewModel.class.getSimpleName();

    public enum Event
    {
        ResetForm, DisplayError
    }
    public MutableLiveData<PropertySearchActivityViewModel.Event> event = new MutableLiveData<>();

    public PropertySearchActivityViewModel(@NonNull Application application)
    {
        super(application);
    }
    public void searchProperty(boolean propertyTypeHouse, boolean propertyTypeFlat,
                               boolean propertyTypeOffice, boolean propertyTypeStudent,
                               boolean propertySold, int propertyPriceMin, int propertyPriceMax,
                               int propertySurfaceMin, int propertySurfaceMax, int propertyRoomMin,
                               int propertyRoomMax, int propertyDelaySold) {
        displaySearchPropertyEntries(propertyTypeHouse, propertyTypeFlat,
        propertyTypeOffice, propertyTypeStudent,
        propertySold, propertyPriceMin, propertyPriceMax,
        propertySurfaceMin, propertySurfaceMax, propertyRoomMin,
        propertyRoomMax, propertyDelaySold);

        persistSearchProperty(propertyTypeHouse, propertyTypeFlat,
                propertyTypeOffice, propertyTypeStudent,
                propertySold, propertyPriceMin, propertyPriceMax,
                propertySurfaceMin, propertySurfaceMax, propertyRoomMin,
                propertyRoomMax, propertyDelaySold);
    }


    private void persistSearchProperty(boolean propertyTypeHouse, boolean propertyTypeFlat,
                                       boolean propertyTypeOffice, boolean propertyTypeStudent,
                                       boolean propertySold, int propertyPriceMin,
                                       int propertyPriceMax, int propertySurfaceMin,
                                       int propertySurfaceMax, int propertyRoomMin,
                                       int propertyRoomMax, int propertyDelaySold) {
        PropertyRepository.getInstance(getApplication()).getProperties();

    }

    private void displaySearchPropertyEntries(boolean propertyTypeHouse, boolean propertyTypeFlat,
                                              boolean propertyTypeOffice, boolean propertyTypeStudent,
                                              boolean propertySold, int propertyPriceMin,
                                              int propertyPriceMax, int propertySurfaceMin,
                                              int propertySurfaceMax, int propertyRoomMin,
                                              int propertyRoomMax, int propertyDelaySold) {
        Log.d(PropertySearchActivityViewModel.TAG, "House : '" + propertyTypeHouse + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Flat : '" + propertyTypeFlat + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Office : '" + propertyTypeOffice + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Student Room : '" + propertyTypeStudent + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Sold : '" + propertySold + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Price Min : '" + propertyPriceMin + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Price Max : '" + propertyPriceMax + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Surface Min : '" + propertySurfaceMin + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "SurfaceMax : '" + propertySurfaceMax + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Room Min : '" + propertyRoomMin + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Room Max : '" + propertyRoomMax + "'");
        Log.d(PropertySearchActivityViewModel.TAG, "Delay Sold Date : '" + propertyDelaySold + "'");
    }

}
