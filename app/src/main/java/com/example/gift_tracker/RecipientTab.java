package com.example.gift_tracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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

    private String DEBUG_LOG = "rTabLog";
    ArrayList<Recipient> recipients;

    private RecyclerView recyclerView;
    private RecipientRecyclerAdapter adapter;
    //private RecyclerView.Adapter adapter;



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

        Log.d(DEBUG_LOG, "OnCreate Running");

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        } else {
            Log.d(DEBUG_LOG, "getArguments == null");

            // Clean db for testing
            deleteAllRecipientsFromDb();

            createRecipientList();
            adapter = new RecipientRecyclerAdapter(recipients, getActivity());

            //Log.d(DEBUG_LOG, "Total records:" + adapter.getItemCount());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipient_tab, container, false);

        recyclerView = view.findViewById(R.id.recipientRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;

        //return inflater.inflate(R.layout.fragment_recipient_tab, container, false);
    }

    public void updateRecipientList(){

        // ugly but it works
        recyclerView = this.getActivity().findViewById(R.id.recipientRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);

        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());

        Log.d("test", "RecipientTab Refresh, adapter size:" + adapter.getItemCount() + ", db count:" + db.getRecipientCount());

        recipients.add(db.getRecipient(db.getRecipientCount()));
        adapter.notifyItemInserted(db.getRecipientCount());

        Log.d("test", "RecipientTab Refresh, adapter size:" + adapter.getItemCount() + ", db count:" + db.getRecipientCount());
    }

    private void createRecipientList() {

        recipients = new ArrayList<>();
        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());

        recipients = db.getAllRecipients();
    }

    private void deleteAllRecipientsFromDb() {
        DatabaseHelper db = DatabaseHelper.getInstance(getActivity());
        db.deleteAllRecipientRecords();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //recyclerView = (RecyclerView) view.findViewById(R.id.recyclerLayout);
        //layout = new LinearLayoutManager(getActivity());
        //recyclerView.setLayoutManager(layout);

        //recyclerView.setAdapter(adapter);

        //RecyclerView recyclerView = view.findViewById(R.id.recyclerLayout);
        //RecipientRecyclerAdapter adapter = new RecipientRecyclerAdapter(recipients, view.getContext());
        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}