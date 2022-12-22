package com.example.todoapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoapplication.R;
import com.example.todoapplication.data.entity.Kisiler;
import com.example.todoapplication.databinding.FragmentAnaSayfaBinding;
import com.example.todoapplication.ui.adapter.KisilerAdapter;
import com.example.todoapplication.ui.viewmodel.AnasayfaVievModel;
import com.example.todoapplication.ui.viewmodel.KisiDetayVievModel;

import java.io.Serializable;
import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnaSayfaFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentAnaSayfaBinding binding;
    private AnasayfaVievModel vievModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false);
        binding.setAnaSayfaFragment(this);
        binding.setAnaSayfaToolbarBaslik("Anasayfa");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarAnaSayfa);




        vievModel.kisilerListesi.observe(getViewLifecycleOwner(),liste ->{
            KisilerAdapter adapter = new KisilerAdapter(requireContext(),liste,vievModel);
            binding.setKisilerAdapter(adapter);

        });





        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(AnaSayfaFragment.this);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vievModel = new ViewModelProvider(this).get(AnasayfaVievModel.class);
    }

    public  void  fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        vievModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        vievModel.ara(newText);
        return true;
    }

    @Override
    public void onResume() {
            super.onResume();
            vievModel.kisilerYukle();
    }
}