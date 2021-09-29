package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private List<String> dataList = new ArrayList<String>();

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
// Inflate the menu ; this adds items to the action bar
// if it is present .
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        setHasOptionsMenu(true);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyViewModel model = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // On récupére l'objet correspondant a inputnom
                EditText inputNom = getActivity().findViewById(R.id.Name);
                EditText inputPrenom = getActivity().findViewById(R.id.FirstName);
                EditText inputVille = getActivity().findViewById(R.id.Ville);
                //récupére le text a partir de l'objet
                String nom = inputNom.getText().toString();
                String prenom = inputPrenom.getText().toString();
                String ville = inputVille.getText().toString();

                dataList.add(nom);
                dataList.add(prenom);
                dataList.add(ville);
                model.loadInputs(dataList);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });


       /* binding.buttonFirst.setOnClickListener(view1 -> Toast.makeText(getActivity().getApplicationContext(),
                binding.Name.getText().toString() + " " +
                        binding.FirstName.getText().toString() + " " +
                        binding.editTextDate.getText().toString() + " " +
                        binding.editTextTextPersonName5.getText().toString()
                , Toast.LENGTH_SHORT).show());*/
    }

   /* public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.wiki:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/" + binding.editTextTextPersonName5.getText().toString()));
                startActivity(intent);
                break;

            case R.id.Set0:
                binding.editTextTextPersonName5.setText("");
                binding.Name.setText("");
                binding.editTextDate.setText("");
                binding.FirstName.setText("");
                break;
        }

        return false;
    } */

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}