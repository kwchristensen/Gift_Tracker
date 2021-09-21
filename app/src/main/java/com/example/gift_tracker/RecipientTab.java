package com.example.gift_tracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipientTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipientTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipientTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipientTab.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipientTab newInstance(String param1, String param2) {
        RecipientTab fragment = new RecipientTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipient_tab, container, false);

        List<Recipient> recipients = new List<Recipient>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Recipient> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Recipient recipient) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Recipient> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Recipient> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Recipient get(int i) {
                return null;
            }

            @Override
            public Recipient set(int i, Recipient recipient) {
                return null;
            }

            @Override
            public void add(int i, Recipient recipient) {

            }

            @Override
            public Recipient remove(int i) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Recipient> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Recipient> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Recipient> subList(int i, int i1) {
                return null;
            }
        };

        Recipient recipient1 = new Recipient(1, "Kyle");
        recipients.add(recipient1);

        Recipient recipient2 = new Recipient(2, "Foo");
        recipients.add(recipient2);

        Recipient recipient3 = new Recipient(3, "Bar");
        recipients.add(recipient3);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerLayout);
        RecipientRecyclerAdapter adapter = new RecipientRecyclerAdapter(recipients, super.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(super.getContext()));

        return view;
    }
}