package cn.org.metter.hitogether_android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import cn.org.metter.hitogether_android.R;

/**
 * Created by Administrator on 2015/12/22.
 */
public class InputView extends FrameLayout {

    private ImageView delBtn;

    private EditText editContent;

    private ImageView meanIcon;


    public InputView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_loginput, this);
        delBtn = (ImageView)findViewById(R.id.delBtn);
        editContent =(EditText)findViewById(R.id.edit_content);
        meanIcon = (ImageView)findViewById(R.id.meanIcon);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.InputAttrs);

        initView(ta,delBtn,editContent);

    }

    private void initView(TypedArray typedArray, final ImageView delBtn, final EditText editContent){

        meanIcon.setImageDrawable(typedArray.getDrawable(R.styleable.InputAttrs_picFor));
        editContent.setHint(typedArray.getString(R.styleable.InputAttrs_hintput));

        //if (typedArray.getString(R.styleable.InputAttrs_usefor).equals(2))


        editContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 0 || s.equals(null))
                    delBtn.setVisibility(INVISIBLE);
                else
                    delBtn.setVisibility(VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        delBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                editContent.setText(null);
                delBtn.setVisibility(INVISIBLE);
            }
        });

        typedArray.recycle();

    }


    public interface OnItemClickListener
    {
        public void onImageClick();
    }


}
