package com.mysterionnh.allmuffin;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.AnalogClock;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Just as Countdown, it's partner, it has a dream too. Cool stuff 's supposed to happen here some
 * day soon(TM)
 */
public class TimerActivity extends BaseActivity {

    /** A hack used to get the context of this Activity in places where I need it put am not allowed
     * to get it. Sad life.
     */
    private final Context mContext = (Context) this;
    TextView digitalClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        digitalClock = (TextView) findViewById(R.id.currentTime);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.futureClock);
        Clock clock = new Clock(mContext);
        //clock.setScaleX(1.3f);
        //clock.setScaleY(1.3f);
        clock.setSoundEffectsEnabled(true);
        frameLayout.addView(clock);

        timeToast();
    }

    public void timeToast() {
        Toast toast = Toast.makeText(mContext,
                new SimpleDateFormat("dd.MM.yyyy, hh:mm:ss.SSS", Locale.GERMANY).format(Calendar.getInstance().getTime()),
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public class Clock extends AnalogClock {

        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm", Locale.GERMANY);

        public Clock(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            digitalClock.setText(simpleDateFormat.format(Calendar.getInstance().getTime()));
            super.onDraw(canvas);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            timeToast();
            return super.onTouchEvent(event);
        }
    }
}

// print it somewhere?
//   best thing would be an analogue clock but meh... I will see
//       maybe an extra project/class (do I need a thread? possibly)
//       maybe an image off a clock I overlay a line, representing the hand
//       turning it relative to time
// calculate distance to given end time
// when not negative (damn users)
//  display on clock?
// print timer (down to seconds) - extra thread?
//
// other way round, so give timer and calculate and, otherwise same as above
//
// conclusion:
// TODO:       learn about threads, you will definitely need them this time

// TODO:       DAMN GRAPHICS!!!!!! mep .-.