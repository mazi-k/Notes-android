package com.example.mynotes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynotes.domain.Note;

public class DetailsFragment extends Fragment implements Observer {

    private static final String ARG_NOTE = "ARG_NOTE";
    private TextView title;
    private TextView sub;
    private TextView date;

    public DetailsFragment() {

    }

    public static DetailsFragment newInstance(Note note) {
        DetailsFragment fragment = new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);

        fragment.setArguments(bundle);
        return fragment;
    }

    private Publisher publisher;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();
            publisher.addObserver(this);
        }
    }

    @Override
    public void onDetach() {
        if (publisher != null) {
            publisher.removeObserver(this);
        }
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.title);
        sub = view.findViewById(R.id.subscription);
        date = view.findViewById(R.id.date);

        Note note = getArguments().getParcelable(ARG_NOTE);

        title.setText(note.getTitle());
        sub.setText(note.getSubscription());
        date.setText(note.getDate());
    }

    @Override
    public void updateNote(Note note) {
        title.setText(note.getTitle());
        sub.setText(note.getSubscription());
        date.setText(note.getDate());
    }
}
