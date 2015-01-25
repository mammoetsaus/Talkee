package be.howest.nmct.talkee.Fragments;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

import be.howest.nmct.talkee.MainActivity;
import be.howest.nmct.talkee.R;

public class PageOrientedFragment extends Fragment {
    private ImageView _pageOrientedHelp;
    private ImageView _pageOrientedHelpButton;
    private TextView _pageOrientedHelpClose;
    private TextView _pageOrientedOefening;
    private TextView _pageOrientedTitle;
    private TextView _pageOrientedLeeftijd;
    private TextView _pageOrientedLeeftijdInfo;
    private TextView _pageOrientedDescription;

    private ImageView _pageOrientedPlaySound;
    private ImageView _pageOrientedLionSpace;
    private TextView _pageOrientedLionText;

    private Boolean isLionAvailable = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.page_oriented, container, false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PoetsenOne.ttf");

        _pageOrientedHelp = (ImageView)view.findViewById(R.id.page_oriented_help);
        _pageOrientedTitle = (TextView)view.findViewById(R.id.page_oriented_title);
        _pageOrientedTitle.setTypeface(typeface);
        _pageOrientedLeeftijdInfo = (TextView)view.findViewById(R.id.page_oriented_leeftijd_info);
        _pageOrientedLeeftijdInfo.setTypeface(typeface);
        _pageOrientedOefening = (TextView)view.findViewById(R.id.page_oriented_oefening);
        _pageOrientedLeeftijd = (TextView)view.findViewById(R.id.page_oriented_leeftijd);
        _pageOrientedDescription = (TextView)view.findViewById(R.id.page_oriented_description);
        _pageOrientedHelpButton = (ImageView)view.findViewById(R.id.page_oriented_help_button);
        _pageOrientedHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _pageOrientedHelp.setVisibility(View.VISIBLE);
                _pageOrientedHelpClose.setVisibility(View.VISIBLE);
                _pageOrientedHelpButton.setVisibility(View.INVISIBLE);

                _pageOrientedOefening.setVisibility(View.VISIBLE);
                _pageOrientedTitle.setVisibility(View.VISIBLE);
                _pageOrientedLeeftijd.setVisibility(View.VISIBLE);
                _pageOrientedLeeftijdInfo.setVisibility(View.VISIBLE);
                _pageOrientedDescription.setVisibility(View.VISIBLE);
            }
        });
        _pageOrientedHelpClose = (TextView)view.findViewById(R.id.page_oriented_help_close);
        _pageOrientedHelpClose.setTypeface(typeface);
        _pageOrientedHelpClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _pageOrientedHelp.setVisibility(View.INVISIBLE);
                _pageOrientedHelpClose.setVisibility(View.GONE);
                _pageOrientedHelpButton.setVisibility(View.VISIBLE);

                _pageOrientedOefening.setVisibility(View.INVISIBLE);
                _pageOrientedTitle.setVisibility(View.INVISIBLE);
                _pageOrientedLeeftijd.setVisibility(View.INVISIBLE);
                _pageOrientedLeeftijdInfo.setVisibility(View.INVISIBLE);
                _pageOrientedDescription.setVisibility(View.INVISIBLE);
            }
        });

        _pageOrientedLionText = (TextView)view.findViewById(R.id.page_oriented_lion_text);
        _pageOrientedLionText.setTypeface(typeface);

        final MediaPlayer mpLion = MediaPlayer.create(getActivity(), R.raw.lion);
        final MediaPlayer mpLevel = MediaPlayer.create(getActivity(), R.raw.level);
        _pageOrientedLionSpace = (ImageView)view.findViewById(R.id.page_oriented_lion_space);
        _pageOrientedLionSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLionAvailable) {
                    isLionAvailable = false;
                    _pageOrientedLionSpace.setClickable(false);
                    mpLevel.start();

                    _pageOrientedLionText.setVisibility(View.VISIBLE);
                    _pageOrientedLionText.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            _pageOrientedLionText.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                }
            }
        });


        _pageOrientedPlaySound = (ImageView)view.findViewById(R.id.page_oriented_play_sound);
        _pageOrientedPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLionAvailable = true;
                mpLion.start();
                _pageOrientedLionSpace.setClickable(true);
            }
        });

        return view;
    }
}
