package com.ism.services;

import com.ism.entities.Rdv;

public interface RdvService extends IService<Rdv> {
    int show();

    int showMdc();

    int cancel();
    
}
