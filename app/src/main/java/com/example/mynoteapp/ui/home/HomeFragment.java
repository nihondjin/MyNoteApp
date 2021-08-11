package com.example.mynoteapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mynoteapp.R;
import com.example.mynoteapp.adapter.NoteAdapter;
import com.example.mynoteapp.databinding.FragmentHomeBinding;
import com.example.mynoteapp.model.NoteModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    NoteAdapter adapter;
    private ArrayList<NoteModel> list = new ArrayList<>();
    public final static String BUNDLE_KEY = "SegodnyauMenyaJivotBolit";
    public final static String REQUEST_KEY = "iloveHaruko";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        getData();
        return root;
    }

    private void getData() {
        getParentFragmentManager().setFragmentResultListener(REQUEST_KEY, getViewLifecycleOwner(),
                ((requestKey, result) -> {
                    NoteModel noteModel = (NoteModel) result.getSerializable(BUNDLE_KEY);
                    list.add(noteModel);
                    adapter.addModel(noteModel);
                }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}