package com.bizleap.training.assignment.four.impl;

import com.bizleap.training.assignment.four.AssociationMapper;
import com.bizleap.training.assignment.four.DataManager;

public class DataManagerImpl implements DataManager {
    @Override
    public void load() {
        AssociationMapper associationMapper = new AssociationMapperImpl();
    }

    @Override
    public void print() {

    }
}
