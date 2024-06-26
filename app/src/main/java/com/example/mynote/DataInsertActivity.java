package com.example.mynote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynote.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {

    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the binding object before using it
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String tyep = getIntent().getStringExtra("type");
        if (tyep.equals("update")) {
                setTitle("update");
                binding.title.setText(getIntent().getStringExtra("title"));
                binding.disp.setText(getIntent().getStringExtra("disp"));
                int id=getIntent().getIntExtra("id",0);
                binding.add.setText("Update note");
                binding.add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("title", binding.title.getText().toString());
                        intent.putExtra("disp", binding.disp.getText().toString());
                        intent.putExtra("id",id);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
        }else {
            setTitle("Add Mode");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.title.getText().toString());
                    intent.putExtra("disp", binding.disp.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();

        startActivity(new Intent(this, MainActivity.class));
    }
}
