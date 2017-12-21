package com.firebase.ameerhamza.greendao;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUser extends AppCompatActivity {

    EditText first_name;
    EditText last_name;
    EditText email;
    Button mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        mSave = findViewById(R.id.mSave);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase.getAppDatabase(CreateUser.this).userDao().insertAll(new User(first_name.getText().toString(), last_name.getText().toString(), email.getText().toString()));
                startActivity(new Intent(CreateUser.this, MainActivity.class));
                //                db.userDao().insertAll(new User(first_name.getText().toString(), last_name.getText().toString(), email.getText().toString()));
//                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });
    }
}
