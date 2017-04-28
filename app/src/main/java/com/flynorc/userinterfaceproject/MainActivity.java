package com.flynorc.userinterfaceproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /*
         * adding the link to open google maps (or other app that can handle ACTION_VIEW intents) manually
         * since the autoLink was not picking up the address
         */
        //adding the underline to the textView
        final TextView addressView = (TextView) findViewById(R.id.address_view);
        SpannableString spanStr = new SpannableString(addressView.getText().toString());
        spanStr.setSpan(new UnderlineSpan(), 0, spanStr.length(), 0);
        addressView.setText(spanStr);

        //adding the onClickListener to start the intent
        addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                        +addressView.getText().toString()));
                startActivity(geoIntent);
            }
        });
    }
}
