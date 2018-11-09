package com.hanki.hanki.Review;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanki.hanki.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<ReviewData> reviewList;

    public ReviewAdapter(Context context, ArrayList<ReviewData> reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_review_item, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ReviewViewHolder reviewViewHolder = (ReviewViewHolder) holder;
        Glide.with(context).load(R.drawable.profile).into(reviewViewHolder.review_profile);
        reviewViewHolder.review_nickname.setText(reviewList.get(position).userEmail);
        reviewViewHolder.review_rating.setRating(reviewList.get(position).userScore);
        reviewViewHolder.review_date.setText(reviewList.get(position).writeDate);
        reviewViewHolder.review_content.setText(reviewList.get(position).review);
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        ImageView review_profile;
        TextView review_nickname;
        RatingBar review_rating;
        TextView review_date;
        TextView review_content;

        public ReviewViewHolder(View itemView) {
            super(itemView);
            review_profile = (ImageView) itemView.findViewById(R.id.review_profile);
            review_nickname = (TextView) itemView.findViewById(R.id.review_nickname);
            review_rating = (RatingBar) itemView.findViewById(R.id.review_rating);
            review_date = (TextView) itemView.findViewById(R.id.review_date);
            review_content = (TextView) itemView.findViewById(R.id.review_content);
        }
    }
}
