package com.kistamushken.realmtests;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by gfish on 11/23/15.
 */
public class SimpleEntity extends RealmObject {

    @PrimaryKey
    private int someInt;

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }
}
