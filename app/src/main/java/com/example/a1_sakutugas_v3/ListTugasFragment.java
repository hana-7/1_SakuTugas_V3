package com.example.a1_sakutugas_v3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTugasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTugasFragment extends Fragment implements ListTugasAdapter.ItemClickListener{
    private List<ListTugas> listTugasList;
//    private RecyclerView recyclerView;
    private ListTugasAdapter listTugasAdapter;
    private ListTugasViewModel mListTugasViewModel;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public static final int DETAIL_WORD_ACTIVITY_REQUEST_CODE = 2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListTugasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTugasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTugasFragment newInstance(String param1, String param2) {
        ListTugasFragment fragment = new ListTugasFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_tugas, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        listTugasAdapter = new ListTugasAdapter(new ListTugasAdapter.ListTugasDiff());
        recyclerView.setAdapter(listTugasAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mListTugasViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(ListTugasViewModel.class);
        mListTugasViewModel.getAllListTugas().observe(getViewLifecycleOwner(), listTugas -> {
            // Update the cached copy of the words in the adapter.
            listTugasList = listTugas;
            listTugasAdapter.submitList(listTugas);
        });

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener( View -> {
            Intent intent = new Intent(getContext(), TambahTugas.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            ListTugas listTugas = new ListTugas(
                    data.getStringExtra("tugas"),
                    data.getStringExtra("tanggal"),
                    data.getStringExtra("keterangan")
            );
            mListTugasViewModel.insert(listTugas);
            Toast.makeText(
                    getContext(),
                    R.string.data_success_saved,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(
                    getContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this.getContext(), ItemDetailActivity.class);
        Bundle bundle = new Bundle();

//        bundle.putString("index", String.valueOf(position));
        bundle.putString("tugas", listTugasList.get(position).getTugas());
        bundle.putString("tanggal", listTugasList.get(position).getTanggal());
        bundle.putString("keterangan", listTugasList.get(position).getKeterangan());
        intent.putExtras(bundle);

        startActivity(intent);
//        startActivityForResult(intent, DETAIL_WORD_ACTIVITY_REQUEST_CODE);
    }
}