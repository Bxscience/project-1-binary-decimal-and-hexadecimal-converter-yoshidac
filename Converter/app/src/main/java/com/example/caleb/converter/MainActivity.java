package com.example.caleb.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editBin;
    private EditText editDec;
    private EditText editHex;
    private Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editBin = (EditText)findViewById(R.id.editBin);
        editDec = (EditText)findViewById(R.id.editDec);
        editHex = (EditText)findViewById(R.id.editHex);
        Submit = (Button)findViewById(R.id.Submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editBin.getText().toString().equals("") && editDec.getText().toString().equals("") && editHex.getText().toString().equals("")){
                    toaster("Input a value");
                }
                else if (editBin.getText().toString().equals("") ^ editDec.getText().toString().equals("") ? editHex.getText().toString().equals("") : editBin.getText().toString().equals("")){
                    toaster("Input only one value");
                }
                else if(editBin.getText().toString().contains(".") || editDec.getText().toString().contains(".") || editHex.getText().toString().contains(".")){
                    toaster("Remove decimal point");
                }
                else if(editBin.getText().toString().contains(" ") || editDec.getText().toString().contains(" ") || editHex.getText().toString().contains(" ")){
                    toaster("Remove space");
                }
                else {
                    if (!editBin.getText().toString().equals("")){
                        try{
                            editDec.setText(Integer.toString(Integer.parseInt(editBin.getText().toString(), 2)));
                            editHex.setText(Integer.toHexString(Integer.parseInt(editBin.getText().toString(), 2)));
                        } catch (NumberFormatException e){
                            toaster("Invalid value");
                        }
                    }
                    else if (!editDec.getText().toString().equals("")){
                        try{
                            editBin.setText(Integer.toBinaryString(Integer.parseInt(editDec.getText().toString())));
                            editHex.setText(Integer.toHexString(Integer.parseInt(editDec.getText().toString())));
                        } catch (NumberFormatException e){
                            toaster("Invalid value");
                        }
                    }
                    else if (!editHex.getText().toString().equals("")){
                        try{
                            editBin.setText(Integer.toBinaryString(Integer.parseInt(editHex.getText().toString(), 16)));
                            editDec.setText(Integer.toString(Integer.parseInt(editHex.getText().toString(), 16)));
                        } catch (NumberFormatException e){
                            toaster("Invalid value");
                        }
                    }
                }
            }
        });
    }
    private void toaster(String str){
        Toast toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG);
        toast.show();
        editBin.getText().clear();
        editDec.getText().clear();
        editHex.getText().clear();
    }
}
