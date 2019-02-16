package com.mateusrovari.flipanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreditCardActivity extends AppCompatActivity {

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private AnimatorSet mSetLeftOut;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;

    private AnimatorSet mSetRightCardOut;
    private AnimatorSet mSetRightCardIn;
    private AnimatorSet mSetLeftCardOut;
    private AnimatorSet mSetLeftCardIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
        findViews();
        loadAnimations();
        changeCameraDistance();
    }

    private void changeCameraDistance() {
        int distance = 15000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

//    private void loadAnimations() {
//        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
//        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
//    }

    private void loadAnimations() {

        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);

        mSetRightCardOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_flip_right_out);
        mSetRightCardIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_flip_right_in);

        mSetLeftCardOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_flip_left_out);
        mSetLeftCardIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_flip_left_in);
    }

    private void findViews() {
        mCardBackLayout = findViewById(R.id.credit_card_back);
        mCardFrontLayout = findViewById(R.id.credit_card_front);
    }

    public void flipCard(View view) {
        if (!mIsBackVisible) {
            mSetLeftCardIn.setTarget(mCardBackLayout);
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftCardIn.start();
            mSetRightOut.start();
            mIsBackVisible = true;
        } else {
            mSetLeftCardIn.setTarget(mCardFrontLayout);
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftCardIn.start();
            mSetRightOut.start();
            mIsBackVisible = false;
        }
    }

//    public void flipCard(View view) {
//        if (!mIsBackVisible) {
//            mSetRightOut.setTarget(mCardFrontLayout);
//            mSetLeftIn.setTarget(mCardBackLayout);
//            mSetRightOut.start();
//            mSetLeftIn.start();
//            mIsBackVisible = true;
//        } else {
//            mSetRightOut.setTarget(mCardBackLayout);
//            mSetLeftIn.setTarget(mCardFrontLayout);
//            mSetRightOut.start();
//            mSetLeftIn.start();
//            mIsBackVisible = false;
//        }
//    }

    /**
     * this is for the same direction always
     * @param view
     */
//    public void flipCard(View view) {
//        if (!mIsBackVisible) {
//            mSetLeftCardIn.setTarget(mCardBackLayout);
//            mSetRightOut.setTarget(mCardFrontLayout);
//            mSetLeftCardIn.start();
//            mSetRightOut.start();
//            mIsBackVisible = true;
//        } else {
//            mSetLeftCardIn.setTarget(mCardFrontLayout);
//            mSetRightOut.setTarget(mCardBackLayout);
//            mSetLeftCardIn.start();
//            mSetRightOut.start();
//            mIsBackVisible = false;
//        }
//    }

    /**
     * to different directions
     * @param view
     */
//    public void flipCard(View view) {
//        if (!mIsBackVisible) {
//            mSetLeftCardIn.setTarget(mCardBackLayout);
//            mSetRightOut.setTarget(mCardFrontLayout);
//            mSetLeftCardIn.start();
//            mSetRightOut.start();
//            mIsBackVisible = true;
//        } else {
//            mSetRightCardIn.setTarget(mCardFrontLayout);
//            mSetLeftIn.setTarget(mCardBackLayout);          //mSetLeftIn - mSetLeftCardOut - mSetLeftCardIn - mSetRightOut
//            mSetRightCardIn.start();
//            mSetLeftIn.start();
//            mIsBackVisible = false;
//        }
//    }
}
