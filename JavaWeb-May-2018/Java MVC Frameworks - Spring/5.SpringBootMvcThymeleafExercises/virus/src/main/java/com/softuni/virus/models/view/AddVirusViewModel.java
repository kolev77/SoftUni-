package com.softuni.virus.models.view;

import java.util.ArrayList;
import java.util.List;

public class AddVirusViewModel {
    private List<String> capitals;

    public AddVirusViewModel() {
        this.capitals = new ArrayList<>();
    }

    public List<String> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }
}
