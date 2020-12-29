package fr.efrei.reagency.view;

import androidx.appcompat.app.AppCompatActivity;
import fr.efrei.reagency.R;
import fr.efrei.reagency.viewmodel.SimulatorActivityViewModel;

import android.os.Bundle;

public class SimulatorActivity extends AppCompatActivity {

    private SimulatorActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator);
    }
}