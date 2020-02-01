package com.example.app_3;

import android.os.Bundle;
import android.app.Activity;               // Imported this to include Activity class
import android.widget.RelativeLayout;      // Importing relative layout
import android.widget.Button;              // Importing button
import android.graphics.Color;              // Colors imported
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Edited code from here:
        RelativeLayout layout1= new RelativeLayout(this);
        Button button1=new Button(this);

        layout1.setBackgroundColor(Color.BLACK);            // These two lines Sets color
        button1.setBackgroundColor(Color.BLUE);
        button1.setText("Touch me");                        // This line set text in button1.

        RelativeLayout.LayoutParams button1_details= new RelativeLayout.LayoutParams(           // Button1_details object is created which is used to position button1.
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        button1_details.addRule(RelativeLayout.CENTER_HORIZONTAL);      // Horizontal alignment of button1
        button1_details.addRule(RelativeLayout.CENTER_VERTICAL);        // Vertical alignment of button1.

        EditText username=new EditText(this);
        username.setTextColor(Color.BLUE);
        button1.setId(1);
        username.setId(2);

        RelativeLayout.LayoutParams username_details= new RelativeLayout.LayoutParams(           //  object is created which is used to position username.
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        username_details.addRule(RelativeLayout.ABOVE,button1.getId());
        username_details.addRule(RelativeLayout.CENTER_HORIZONTAL);

        Resources r=getResources();             // This compile the resources associated with app.
       int  px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());   // It converts DIP in pixels. the third argument get display matrix of the phone which we use.
        username.setWidth(px);
        username_details.setMargins(0,0,0,50);

        layout1.addView(username,username_details);             // This is t add username. It must ne at last line to get rid of app failure.
        layout1.addView(button1,button1_details);             // This adds button to layout and must be written after giving all attributes to button. Otherwise App may creah if this line is exceuted above any attribute.
        // We can aslo put the above line of button after completing attributes for button.
        setContentView(layout1);

    }

}
