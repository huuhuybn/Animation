package vn.edu.poly.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imgObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgObj = findViewById(R.id.imgObj);



        // Property Animation
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgObj,
                "rotation", 0, 500);

        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatCount(5);

        // di chuyen lien tuc 5 lan va dao nguoc
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
        //objectAnimator.start();



        Animator animator = AnimatorInflater.loadAnimator(this,
                R.animator.my_animation);


        animator.setTarget(imgObj);

        animator.start();

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.woman_scream);

        try {
            mPlayer.start();
        } catch (Exception e) {
// handle this later
        }



        // drawable animation

        imgObj.setImageResource(R.drawable.anabella);

        AnimationDrawable animationDrawable =
                (AnimationDrawable) imgObj.getDrawable();

        animationDrawable.start();



        // view animation
        Animation hyperspaceJump = AnimationUtils.loadAnimation(
                this, R.anim.slide_out);

        imgObj.startAnimation(hyperspaceJump);


    }
}
