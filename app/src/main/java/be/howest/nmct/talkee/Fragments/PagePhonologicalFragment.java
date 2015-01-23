package be.howest.nmct.talkee.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import be.howest.nmct.talkee.R;

public class PagePhonologicalFragment extends Fragment {
    private ImageView _pagePhonologicalHelp;
    private ImageView _pagePhonologicalHelpButton;
    private TextView _pagePhonologicalHelpClose;
    private TextView _pagePhonologicalOefening;
    private TextView _pagePhonologicalTitle;
    private TextView _pagePhonologicalLeeftijd;
    private TextView _pagePhonologicalLeeftijdInfo;
    private TextView _pagePhonologicalDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.page_phonological, container, false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PoetsenOne.ttf");

        _pagePhonologicalHelp = (ImageView)view.findViewById(R.id.page_phonological_help);
        _pagePhonologicalTitle = (TextView)view.findViewById(R.id.page_phonological_title);
        _pagePhonologicalTitle.setTypeface(typeface);
        _pagePhonologicalLeeftijdInfo = (TextView)view.findViewById(R.id.page_phonological_leeftijd_info);
        _pagePhonologicalLeeftijdInfo.setTypeface(typeface);
        _pagePhonologicalOefening = (TextView)view.findViewById(R.id.page_phonological_oefening);
        _pagePhonologicalLeeftijd = (TextView)view.findViewById(R.id.page_phonological_leeftijd);
        _pagePhonologicalDescription = (TextView)view.findViewById(R.id.page_phonological_description);
        _pagePhonologicalHelpButton = (ImageView)view.findViewById(R.id.page_phonological_help_button);
        _pagePhonologicalHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _pagePhonologicalHelp.setVisibility(View.VISIBLE);
                _pagePhonologicalHelpClose.setVisibility(View.VISIBLE);
                _pagePhonologicalHelpButton.setVisibility(View.INVISIBLE);

                _pagePhonologicalOefening.setVisibility(View.VISIBLE);
                _pagePhonologicalTitle.setVisibility(View.VISIBLE);
                _pagePhonologicalLeeftijd.setVisibility(View.VISIBLE);
                _pagePhonologicalLeeftijdInfo.setVisibility(View.VISIBLE);
                _pagePhonologicalDescription.setVisibility(View.VISIBLE);
            }
        });
        _pagePhonologicalHelpClose = (TextView)view.findViewById(R.id.page_phonological_help_close);
        _pagePhonologicalHelpClose.setTypeface(typeface);
        _pagePhonologicalHelpClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _pagePhonologicalHelp.setVisibility(View.INVISIBLE);
                _pagePhonologicalHelpClose.setVisibility(View.GONE);
                _pagePhonologicalHelpButton.setVisibility(View.VISIBLE);

                _pagePhonologicalOefening.setVisibility(View.INVISIBLE);
                _pagePhonologicalTitle.setVisibility(View.INVISIBLE);
                _pagePhonologicalLeeftijd.setVisibility(View.INVISIBLE);
                _pagePhonologicalLeeftijdInfo.setVisibility(View.INVISIBLE);
                _pagePhonologicalDescription.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }
}
