package be.howest.nmct.talkee.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.howest.nmct.talkee.R;

public class PageFinishFragment extends Fragment {
    private TextView _pageFinishText1;
    private TextView _pageFinishText2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.page_finish, container, false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PoetsenOne.ttf");

        _pageFinishText1 = (TextView)view.findViewById(R.id.page_finish_text_1);
        _pageFinishText1.setTypeface(typeface);
        _pageFinishText2 = (TextView)view.findViewById(R.id.page_finish_text_2);
        _pageFinishText2.setTypeface(typeface);

        return view;
    }
}
