package com.example.sasannaderi.fragmenttransaction;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final static String FIRST_FRAGMENT = "fragment_one";
    private final static String SECOND_FRAGMENT = "fragment_two";
    private final static String THIRD_FRAGMENT = "fragment_three";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(R.id.fragment_one, FIRST_FRAGMENT);
        addFragment(R.id.fragment_two, SECOND_FRAGMENT);
        addFragment(R.id.fragment_three, THIRD_FRAGMENT);
    }

    @Override
    protected void onResume() {
        removeFragment(THIRD_FRAGMENT);

        super.onResume();
    }

    private void addFragment(int container, String tag) {
        DummyFragment fragment = new DummyFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(container, fragment, tag);
        ft.commit();
    }

    private void removeFragment(String tag) {
        Fragment fragment = getFragmentManager().findFragmentByTag(tag);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }
}
