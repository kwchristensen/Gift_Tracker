package com.example.gift_tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GiftTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GiftTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String DEBUG_LOG = "gTabLog";
    ArrayList<Gift> gifts;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;



    public GiftTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiftTab.
     */
    // TODO: Rename and change types and number of parameters
    public static GiftTab newInstance(String param1, String param2) {
        GiftTab fragment = new GiftTab();
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
        } else {

            gifts = new ArrayList<>();

            /*Gift gift1 = new Gift(1, "Phone", "Pixel 4");
            gifts.add(gift1);

            Gift gift2 = new Gift(1, "TV", "TLV 65");
            gifts.add(gift2);

            Gift gift3 = new Gift(1, "Laptop", "Lenovo ideaPad");
            gifts.add(gift3);

            Gift gift4 = new Gift(1, "Phone", "Pixel 4");
            gifts.add(gift4);

            Gift gift5 = new Gift(1, "TV", "TLV 65");
            gifts.add(gift5);

            Gift gift6 = new Gift(1, "Laptop", "Lenovo ideaPad");
            gifts.add(gift6);

            Gift gift7 = new Gift(1, "Phone", "Pixel 4");
            gifts.add(gift7);

            Gift gift8 = new Gift(1, "TV", "TLV 65");
            gifts.add(gift8);

            Gift gift9 = new Gift(1, "Laptop", "Lenovo ideaPad");
            gifts.add(gift9);*/

            createGiftList();
            adapter = new GiftRecyclerAdapter(gifts, getActivity());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gift_tab, container, false);

        recyclerView = view.findViewById(R.id.giftRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void updateGiftList() {
        recyclerView = this.getActivity().findViewById(R.id.giftRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);

        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());

        gifts.add(db.getGift(db.getGiftCount()));
        adapter.notifyItemInserted(db.getGiftCount());
    }

    private void createGiftList() {
        gifts = new ArrayList<>();
        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());

        gifts = db.getAllGifts();
    }

    private void deleteAllGiftsFromDb() {
        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());
        db.deleteAllGiftRecords();
    }
}