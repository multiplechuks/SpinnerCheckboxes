package com.jbtechventures.spinnercheckboxes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * SpinnerCheckBoxAdapter with two constructors accepts the String value of a list of items and adds checkboxes to each of them.
 * <br/><br/>
 * <u>SpinnerCheckBoxAdapter(context,items)</u><br/>
 * <b>context</b>: The application context.<br>
 * <b>items</b>: the string value of the items
 * <br/><br/>
 * <u>SpinnerCheckBoxAdapter(context, items, selectedItems)</u><br/>
 * <i>use this constructor when you want to pre-fill the spinner checkboxes with selected values</i><br>
 * <b>context</b>: The application context.<br>
 * <b>items</b>: The string value of the items<br/>
 * <b>selectedItems</b>: The selected values as arraylist<br/>
 * <br/>
 * Created By Johnbosco...
 */

public class SpinnerCheckBoxAdapter extends BaseAdapter {

    Context mContext;
    public static ArrayList<String> selectedItem = new ArrayList<>();
    private ArrayList<Item> _items = new ArrayList<>();
    private ArrayList<Item> _selItems = new ArrayList<>();

    public SpinnerCheckBoxAdapter(Context context, ArrayList items) {
        mContext = context;
        for (int i = 0; i < items.size(); i++) {
            this._items.add(new Item(items.get(i).toString()));
        }
        _items.add(0, new Item("Select from list"));
        _selItems = null;
    }

    /**
     * Prefills the selected items in their positions
     * */
    public SpinnerCheckBoxAdapter(Context context, ArrayList items, Boolean otherSpecifyPresent) {
        mContext = context;
        for (int i = 0; i < items.size(); i++) {
            this._items.add(new Item(items.get(i).toString()));
        }
        /*for (int i = 0; i < selectedItems.size(); i++) {
            this._selItems.add(new Item(selectedItems.get(i).toString()));
        }*/
        _items.add(0, new Item("Select from list"));
    }

    /**
    * Prefills the selected items in their positions
    * */
    public SpinnerCheckBoxAdapter(Context context, ArrayList items, ArrayList selectedItems) {
        mContext = context;
        for (int i = 0; i < items.size(); i++) {
            this._items.add(new Item(items.get(i).toString()));
        }
        for (int i = 0; i < selectedItems.size(); i++) {
            this._selItems.add(new Item(selectedItems.get(i).toString()));
        }
        _items.add(0, new Item("Select from list"));
    }

    @Override
    public int getCount() {
        return _items.size();
    }

    @Override
    public Item getItem(int position) {
        return _items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _items.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Item item = getItem(position);
        if (_selItems != null) {
            for (int j = 0; j < _selItems.size(); j++) {
                if (item.getItemName().equals(_selItems.get(j).getItemName())) {
                    item.setChecked(true);
                }
            }
        }
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.checkbox, null);
        final CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.checkBox);
        final TextView textView = (TextView)convertView.findViewById(R.id.select);
        final EditText othersSpecify = (EditText)convertView.findViewById(R.id.enter_others);
        othersSpecify.setVisibility(View.GONE);
        checkBox.setTextColor(Color.BLACK);
        textView.setPadding(5, 5, 0, 5);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(16);
        if(position == 0) {
            checkBox.setVisibility(View.GONE);
            checkBox.setChecked(false);
            textView.setText(item.getItemName());
        }
        else {
            textView.setVisibility(View.GONE);
            checkBox.setText(item.getItemName());
            checkBox.setId(position);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (compoundButton.isChecked()) {
                        if(compoundButton.getText().toString().equalsIgnoreCase("Others(Specify)")) {
                            /*othersSpecify.setVisibility(View.VISIBLE);
                            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 1);
                            //imm.toggleSoftInput(InputMethodManager.RESULT_SHOWN, 1);
                            compoundButton.setVisibility(View.INVISIBLE);
                            *//*othersSpecify.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                }

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before, int count) {

                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                    selectedItem
                                }
                            });*//*
                            selectedItem.add(othersSpecify.getText().toString().trim());*/
                        }
                        if (!selectedItem.contains(item.getItemName())) {
                            selectedItem.add(item.getItemName());
                        }
                    }
                    else {
                        if (selectedItem.contains(item.getItemName())) {
                            selectedItem.remove(item.getItemName());
                        }
                    }
                    item.setChecked(b);
                    item.setId(position);
                }
            });
            if (item.isChecked()) {
                checkBox.setChecked(true);
            }
        }
        return  convertView;
    }
}
