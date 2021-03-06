//Copyright (c) 2017. 章钦豪. All rights reserved.
package com.monke.monkeybook.view.popupwindow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.monke.monkeybook.R;

public class CheckAddShelfPop extends PopupWindow{
    private Context mContext;
    private View view;

    public interface OnItemClickListener {
        void clickExit();
        void clickAddShelf();
    }
    private OnItemClickListener itemClick;
    private String bookName;

    private TextView tvBookName;
    private TextView tvExit;
    private TextView tvAddShelf;
    public CheckAddShelfPop(Context context,@NonNull String bookName,@NonNull OnItemClickListener itemClick){
        super(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        mContext = context;
        this.bookName = bookName;
        this.itemClick = itemClick;
        view = LayoutInflater.from(mContext).inflate(R.layout.moprogress_dialog_two,null);
        this.setContentView(view);

        initView();
        setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_pop_checkaddshelf_bg));
        setFocusable(true);
        setTouchable(true);
        setAnimationStyle(R.style.anim_pop_checkaddshelf);
    }

    private void initView() {
        tvBookName = view.findViewById(R.id.tv_msg);
        tvBookName.setText(String.format(mContext.getString(R.string.check_add_bookshelf),bookName));
        tvExit = view.findViewById(R.id.tv_cancel);
        tvExit.setText("退出阅读");
        tvExit.setOnClickListener(v -> {
            dismiss();
            itemClick.clickExit();
        });
        tvAddShelf = view.findViewById(R.id.tv_done);
        tvAddShelf.setText("放入书架");
        tvAddShelf.setOnClickListener(v -> itemClick.clickAddShelf());
    }
}
