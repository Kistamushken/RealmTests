package com.kistamushken.realmtests;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by gfish on 11/23/15.
 */
public class EntityWithNestedObject extends RealmObject {

    @PrimaryKey
    private int someInt;

    private SimpleEntity simpleEntity;


    public SimpleEntity getSimpleEntity() {
        return simpleEntity;
    }

    public void setSimpleEntity(SimpleEntity simpleEntity) {
        this.simpleEntity = simpleEntity;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }
}
