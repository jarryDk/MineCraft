package dk.jarry.minecraft;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    private SharedPreferences sharedpreferences;
    private TextView name;
    private TextView password;
    public static final String mypreference = "mypref";
    public static final String NAME = "nameKey";
    public static final String PASSWORD = "passwordKey";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
/**
        this.name = (TextView) view.findViewById(R.id.etName);
        this.password = (TextView) view.findViewById(R.id.etPassword);
        this.sharedpreferences = getContext().getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(NAME)) {
            this.name.setText(sharedpreferences.getString(NAME, ""));
        }
        if (sharedpreferences.contains(PASSWORD)) {
            this.password.setText(sharedpreferences.getString(PASSWORD, ""));
        }
 */
    }

    public void save(View view) {
        String n = name.getText().toString();
        String p = password.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(NAME, n);
        editor.putString(PASSWORD, p);
        editor.commit();
    }

    public void clear(View view) {
        name = (TextView) view.findViewById(R.id.etName);
        password = (TextView) view.findViewById(R.id.etPassword);
        name.setText("");
        password.setText("");
    }

    public void get(View view) {
        name = (TextView) view.findViewById(R.id.etName);
        password = (TextView) view.findViewById(R.id.etPassword);
        sharedpreferences = getContext().getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(NAME)) {
            name.setText(sharedpreferences.getString(NAME, ""));
        }
        if (sharedpreferences.contains(PASSWORD)) {
            password.setText(sharedpreferences.getString(PASSWORD, ""));
        }
    }
}