package org.example.decoratorflowers;

import org.springframework.stereotype.Component;

@Component("tulips")
public class Tulips implements IBouquet{


    @Override
    public String deliverFlowers() {
        return "Deliver Tulips";
    }

}
