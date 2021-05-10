package com.example.mynotes;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mynotes.domain.Note;

public class MainActivity extends AppCompatActivity implements ListFragment.OnNoteClicked, PublisherHolder {

    private Publisher publisher = new Publisher();

    private boolean isLandscape = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (!isLandscape) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            Fragment fragment = fragmentManager.findFragmentById(R.id.container);

            if (fragment == null) {

                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ListFragment())
                        .commit();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onNoteClicked(Note note) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (isLandscape) {

            fragmentManager.beginTransaction()
                    .replace(R.id.details_fragment, DetailsFragment.newInstance(note))
                    .commit();
        } else {

            fragmentManager.beginTransaction()
                    .replace(R.id.container, DetailsFragment.newInstance(note))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}