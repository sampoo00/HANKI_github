package com.hanki.hanki.ShopOrder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanki.hanki.R;
import com.hanki.hanki.Review.ReviewAdapter;
import com.hanki.hanki.Review.ReviewData;
import com.hanki.hanki.Review.WriteReviewActivity;

import java.util.ArrayList;

public class Fragment_reviews extends Fragment implements View.OnClickListener {

    RecyclerView reviewListRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_main_fragment_reviews, container, false);
        RelativeLayout writeReviewButton = (RelativeLayout) view.findViewById(R.id.writeReviewButton);
        ImageView pencil = (ImageView) view.findViewById(R.id.pencil);
        TextView writeReview = (TextView) view.findViewById(R.id.writeReview);

        writeReviewButton.setOnClickListener(this);
        pencil.setOnClickListener(this);
        writeReview.setOnClickListener(this);

        reviewListRecyclerView = (RecyclerView) view.findViewById(R.id.reviewListRecyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<ReviewData> reviewList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            reviewList.add(new ReviewData("김행키", "놀부 부대찌개", 3, "2018.11.09", "맛있어요. 그런데 햄이 조금 더 많았으면 좋겠어요ㅎㅎ"));
        }
        reviewListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ReviewAdapter reviewAdapter = new ReviewAdapter(getContext(), reviewList);
        reviewListRecyclerView.setAdapter(reviewAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.writeReviewButton:
            case R.id.pencil:
            case R.id.writeReview:
                Intent intent = new Intent(getActivity(), WriteReviewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
