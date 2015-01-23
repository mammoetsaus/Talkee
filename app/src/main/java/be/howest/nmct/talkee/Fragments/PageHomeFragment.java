package be.howest.nmct.talkee.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import be.howest.nmct.talkee.MainActivity;
import be.howest.nmct.talkee.R;

public class PageHomeFragment extends Fragment {
    private ImageView _pageHomeTalkee;
    private ImageView _pageHomeSpeechBubble;
    private TextView _pageHomeExplanation1;
    private TextView _pageHomeExplanation2;
    private TextView _pageHomeExplanation3;
    private TextView _pageHomeExplanation4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.page_home, container, false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/PoetsenOne.ttf");

        _pageHomeTalkee = (ImageView)view.findViewById(R.id.page_home_talkee);
        _pageHomeSpeechBubble = (ImageView)view.findViewById(R.id.page_home_speech_bubble);
        _pageHomeExplanation1 = (TextView)view.findViewById(R.id.page_home_explanation_1);
        _pageHomeExplanation2 = (TextView)view.findViewById(R.id.page_home_explanation_2);
        _pageHomeExplanation3 = (TextView)view.findViewById(R.id.page_home_explanation_3);
        _pageHomeExplanation4 = (TextView)view.findViewById(R.id.page_home_explanation_4);
        _pageHomeExplanation1.setTypeface(typeface);
        _pageHomeExplanation2.setTypeface(typeface);
        _pageHomeExplanation3.setTypeface(typeface);
        _pageHomeExplanation4.setTypeface(typeface);

        _pageHomeTalkee.setOnClickListener(new View.OnClickListener() {
            Boolean switched = true;
            @Override
            public void onClick(View v) {
                if (switched) {
                    _pageHomeSpeechBubble.setVisibility(View.VISIBLE);
                    _pageHomeExplanation1.setVisibility(View.VISIBLE);
                    _pageHomeExplanation2.setVisibility(View.VISIBLE);
                    _pageHomeExplanation3.setVisibility(View.VISIBLE);
                    _pageHomeExplanation4.setVisibility(View.VISIBLE);
                }
                else {
                    _pageHomeSpeechBubble.setVisibility(View.INVISIBLE);
                    _pageHomeExplanation1.setVisibility(View.INVISIBLE);
                    _pageHomeExplanation2.setVisibility(View.INVISIBLE);
                    _pageHomeExplanation3.setVisibility(View.INVISIBLE);
                    _pageHomeExplanation4.setVisibility(View.INVISIBLE);
                }

                switched = !switched;
            }
        });

        _pageHomeTalkee.postDelayed(new ShakeTalkeeAnimation(), 3000);


        return view;
    }

    private class ShakeTalkeeAnimation implements Runnable {
        @Override
        public void run() {
            _pageHomeTalkee.startAnimation(MainActivity.SHAKE_ANIMATION);
            _pageHomeTalkee.postDelayed(new ShakeTalkeeAnimation(), 3000);
        }
    }
}
