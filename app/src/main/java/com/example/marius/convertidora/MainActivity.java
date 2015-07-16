package com.example.marius.convertidora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    int pos;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter <CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.conversiones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void displayMessage(String message){

        TextView convertirTextView = (TextView) findViewById(R.id.txtResultado);
        convertirTextView.setText(message);
    }

    public void resultado(View view){

        EditText et1= (EditText)findViewById(R.id.etxValor);
        if (et1.getText().toString().trim().length()>0){
            String ed1, converMessage;
            double cm,in,re1,m,km, c, f;
            ed1=et1.getText().toString();
            re1=Double.parseDouble(ed1);

            switch (pos)
            {
                case 0:
                    in=re1/2.54;
                    converMessage="cm= " +re1+"\n in= "+ in;
                    displayMessage(converMessage);
                    break;
                case 1:
                    cm=re1*2.54;
                    converMessage="in= " +re1+"\n cm= "+ cm;
                    displayMessage(converMessage);
                    break;
                case 2:
                    m = re1 * 1000;
                    converMessage = "De: " + re1 + "kilometros" + " a" + m + "metros";
                    displayMessage(converMessage);
                    break;
                case 3:
                    km = re1 / 1000;
                    converMessage = "De: " + re1 + "metros" + " a" + km + " kilometros";
                    displayMessage(converMessage);
                    break;
                case 4:
                    c = (re1 - 32) / 1.8000;
                    converMessage = "De: " + re1 + " farenheit" + " a" + c + " centigrados";
                    displayMessage(converMessage);
                    break;

                case 5:
                    f = re1 * 1.8000 + 32;
                    converMessage = "De: " + re1 + " centigrados" + " a" + f + "farenheit";
                    displayMessage(converMessage);
                    break;



            }
        }

        else
        {
            String error="valor no valido";
            displayMessage(error);

        }


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
