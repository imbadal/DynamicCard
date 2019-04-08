package com.example.assignmentconzumex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.assignmentconzumex.model.Data;
import com.example.assignmentconzumex.model.Elements;
import com.example.assignmentconzumex.model.ModelAssign;
import com.example.assignmentconzumex.model.Sections;
import com.example.assignmentconzumex.model.Value;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";
    ModelAssign modelAssign;

    RelativeLayout relativeLayout;
    CardView cardView;
    ImageView imageView;
    List<Sections> sectionsList;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.container);


        gson = new GsonBuilder()
                .registerTypeAdapter(Value.class, new Data.ValueDeserilizer())
                .create();
        try {
            InputStream inputStream = getAssets().open("data.json");
            modelAssign = gson.fromJson(new InputStreamReader(inputStream), ModelAssign.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(TAG, modelAssign.toString());

        sectionsList = modelAssign.getSections();
        Log.d(TAG, "sectionsList Size: " + sectionsList.size());

        for (Sections sections : sectionsList) {

            List<Elements> elementsList = sections.getElements();
            Log.d(TAG, "elementsList Size: " + elementsList.size());

            for (Elements elements : elementsList) {

                List<Data> dataList = elements.getData();
                Log.d(TAG, "dataList Size: " + dataList.size());

                for (Data data : dataList) {
                    Log.d(TAG, "Data: category " + data.getCategory());
                    Log.d(TAG, "Data: color " + data.getColor());
                    Log.d(TAG, "Data: fontName " + data.getFontName());
                }
            }
        }

        setUpLayout();

    }


    private List<Sections> getSectionsList() {

        return modelAssign.getSections();

    }

    private void setUpLayout() {
        LinearLayout linearLayout_p;
        LinearLayout linearLayout;
        RelativeLayout relativeLayout_c1;

        CardView cardView;
        TextView textView;
        TextView textView2;

        String data;

        RelativeLayout.LayoutParams params_relative_p = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams params_relative_f = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams params_relative_start = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params_relative_start.addRule(RelativeLayout.ALIGN_PARENT_START);

        RelativeLayout.LayoutParams params_relative_end = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params_relative_end.addRule(RelativeLayout.ALIGN_PARENT_END);


        RelativeLayout.LayoutParams params_relative_center = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );


        LinearLayout.LayoutParams params_linear = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );


        //add CardView
        cardView = new CardView(this);
        cardView.setRadius(16);
        cardView.setCardBackgroundColor(getResources().getColor(R.color.colorBalck));
        params_relative_p.setMargins(16, 16, 16, 16);
        cardView.setLayoutParams(params_relative_p);
        relativeLayout.addView(cardView);

        //child container layout to cardview

        linearLayout_p = new LinearLayout(this);
        linearLayout_p.setLayoutParams(params_relative_f);
        linearLayout_p.setOrientation(LinearLayout.VERTICAL);
        linearLayout_p.setPadding(16, 16, 16, 16);
        cardView.addView(linearLayout_p);


        //Add SectionHeader (row 1).........................................................................

        List<Elements> elementsList_h_1 = getElementsList("section_header_1");
        List<Elements> elementsList_m_img = getElementsList("section_middle_image");
        List<Elements> elementsList_m_desc = getElementsList("section_middle_description");
        List<Elements> elementsList_s_info = getElementsList("section_info");
        List<Elements> elementsList_f_btn = getElementsList("section_footer_button");

        relativeLayout_c1 = new RelativeLayout(this);
        relativeLayout_c1.setLayoutParams(params_relative_start);
        relativeLayout_c1.setPadding(16, 16, 16, 16);

        //first block

        linearLayout = new LinearLayout(this);
        params_relative_start.addRule(RelativeLayout.ALIGN_PARENT_START);
        linearLayout.setLayoutParams(params_relative_start);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //first block text1
        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear);
        data = elementsList_h_1.get(0).getData().get(0).getValue().getText();
        textView.setText(data);
        linearLayout.addView(textView);

        //first block text2
        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear);
        data = elementsList_h_1.get(2).getData().get(0).getValue().getText();

        textView.setText(getDate(data));
        linearLayout.addView(textView);

        //first block layout attach
        relativeLayout_c1.addView(linearLayout);

        //first block
        linearLayout = new LinearLayout(this);
        params_relative_end.addRule(RelativeLayout.ALIGN_PARENT_END);
        linearLayout.setLayoutParams(params_relative_end);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout linearLayout_h = new LinearLayout(this);
        linearLayout_h.setLayoutParams(params_linear);
        linearLayout_h.setOrientation(LinearLayout.HORIZONTAL);

        //second block text1

        imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(36, 36));
        imageView.setImageResource(R.drawable.ic_android_white_24dp);
        linearLayout_h.addView(imageView);

        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear);
        data = elementsList_h_1.get(1).getData().get(1).getValue().getText();
        textView.setText(data);

        linearLayout_h.addView(textView);

        linearLayout.addView(linearLayout_h);

        //second block text2
        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear);
        data = elementsList_h_1.get(3).getData().get(0).getValue().getText();
        textView.setText(data);
        linearLayout.addView(textView);

        //second block layout attach
        relativeLayout_c1.addView(linearLayout);

        //add layout to parent
        linearLayout_p.addView(relativeLayout_c1);

        //Add SectionMiddleImage (row 2)....................................................................

        RelativeLayout.LayoutParams params_relative_image = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                150
        );

        relativeLayout_c1 = new RelativeLayout(this);
        relativeLayout_c1.setLayoutParams(params_relative_image);
        relativeLayout_c1.setPadding(16, 16, 16, 16);
