package com.kistamushken.realmtests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    RealmResults<SimpleEntity> simpleEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getInstance(this);

        for (int i = 0; i < 20; i++) {
            SimpleEntity simpleEntity = new SimpleEntity();
            simpleEntity.setSomeInt(i);
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(simpleEntity);
            realm.commitTransaction();
        }
    }

    public void getSimpleEntities(View view) {
        simpleEntities = realm.where(SimpleEntity.class).findAllAsync();
        simpleEntities.addChangeListener(new RealmChangeListener() {
            @Override
            public void onChange() {
                Toast.makeText(MainActivity.this, "SimpleEntity change listener fired", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addToSimpleResults(View view) {
        if (simpleEntities == null) return;
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setSomeInt(simpleEntities.size());
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(simpleEntity);
        realm.commitTransaction();
    }
}
