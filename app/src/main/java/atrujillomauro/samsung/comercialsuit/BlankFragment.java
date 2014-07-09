package atrujillomauro.samsung.comercialsuit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public BlankFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BlankFragment newInstance(int sectionNumber) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        return rootView;
    }

}
