package com.example.vendingstore.Presentation.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vendingstore.Presentation.ViewModel.ProfileViewModel;
import com.example.vendingstore.R;
import com.example.vendingstore.databinding.FragmentProfileBinding;

public class ProfileView extends Fragment
{
    private FragmentProfileBinding binding;
    private ProfileViewModel viewModel;

    private final String userImageKey = "user_profile_image_uri";
    private final String sharedPreferencesKey = "com.example.vendingstore";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentProfileBinding.inflate(getLayoutInflater(), container, false);

        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        Activity activity = getActivity();

        if (activity != null)
        {

            String image = activity.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
                    .getString(userImageKey, null);

            if (image != null)
            {
                binding.imageViewUser.setImageURI(Uri.parse(image));
            } else
            {
                binding.imageViewUser.setImageResource(R.drawable.nophoto);
            }
        }


        viewModel.getUser().observe(getViewLifecycleOwner(), user ->
        {
            binding.textViewUsername.setText(user.getFirstName() + " " + user.getLastName());
            binding.textViewPhone.setText(user.getPhone());
            binding.textViewEmail.setText(user.getEmail());
            binding.textViewDateOfBirth.setText(user.getBirthDate().toString());
        });

        binding.imageViewUser.setOnClickListener(v ->
        {
            Activity mainActivity = getActivity();
            getActivity().getActivityResultRegistry().register("key",
                    new ActivityResultContracts.OpenDocument(), result ->
                    {
                        if (result == null)
                        {
                            return;
                        }

                        mainActivity.getApplicationContext().getContentResolver().takePersistableUriPermission(
                                result,
                                Intent.FLAG_GRANT_READ_URI_PERMISSION);

                        Uri uri = Uri.parse(result.toString());
                        binding.imageViewUser.setImageURI(uri);


                        SharedPreferences sharedPreferences = getActivity()
                                .getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(userImageKey, result.toString());
                        editor.apply();

                    }).launch(new String[]{"image/*"});

        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}