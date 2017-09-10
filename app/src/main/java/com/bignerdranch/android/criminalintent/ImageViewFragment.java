package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.Date;
import java.util.GregorianCalendar;

public class ImageViewFragment extends DialogFragment {
    private String filePath;
    private static final String KEY_PATH = "KEY_PATH";
    private ImageView imgView;
    public static ImageViewFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putString(KEY_PATH, path);
        ImageViewFragment fragment = new ImageViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image, null);
        filePath = getArguments().getString(KEY_PATH);
        imgView = (ImageView) v.findViewById(R.id.iv_dialog_image);

        Bitmap bitmap = PictureUtils.getScaledBitmap(filePath, getActivity());
        imgView.setImageBitmap(bitmap);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
