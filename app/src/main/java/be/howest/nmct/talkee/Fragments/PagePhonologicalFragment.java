package be.howest.nmct.talkee.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import be.howest.nmct.talkee.MainActivity;
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

    private ImageView _pagePhonologicalHek;
    private ImageView _pagePhonologicalGras1;
    private ImageView _pagePhonologicalGras2;
    private ImageView _pagePhonologicalGras3;
    private TextView _pagePhonologicalWord;
    private ImageView _pagePhonologicalBoom;
    private ImageView _pagePhonologicalAppels;

    private TextView _pagePhonologicalInformation;

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

        _pagePhonologicalInformation = (TextView)view.findViewById(R.id.page_phonological_information);
        _pagePhonologicalInformation.setTypeface(typeface);
        _pagePhonologicalWord = (TextView)view.findViewById(R.id.page_phonological_word);
        _pagePhonologicalWord.setTypeface(typeface);
        _pagePhonologicalHek = (ImageView)view.findViewById(R.id.page_phonological_hek);
        _pagePhonologicalGras1 = (ImageView)view.findViewById(R.id.page_phonological_gras_1);
        _pagePhonologicalGras2 = (ImageView)view.findViewById(R.id.page_phonological_gras_2);
        _pagePhonologicalGras3 = (ImageView)view.findViewById(R.id.page_phonological_gras_3);
        _pagePhonologicalBoom = (ImageView)view.findViewById(R.id.page_phonological_boom);
        _pagePhonologicalAppels = (ImageView)view.findViewById(R.id.page_phonological_appels);

        _pagePhonologicalHek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Hek");
            }
        });
        _pagePhonologicalGras1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Gras");
            }
        });
        _pagePhonologicalGras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Gras");
            }
        });
        _pagePhonologicalGras3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Gras");
            }
        });
        _pagePhonologicalBoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Boom");
            }
        });
        _pagePhonologicalAppels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Appels");
            }
        });

        return view;
    }

    private void speak(String text) {
        if (MainActivity.CAN_SPEAK) {
            if (!MainActivity.TTS.isSpeaking()) {
                MainActivity.TTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

                if (text.equals("Appels")) {
                    showText(text.substring(1,2).toUpperCase() + " - " + text.toLowerCase());
                }
                else {
                    showText(text.substring(0,1).toUpperCase() + " - " + text.toLowerCase());
                }
            }
        }
    }

    private void showText(String text) {
        _pagePhonologicalWord.setVisibility(View.INVISIBLE);
        _pagePhonologicalWord.setText(text);
        _pagePhonologicalWord.setVisibility(View.VISIBLE);
    }
}
