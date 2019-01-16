package com.is238.master.shuta;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddClassActivity extends AppCompatActivity {
private static EditText classnam,subname,teachname;
private static Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        initVeiw();
        onClassAdd();
    }

    private void initVeiw(){
        final Spinner dropdownRole = findViewById(R.id.spinnerclass);
        String[] items = new String[]{"Section","A", "B"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownRole.setAdapter(adapter);
        add=(Button)findViewById(R.id.btnadd);
        classnam=(EditText)findViewById(R.id.txtclass);
        subname=(EditText)findViewById(R.id.txtsubject);
        teachname=(EditText)findViewById(R.id.txtteacher);

    }



    public void onClassAdd() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ClassProvider.CLASS,
                        classnam.getText().toString());

                values.put(ClassProvider.SECTION,
                        ((Spinner)findViewById(R.id.spinnerclass)).getSelectedItem().toString());
                values.put(ClassProvider.SUBJECT,
                        subname.getText().toString());
                values.put(ClassProvider.TEACHER,
                        teachname.getText().toString());

                Uri uri = getContentResolver().insert(
                        ClassProvider.CONTENT_URI, values);
                Toast.makeText(getBaseContext(),
                        uri.toString(), Toast.LENGTH_LONG).show();

                Intent classIntent =new Intent(AddClassActivity.this, ClassLandingPage.class);
                startActivityForResult(classIntent,1);
                Toast.makeText(AddClassActivity.this,"data inserted sussefully",Toast.LENGTH_SHORT).show();

            }
        });
    }
/**fgfdkgmfkgfgf**/
}
