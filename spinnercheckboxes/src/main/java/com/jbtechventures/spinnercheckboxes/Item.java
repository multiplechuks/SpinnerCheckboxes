package com.jbtechventures.spinnercheckboxes;

/**
 * Created by Johnbosco on 28/08/2017.
 */

public class Item {
    private int Id;
    private String itemName;
    private boolean checked;

    public Item(String name) {
        this.itemName = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isChecked() {
        return checked;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
