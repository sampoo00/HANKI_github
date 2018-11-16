package com.hanki.hanki.NavigationBar.MyReview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

public class MyReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<MyReview> myReviewList;

    public MyReviewAdapter(Context context, ArrayList<MyReview> myReviewList) {
        this.context = context;
        this.myReviewList = myReviewList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_my_review_item, parent, false);
        return new MyReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyReviewAdapter.MyReviewViewHolder viewHolder = (MyReviewViewHolder) holder;

        MyReview myReview = myReviewList.get(position);
        viewHolder.review_shopName.setText(myReview.shopName);
        viewHolder.review_nickname.setText(myReview.userName);
        viewHolder.review_date.setText(myReview.writeDate);
//        viewHolder.review_content.setText(myReview.review);

        Glide.with(context).load(myReview.userImage).into(viewHolder.review_profile);
        viewHolder.review_rating.setRating(myReview.userScore);
    }

    @Override
    public int getItemCount() {
        return myReviewList.size();
    }

    public class MyReviewViewHolder extends RecyclerView.ViewHolder {

        TextView review_shopName;
        CircleImageView review_profile;
        TextView review_nickname;
        RatingBar review_rating;
        TextView review_date;
        TextView review_content;

        ImageButton review_modifyBtn;
        ImageButton review_deleteBtn;

        public MyReviewViewHolder(View itemView) {
            super(itemView);

            review_shopName = (TextView) itemView.findViewById(R.id.review_shopName);
            review_nickname = (TextView) itemView.findViewById(R.id.review_nickname);
            review_date = (TextView) itemView.findViewById(R.id.review_date);
            review_content = (TextView) itemView.findViewById(R.id.review_content);
            review_profile = (CircleImageView) itemView.findViewById(R.id.review_profile);
            review_rating = (RatingBar) itemView.findViewById(R.id.review_rating);
            review_modifyBtn = (ImageButton) itemView.findViewById(R.id.review_modifyBtn);
            review_deleteBtn = (ImageButton) itemView.findViewById(R.id.review_deleteBtn);

            review_deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final PrettyDialog deleteDialog = new PrettyDialog(context);
                    deleteDialog.setMessage("리뷰를 삭제하시겠습니까?")
                            .setIcon(R.drawable.pdlg_icon_info)
                            .setIconTint(R.color.colorPrimary)
                            .addButton("확인",
                                    R.color.pdlg_color_white,
                                    R.color.colorPrimary,
                                    new PrettyDialogCallback() {
                                        @Override
                                        public void onClick() {
                                            deleteDialog.dismiss();
                                        }
                                    })
                            .setCanceledOnTouchOutside(false);
                    deleteDialog.show();
                }
            });
        }
    }
}
