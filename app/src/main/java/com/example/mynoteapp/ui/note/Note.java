package com.example.mynoteapp.ui.note;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynoteapp.R;
import com.example.mynoteapp.databinding.FragmentNoteBinding;
import com.example.mynoteapp.model.NoteModel;

import static com.example.mynoteapp.ui.home.HomeFragment.BUNDLE_KEY;
import static com.example.mynoteapp.ui.home.HomeFragment.REQUEST_KEY;


public class Note extends Fragment {

   FragmentNoteBinding binding;
   NoteModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    binding = FragmentNoteBinding.inflate(inflater, container, false);
        setOnClicklistener();
        close();

        return binding.getRoot();
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    }

    private void setOnClicklistener() {
        binding.btnComplete.setOnClickListener(v -> {
          String tit = binding.etNoteFragment.getText().toString().trim();
            Bundle bundle = new Bundle();
            model = new NoteModel(tit);
            bundle.putSerializable(BUNDLE_KEY, model);
            getParentFragmentManager().setFragmentResult(REQUEST_KEY, bundle);
            close();
        });

    }

}