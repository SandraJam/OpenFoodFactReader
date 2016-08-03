package com.example.octo_sdu.openfoodfactreader;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editTextSearch)
    EditText editTextSearch;
    @BindView(R.id.buttonScanBarCode)
    FloatingActionButton buttonScanBarCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ObjectAnimator.ofFloat(editTextSearch, "alpha", 0, 0.1f, 1).setDuration(1000).start();
        ObjectAnimator.ofFloat(buttonScanBarCode, "alpha", 0, 0.1f, 1).setDuration(1000).start();

        buttonScanBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScan();
            }
        });

        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Intent intent = new Intent(MainActivity.this, ResultSearchActivity.class);
                intent.putExtra("search", editTextSearch.getText().toString());
                startActivity(intent);
                return true;
            }
        });
    }

    private void startScan() {
        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(MainActivity.this)
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withBackfacingCamera()
                .withText("Scanning...")
                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("barcode", barcode.rawValue);
                        startActivity(intent);
                    }
                })
                .build();
        materialBarcodeScanner.startScan();
    }
}
