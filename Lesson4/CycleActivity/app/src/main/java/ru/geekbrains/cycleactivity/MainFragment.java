package ru.geekbrains.cycleactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    private OnButtonClickListener listener;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button buttonClose = (Button) view.findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFragmentButtonClick();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MainFragment", "onActivityCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnButtonClickListener) {
            listener = (OnButtonClickListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MainFragment", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MainFragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MainFragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MainFragment", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MainFragment", "onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MainFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
        Log.d("MainFragment", "onDetach");
    }

    public interface OnButtonClickListener {
        void onFragmentButtonClick();
    }
}
