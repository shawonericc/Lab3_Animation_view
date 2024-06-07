package com.example.lab3_animation_view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button rotateButton;
    private Button jumpButton;
    private boolean isRotating = false;
    private RotateAnimation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        rotateButton = findViewById(R.id.rotateButton);
        jumpButton = findViewById(R.id.jumpButton);

        rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000); // duration in milliseconds
        rotateAnimation.setRepeatCount(Animation.INFINITE); // repeat indefinitely

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRotating) {
                    imageView.clearAnimation();
                    rotateButton.setText("Rotate");
                } else {
                    imageView.startAnimation(rotateAnimation);
                    rotateButton.setText("Stop");
                }
                isRotating = !isRotating;
            }
        });

        jumpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation jumpAnimation = new TranslateAnimation(
                        0, 0,
                        0, -200); // move upward by 200 pixels
                jumpAnimation.setDuration(500); // duration in milliseconds
                jumpAnimation.setRepeatCount(1);
                jumpAnimation.setRepeatMode(Animation.REVERSE); // come back to original position
                imageView.startAnimation(jumpAnimation);
            }
        });
    }
}
