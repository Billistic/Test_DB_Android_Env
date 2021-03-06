package dcom3b.test_db_android_env;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Main extends AppCompatActivity {

    private EditText text;
    private Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new Db(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = (EditText) findViewById(R.id.Text);
                Snackbar.make(view, "Note added...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                try {
                    db.add(text.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }


                text.setText("Enter Note...");
                TextView list = (TextView)findViewById(R.id.List);

                List<String> notes = db.getList();
                String result = "";
                for(int i = 0; i<notes.size();i++){
                    result = result + "\n" + notes.get(i);
                }
                list.setText(result);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
