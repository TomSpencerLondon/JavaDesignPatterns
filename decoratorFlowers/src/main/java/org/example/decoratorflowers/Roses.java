package org.example.decoratorflowers;

import org.springframework.stereotype.Component;

@Component ("roses")
public class Roses implements IBouquet {

    @Override
    public String deliverFlowers() {
        return "Deliver Roses";
    }
}
