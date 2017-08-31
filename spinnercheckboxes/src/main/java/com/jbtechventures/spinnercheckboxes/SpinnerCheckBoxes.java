package com.jbtechventures.spinnercheckboxes;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatSpinner;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * <b>SpinnerCheckBoxes</b><br/>
 *  This class gives you an easy way to use dropdown with checkboxes and also initialize preselected values when the user wants to edit  vaules
 * Created by Johnbosco.
 */

public class SpinnerCheckBoxes extends AppCompatSpinner {

    Context mContext;

    public SpinnerCheckBoxes(Context context) {
        super(context);
        mContext = context;
    }

    public SpinnerCheckBoxes(Context context, int mode) {
        super(context, mode);
    }

    public SpinnerCheckBoxes(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpinnerCheckBoxes(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SpinnerCheckBoxes(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    public SpinnerCheckBoxes(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
    }

    /**
     * <b>Returns</b><br>
     * A hashSet of the selected items
     * */
    public HashSet<String> getSelectedItemsHasSet() {
        ArrayList<String> list = SpinnerCheckBoxAdapter.selectedItem;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(list);
        return hashSet;
    }

    /**
    * <b>Returns</b><br>
     * An array list of the selected items
    * */
    public ArrayList<String> getSelectedItems() {
        return SpinnerCheckBoxAdapter.selectedItem;
    }

    /**
     * <b>Returns</b><br>
     * A json String of the selected items
     * */
    public JSONArray getSelectedItemsJson() {
        ArrayList<String> list = SpinnerCheckBoxAdapter.selectedItem;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(list);
        list.clear();
        list.addAll(hashSet);
        return new JSONArray(list);
    }
}
