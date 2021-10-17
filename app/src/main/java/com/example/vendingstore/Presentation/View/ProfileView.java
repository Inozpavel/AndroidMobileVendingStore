package com.example.vendingstore.Presentation.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vendingstore.Presentation.Network.EmailValidation;
import com.example.vendingstore.Presentation.ViewModel.ProfileViewModel;
import com.example.vendingstore.R;
import com.example.vendingstore.databinding.FragmentProfileBinding;

public class ProfileView extends Fragment
{
    private FragmentProfileBinding binding;
    private ProfileViewModel viewModel;

    private final String userImageKey = "user_profile_image_uri";
    private final String userEmailKey = "user_profile_email";
    private final String sharedPreferencesKey = "com.example.vendingstore";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentProfileBinding.inflate(getLayoutInflater(), container, false);

        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);


        Activity activity = getActivity();

        if (activity != null)
        {

            SharedPreferences preferences = activity.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE);

            String image = preferences.getString(userImageKey, null);
            if (image != null)
            {
                binding.imageViewUser.setImageURI(Uri.parse(image));
            } else
            {
                binding.imageViewUser.setImageResource(R.drawable.nophoto);
            }

            String email = preferences.getString(userEmailKey, null);

            if (email != null)
            {
                binding.editTextEmail.setText(email, TextView.BufferType.EDITABLE);
            }
        }

        binding.buttonSaveChanges.setVisibility(View.INVISIBLE);
        binding.buttonSaveChanges.setOnClickListener(this::buttonSaveClicked);

        viewModel.getUser().observe(getViewLifecycleOwner(), user ->
        {
            binding.textViewUsername.setText(user.getFirstName() + " " + user.getLastName());
            binding.textViewPhone.setText(user.getPhone());
            binding.textViewDateOfBirth.setText(user.getBirthDate().toString());
        });

        binding.imageViewUser.setOnClickListener(this::profileImageClicked);


        binding.editTextEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String currentEmail = binding.editTextEmail.getText().toString();
                String currentSavedEmail = viewModel.getUser().getValue().getEmail();
                if (!currentSavedEmail.equals(currentEmail))
                {
                    binding.buttonSaveChanges.setVisibility(View.VISIBLE);
                } else
                {
                    binding.buttonSaveChanges.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }

    private void buttonSaveClicked(View v)
    {
        String currentEmail = binding.editTextEmail.getText().toString();
        if (viewModel.getValidatedEmail() != null && viewModel.getValidatedEmail().equals(currentEmail))
        {
            Toast.makeText(getActivity(),
                    "Почта некорректна, сначала измените ее!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        EmailValidation emailValidation = new EmailValidation();
        emailValidation.ValidateEmail(currentEmail).observe(getViewLifecycleOwner(), isValid ->
        {
            if (isValid)
            {
                binding.buttonSaveChanges.setVisibility(View.INVISIBLE);

                Activity activity = getActivity();

                if (activity != null)
                {
                    SharedPreferences preferences = activity
                            .getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE);
                    if (preferences != null)
                    {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(userEmailKey, binding.editTextEmail.getText().toString());
                        editor.apply();
                        Toast.makeText(
                                getActivity(),
                                "Изменения успешно сохранены!",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(
                            getActivity(),
                            "Что-то пошло не так, не получилось сохранить изменения",
                            Toast.LENGTH_SHORT).show();
                }
            } else
            {
                viewModel.setValidatedEmail(binding.editTextEmail.getText().toString());
                Toast.makeText(getActivity(), "Почта некорректна!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void profileImageClicked(View v)
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

    }
}