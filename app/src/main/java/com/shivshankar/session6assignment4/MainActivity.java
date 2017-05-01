package com.shivshankar.session6assignment4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] contact_name={"Shiv","Viren","Pratik"};
    String[] contact_no={"12312","45345","34234"};
    ListView contact_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_list=(ListView)findViewById(R.id.list);
        contact_list.setAdapter(new MyAdaptar(this,contact_name,contact_no));
        registerForContextMenu(contact_list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contexts_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition = info.position;
        Intent intent=new Intent();
            switch (item.getItemId()) {
                case R.id.call:
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+contact_no[listPosition]));
                    startActivity(intent);
                    break;
                case R.id.sms:
                    intent.setAction(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:"+contact_no[listPosition]));
                    startActivity(intent);
                    break;
            }
        return super.onContextItemSelected(item);
    }
}
