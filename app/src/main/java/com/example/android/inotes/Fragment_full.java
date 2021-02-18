package com.example.android.inotes;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_full extends Fragment {

    public static final String ARG_NOTE = "note";
    private static Note note;

    public static Fragment_full newInstance(Note city) {
        Fragment_full f = new Fragment_full();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full, container, false);
        // найти в контейнере элемент-изображение
        AppCompatTextView textNotes = view.findViewById(R.id.text);
        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray text = getResources().obtainTypedArray(R.array.text);
        // Выбрать по индексу подходящий
        textNotes.setBackgroundResource(text.getResourceId(note.getTextIndex(), -1));
        // Установить название города
        TextView noteNameView = view.findViewById(R.id.notes);
        noteNameView.setText(note.getNoteName());
        return view;
    }
}