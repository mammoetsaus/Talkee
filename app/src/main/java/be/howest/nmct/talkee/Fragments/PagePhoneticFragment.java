package be.howest.nmct.talkee.Fragments;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import be.howest.nmct.talkee.MainActivity;
import be.howest.nmct.talkee.R;

public class PagePhoneticFragment extends Fragment {
    private ImageView _pagePhoneticHelp;
    private ImageView _pagePhoneticHelpButton;
    private TextView _pagePhoneticHelpClose;
    private TextView _pagePhoneticOefening;
    private TextView _pagePhoneticTitle;
    private TextView _pagePhoneticLeeftijd;
    private TextView _pagePhoneticLeeftijdInfo;
    private TextView _pagePhoneticDescription;

    private ImageView _pagePhoneticBee;
    private ImageView _pagePhoneticSnake;
    private TextView _pagePhoneticInformation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.page_phonetic, container, false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PoetsenOne.ttf");

        _pagePhoneticHelp = (ImageView)view.findViewById(R.id.page_phonetic_help);
        _pagePhoneticTitle = (TextView)view.findViewById(R.id.page_phonetic_title);
        _pagePhoneticTitle.setTypeface(typeface);
        _pagePhoneticLeeftijdInfo = (TextView)view.findViewById(R.id.page_phonetic_leeftijd_info);
        _pagePhoneticLeeftijdInfo.setTypeface(typeface);
        _pagePhoneticOefening = (TextView)view.findViewById(R.id.page_phonetic_oefening);
        _pagePhoneticLeeftijd = (TextView)view.findViewById(R.id.page_phonetic_leeftijd);
        _pagePhoneticDescription = (TextView)view.findViewById(R.id.page_phonetic_description);
        _pagePhoneticHelpButton = (ImageView)view.findViewById(R.id.page_phonetic_help_button);
        _pagePhoneticHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _pagePhoneticHelp.setVisibility(View.VISIBLE);
                _pagePhoneticHelpClose.setVisibility(View.VISIBLE);
                _pagePhoneticHelpButton.setVisibility(View.INVISIBLE);

                _pagePhoneticOefening.setVisibility(View.VISIBLE);
                _pagePhoneticTitle.setVisibility(View.VISIBLE);
                _pagePhoneticLeeftijd.setVisibility(View.VISIBLE);
                _pagePhoneticLeeftijdInfo.setVisibility(View.VISIBLE);
                _pagePhoneticDescription.setVisibility(View.VISIBLE);
            }
        });
        _pagePhoneticHelpClose = (TextView)view.findViewById(R.id.page_phonetic_help_close);
        _pagePhoneticHelpClose.setTypeface(typeface);
        _pagePhoneticHelpClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _pagePhoneticHelp.setVisibility(View.INVISIBLE);
                _pagePhoneticHelpClose.setVisibility(View.GONE);
                _pagePhoneticHelpButton.setVisibility(View.VISIBLE);

                _pagePhoneticOefening.setVisibility(View.INVISIBLE);
                _pagePhoneticTitle.setVisibility(View.INVISIBLE);
                _pagePhoneticLeeftijd.setVisibility(View.INVISIBLE);
                _pagePhoneticLeeftijdInfo.setVisibility(View.INVISIBLE);
                _pagePhoneticDescription.setVisibility(View.INVISIBLE);
            }
        });

        final MediaPlayer mpBee = MediaPlayer.create(getActivity(), R.raw.bee);
        final MediaPlayer mpSnake = MediaPlayer.create(getActivity(), R.raw.snake);
        _pagePhoneticInformation = (TextView)view.findViewById(R.id.page_phonetic_information);
        _pagePhoneticInformation.setTypeface(typeface);
        _pagePhoneticBee = (ImageView)view.findViewById(R.id.page_phonetic_bee);
        _pagePhoneticSnake = (ImageView)view.findViewById(R.id.page_phonetic_snake);
        _pagePhoneticBee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpBee.start();
                showText("zzzzzzzzzz");
            }
        });
        _pagePhoneticSnake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpSnake.start();
                showText("ssssssssss");
            }
        });


        _pagePhoneticBee.postDelayed(new BeeAnimation(), 2000);
        _pagePhoneticSnake.postDelayed(new SnakeAnimation(), 3000);

        return view;
    }

    private void showText(String text) {
        _pagePhoneticInformation.setVisibility(View.INVISIBLE);
        _pagePhoneticInformation.setText(text);
        _pagePhoneticInformation.setVisibility(View.VISIBLE);
    }

    private class BeeAnimation implements Runnable {
        @Override
        public void run() {
            _pagePhoneticBee.startAnimation(MainActivity.SHAKE_ANIMATION);
            _pagePhoneticBee.postDelayed(new BeeAnimation(), 2000);
        }
    }

    private class SnakeAnimation implements Runnable {
        @Override
        public void run() {
            _pagePhoneticSnake.startAnimation(MainActivity.SHAKE_ANIMATION);
            _pagePhoneticSnake.postDelayed(new SnakeAnimation(), 3000);
        }
    }
}