//        relativeLayout_c1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        //add layout to parent
        linearLayout_p.addView(relativeLayout_c1);

        //Add SectionMiddleDescription (row 3)....................................................................

        relativeLayout_c1 = new RelativeLayout(this);
        relativeLayout_c1.setLayoutParams(params_relative_f);
        relativeLayout_c1.setPadding(16, 16, 16, 16);

        linearLayout = new LinearLayout(this);
        params_relative_center.addRule(RelativeLayout.CENTER_IN_PARENT);
        linearLayout.setLayoutParams(params_relative_center);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        //first block text1

        imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(36, 36));
        imageView.setImageResource(R.drawable.ic_android_white_24dp);
        linearLayout.addView(imageView);

        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear);
        data = elementsList_m_desc.get(0).getData().get(1).getValue().getText();
        data += " " + elementsList_m_desc.get(0).getData().get(1).getValueType();
        textView.setText(data);
        linearLayout.addView(textView);

        relativeLayout_c1.addView(linearLayout);

        //add layout to parent
        linearLayout_p.addView(relativeLayout_c1);

        //Add SectionMiddleInfo (row 4)....................................................................

        LinearLayout.LayoutParams params_linear_center = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params_linear_center.weight = 1;
        params_linear_center.gravity = Gravity.CENTER_HORIZONTAL;

        LinearLayout linearLayout_c = new LinearLayout(this);
        linearLayout_c.setLayoutParams(params_relative_f);
        linearLayout_c.setPadding(16, 16, 16, 16);


        //left element

        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(params_linear_center);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //first block image
        imageView = new ImageView(this);
        imageView.setLayoutParams(params_linear_center);
        imageView.setImageResource(R.drawable.ic_android_white_24dp);
        linearLayout.addView(imageView);

        //second block text1
        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear_center);
        data = elementsList_s_info.get(0).getData().get(1).getValue().getText();
        int t = Integer.valueOf(Integer.valueOf(data) / 60);
        textView.setText(String.valueOf(t) + " MIN");
        linearLayout.addView(textView);

        linearLayout_c.addView(linearLayout);


        //center element

        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(params_linear_center);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //first block image
        imageView = new ImageView(this);
        imageView.setLayoutParams(params_linear_center);
        imageView.setImageResource(R.drawable.ic_android_white_24dp);
        linearLayout.addView(imageView);

        //second block text1
        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear_center);
        data = elementsList_s_info.get(1).getData().get(1).getValue().getText();
        double d = Double.valueOf(Double.valueOf(data) / 1000);
        textView.setText(String.valueOf(d) + " km");
        linearLayout.addView(textView);

        linearLayout_c.addView(linearLayout);


        //right element

        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(params_linear_center);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //first block image
        imageView = new ImageView(this);
        imageView.setLayoutParams(params_linear_center);
        imageView.setImageResource(R.drawable.ic_android_white_24dp);
        linearLayout.addView(imageView);

        //second block text1
        textView = new TextView(this);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        textView.setLayoutParams(params_linear_center);
        data = elementsList_s_info.get(2).getData().get(1).getValue().getText();
        textView.setText(data + " kmph");
        linearLayout.addView(textView);

        linearLayout_c.addView(linearLayout);

        //add layout to parent

        linearLayout_p.addView(linearLayout_c);


        //Add SectionMiddleInfo (row 4)....................................................................

        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(params_linear_center);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //first block image
        imageView = new ImageView(this);
        imageView.setLayoutParams(params_linear_center);
        imageView.setImageResource(R.drawable.ic_android_white_24dp);
        linearLayout.addView(imageView);

    }

    public List<Elements> getElementsList(String string) {

        if (sectionsList == null) {
            sectionsList = getSectionsList();
        }
        for (Sections sections : sectionsList) {
            if (sections.getSectionId().equals(string)) {
                return sections.getElements();
            }
        }
        return null;
    }


    public String getDate(String string) {

        String[] month_arr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};

        string = string.substring(0, 10);

        String year = string.substring(0, 4);
        int index = Integer.valueOf(string.substring(5, 7));
        String mon = month_arr[index - 1];
        String date = string.substring(8) + " " + mon + " " + year;

        Log.d("get_date_time", "getDate: " + date);

        return date;
    }

}
