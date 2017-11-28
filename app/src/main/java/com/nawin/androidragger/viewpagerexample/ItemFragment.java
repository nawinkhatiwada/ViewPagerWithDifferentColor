package com.nawin.androidragger.viewpagerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created on 11/28/17.
 */

public class ItemFragment extends Fragment {
    private static final String POSITION = "_pos";

    public static ItemFragment getInstance(int position) {
        ItemFragment itemFragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        itemFragment.setArguments(args);
        return itemFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_layout, container, false);
        int pos = getArguments().getInt(POSITION);
        TextView textView = view.findViewById(R.id.tvItem);
        if (pos % 2 == 0)
            textView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        else
            textView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        return view;
    }
}
